package testcases;
import utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_Verify_End_To_End_Checkout {

		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.get("https://saucedemo.com/");
			ReusableMethods.login(driver);
			ReusableMethods.addBackpackToCart(driver);
			ReusableMethods.openCart(driver);
			ReusableMethods.checkout(driver);
			ReusableMethods.completeOrder(driver);
			driver.close();
		}

}
