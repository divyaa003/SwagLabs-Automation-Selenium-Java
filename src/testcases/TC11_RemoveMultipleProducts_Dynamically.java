package testcases;
import utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC11_RemoveMultipleProducts_Dynamically {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://saucedemo.com/");
		
		//login
		ReusableMethods.login(driver);
		
		//Add 3 products dynamically
		String[] products = {
				"sauce-labs-backpack",
				"sauce-labs-bike-light",
				"sauce-labs-bolt-t-shirt"
		};
		ReusableMethods.addMultipleProducts(driver, products);
		
		//opening cart
		ReusableMethods.openCart(driver);
		
		//Removing 2 Products dynamically
		String[] productsToBeRemoved = {
				"sauce-labs-backpack",
				"sauce-labs-bike-light",
		};
		
		ReusableMethods.removeMultipleProducts(driver, productsToBeRemoved);
		
		//verify removed products are not present in cart
		ReusableMethods.verifyMultipleProductsNotInCart(driver, productsToBeRemoved);
		
		ReusableMethods.verifyMultipleProducts(driver, products);
		//verify cart count
		System.out.println("Cart Count: " + ReusableMethods.getCartCount(driver));
		
		driver.quit();

	}

}
