import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase01 {

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
