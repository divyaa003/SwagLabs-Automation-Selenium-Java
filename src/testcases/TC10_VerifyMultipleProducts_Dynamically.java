package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC10_VerifyMultipleProducts_Dynamically {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//login
		ReusableMethods.login(driver);
		
		//Add 3 products dynamically
		String[] ProductsId = {
				"sauce-labs-backpack",
				"sauce-labs-bike-light",
				"sauce-labs-bolt-t-shirt"	
				}; 
		
		ReusableMethods.addMultipleProducts(driver, ProductsId);
		
		ReusableMethods.openCart(driver);
		
		String[] expectedNames = {
				"Sauce Labs Backpack",
				"Sauce Labs Bike Light",
				"Sauce Labs Bolt T-Shirt"
		};
		
		ReusableMethods.verifyMultipleProducts(driver, expectedNames);
		
		driver.quit();
		
	}

}
