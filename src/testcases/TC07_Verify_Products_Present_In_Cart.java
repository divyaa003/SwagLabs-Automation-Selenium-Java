package testcases;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC07_Verify_Products_Present_In_Cart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		ReusableMethods.login(driver);
		
		ReusableMethods.addProductToCart(driver, "sauce-labs-backpack");
		ReusableMethods.addProductToCart(driver, "sauce-labs-bike-light");
		ReusableMethods.openCart(driver);
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Backpack");
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Bike Light");
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Fleece Jacket");
		
//		ReusableMethods.addProductToCart(driver, "sauce-labs-bike-light");
//		ReusableMethods.openCart(driver);
//		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Bike Light");
		
//		if(ReusableMethods.getCartCount(driver).equals("3")) {
//			System.out.println("cart badge: three");
//		}
//		else {
//			System.out.println("cart badge: "+ReusableMethods.getCartCount(driver));
//		}
		//ReusableMethods.verifyCartCount(driver, "2");

		driver.quit();
		
	}

}
