import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		if(driver.findElement(By.className("title")).getText().equals("Products")) {
			System.out.println("Login passed");
		}
		else {
			System.out.println("Login failed");
	}
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		String CartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		if(CartCount.equals("2")) {
			System.out.println("Item added to cart successfully");
		}
		else {
			System.out.println("Item not added");
		}
//		Scenario 2
//		Login
//		↓
//		Add Backpack & bike light
//		↓
//		Verify Cart Count = 2
//		↓
//		Verify item added correctly or not

		driver.findElement(By.className("shopping_cart_link")).click();
		String BackPack = driver.findElement(By.id("item_4_title_link")).getText();
		String BikeLight = driver.findElement(By.id("item_0_title_link")).getText();
		if(BackPack.equals("Sauce Labs Backpack") && BikeLight.equals("Sauce Labs Bike Light"))
		{
			System.out.println("Items added correctly to the cart !");
		}
		else {
			System.out.println("not added properly");
		}
		driver.close();
	}

}
