package testcases;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC05_Verify_Checkout_Error_For_Missing_Last_Name {

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
