import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase06 {

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
