import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase05 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//Login
		ReusableMethods.login(driver);
		
		//add backpack to cart
		ReusableMethods.addBackpackToCart(driver);
		
		//open cart
		ReusableMethods.openCart(driver);
		
		//checkout without first name
//		ReusableMethods.verifyCheckoutWithoutLastName(driver);
		
		driver.quit();
		
	}

}
