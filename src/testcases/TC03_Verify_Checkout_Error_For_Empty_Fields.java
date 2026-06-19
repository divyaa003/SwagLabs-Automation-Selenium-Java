package testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ReusableMethods;

public class TC03_Verify_Checkout_Error_For_Empty_Fields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com");
		
		ReusableMethods.login(driver);
		ReusableMethods.addBackpackToCart(driver);
		ReusableMethods.openCart(driver);
		
//		ReusableMethods.checkoutOverview(driver, "", "Renganathan", "600096");
		driver.findElement(By.id("continue")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText());
		
		driver.quit();
	}

}
