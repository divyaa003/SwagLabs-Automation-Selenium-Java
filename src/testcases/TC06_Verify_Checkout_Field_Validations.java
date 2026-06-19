package testcases;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC06_Verify_Checkout_Field_Validations {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		ReusableMethods.navigateToCheckout(driver);
		
		//checkout without first name
		ReusableMethods.verifyCheckoutError(driver,"","Renganathan","600096", "Error: First Name is required");
		
//		ReusableMethods.verifyCheckoutError(driver, "Divya","","600096","Error: Last Name is required");
//		
//		ReusableMethods.verifyCheckoutError(driver, "", "Renganathan", "600096", "Error: First Name is required");
		
		driver.quit();
		
	}

}
