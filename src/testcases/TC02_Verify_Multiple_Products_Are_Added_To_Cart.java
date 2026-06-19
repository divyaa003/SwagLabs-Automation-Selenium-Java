package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

public class TC02_Verify_Multiple_Products_Are_Added_To_Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//Login
		ReusableMethods.login(driver);
		
		//Add Backpack
		ReusableMethods.addBackpackToCart(driver);
		
		//Add Bike light
		ReusableMethods.addBikeLightToCart(driver);
		
		Thread.sleep(2000);
		
		//open cart
		ReusableMethods.openCart(driver);
		
		//cart count & verification
		String cartCount = ReusableMethods.getCartCount(driver);
		System.out.println(cartCount);
		String BackpackTitle = ReusableMethods.getBackpackTitle(driver);
		System.out.println(BackpackTitle);
		String BikelightTitle = ReusableMethods.getBikeLightTitle(driver);
		System.out.println(BikelightTitle);
		if(cartCount.equals("2") && BackpackTitle.equals("Sauce Labs Backpack") && BikelightTitle.equals("Sauce Labs Bike Light")) {
			System.out.println("Items added to cart !!");
		}
		else {
			System.out.println("Item not added properly to the cart !");
		}
		
		driver.quit();
		
	}

}
