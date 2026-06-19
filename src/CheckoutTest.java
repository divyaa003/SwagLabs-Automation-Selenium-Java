import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		
		//Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		if(driver.findElement(By.className("title")).getText().equals("Products")) {
			System.out.println("Logged in");
		}
		else {
			System.out.println("Login failed");
		}
		//Add backpack to cart
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		if(cartCount.equals("1")) {
		System.out.println("backpack added to cart");
		}
		else {
			System.out.println("backpack not added properly");
		}
		
		//open cart
		driver.findElement(By.className("shopping_cart_link")).click();
		if(driver.findElement(By.className("title")).getText().equals("Your Cart")) {
			System.out.println("cart opened");
		}
		else {
			System.out.println("cart didnt opened preperly");
		}
		
		//verifying cart item
		String itemMatch = driver.findElement(By.id("item_4_title_link")).getText();
		if(itemMatch.equals("Sauce Labs Backpack")) {
			System.out.println("Item matched");
		}
		else {
			System.out.println("Item not matched");
		}
		
		//checkout
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Divya");
		driver.findElement(By.id("last-name")).sendKeys("Renganathan");
		driver.findElement(By.id("postal-code")).sendKeys("600097");
		driver.findElement(By.id("continue")).click();
		String title = driver.findElement(By.className("title")).getText();
		if(title.equals("Checkout: Overview")) {
			System.out.println(title);
		}
		else {
			System.out.println("Title not match");
		}
		
		//checkout complete
		driver.findElement(By.id("finish")).click();
		if(driver.findElement(By.className("title")).getText().equals("Checkout: Complete!")) {
			System.out.println("checkout complete page opened");
		}
		else {
			System.out.println("checkout complete page not opened");
		}
		String successMsg = driver.findElement(By.className("complete-header")).getText();
		if(successMsg.equals("Thank you for your order!")) {
			System.out.println(successMsg);
		}
		else {
			System.out.println("Success message not displayed");
		}
		String backHome = driver.findElement(By.id("back-to-products")).getText();
		if(backHome.equals("Back Home")) 
		{
			System.out.println("Back Home button exists");
			driver.findElement(By.id("back-to-products")).click();
			if(driver.findElement(By.className("title")).getText().equals("Products")) 
			{
				System.out.println("came back to products listing page");
			}
			else {
				System.out.println("not back to products listing page");
			}
		}
		else {
			System.out.println("Back home button not exists");
		}
		driver.close();
		
	}

}
