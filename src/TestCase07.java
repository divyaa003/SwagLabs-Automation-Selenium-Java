import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		ReusableMethods.login(driver);
		ReusableMethods.addProductToCart(driver, "sauce-labs-bike-light");
		ReusableMethods.addProductToCart(driver, "sauce-labs-backpack");
		ReusableMethods.addProductToCart(driver, "sauce-labs-bolt-t-shirt");
//		if(ReusableMethods.getCartCount(driver).equals("3")) {
//			System.out.println("cart badge: three");
//		}
//		else {
//			System.out.println("cart badge: "+ReusableMethods.getCartCount(driver));
//		}
		ReusableMethods.verifyCartCount(driver, "3");
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Backpack");
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Bike Light");
		ReusableMethods.verifyProductInCart(driver, "Sauce Labs Bolt T-Shirt");
		driver.quit();
		
	}

}
