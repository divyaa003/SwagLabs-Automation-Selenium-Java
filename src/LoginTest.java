import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		//----------Valid Login------------
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		if(driver.findElement(By.className("title")).getText().equals("Products")) {
			System.out.println("Login passed");
		}
		else {
			System.out.println("Login failed");
		}
		//Logout process
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logout done");
		
		//----------In-Valid Login------------
		driver.findElement(By.id("user-name")).sendKeys("divya");
		driver.findElement(By.id("password")).sendKeys("divyarun");
		driver.findElement(By.id("login-button")).click();
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		//------------Empty Credentials Login----------------
		driver.navigate().refresh();
		driver.findElement(By.id("login-button")).click();
		System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
		
		driver.close();
		
	}

}
