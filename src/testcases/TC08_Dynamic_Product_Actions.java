package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC08_Dynamic_Product_Actions {

	public static void main(String[] args) {
		
//		Scenario:
//			Login
//			Add Backpack
//			Add Bike Light
//			Remove Backpack
//			Verify Cart Count = 1
//			Verify Bike Light still exists in cart
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//Login
		ReusableMethods.login(driver);
		
		//add backpack & bike light
		ReusableMethods.addProductToCart(driver, "sauce-labs-backpack");
		ReusableMethods.addProductToCart(driver, "sauce-labs-bike-light");
		
		//Checking whether products added to cart
		if(ReusableMethods.getCartCount(driver).equals("2")) {
			System.out.println("Both backpack and bike light added to cart");
			
			//Removing backpack from cart
			ReusableMethods.removeProductFromCart(driver, "backpack");
			
			//checking whether backpack removed from cart
			if(ReusableMethods.getCartCount(driver).equals("1")) {
				//opening cart
				ReusableMethods.openCart(driver);
				
				//verifying whether bike light present in cart
				ReusableMethods.verifyProductInCart(driver, "Sauce Labs Bike Light");
				
				//verifying backpack present in cart
				ReusableMethods.verifyProductInCart(driver, "Sauce Labs Backpack");
			}
			else {
				System.out.println("backpack not removed from cart. cart count: "+ReusableMethods.getCartCount(driver));
			}
		}
		else {
			System.out.println("Products not added properly to cart");
		}
		
		driver.quit();
		
	}

}
