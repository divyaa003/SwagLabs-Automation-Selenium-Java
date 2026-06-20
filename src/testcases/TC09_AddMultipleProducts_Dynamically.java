package testcases;
import utilities.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC09_AddMultipleProducts_Dynamically {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//Login
		ReusableMethods.login(driver);
	
		String[] products = { "sauce-labs-backpack",
				"sauce-labs-bike-light",
				"sauce-labs-bolt-t-shirt"	
		};
		
		ReusableMethods.addMultipleProducts(driver, products);
		
		driver.quit();
	}

}
