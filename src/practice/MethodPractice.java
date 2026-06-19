package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MethodPractice {
	
	//Login Function
	public static void login(WebDriver driver) {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String mainPageTitle = driver.findElement(By.className("title")).getText();
		if(mainPageTitle.equals("Products")) {
			System.out.println("Login success !");
		}
		else {
			System.out.println("Login not success :(");
		}
	}
	
	//Adding backpack to cart 
	public static void addBackpackToCart(WebDriver driver) {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		if(cartCount.equals("1")) {
			System.out.println("Added backpack to cart !");
		}
		else {
			System.out.println("Backpack not added properly :(");
		}
	}
	
	//opening cart 
	public static void openCart(WebDriver driver) {
		driver.findElement(By.className("shopping_cart_link")).click();
		String cartPageTitle = driver.findElement(By.className("title")).getText();
		if(cartPageTitle.equals("Your Cart")) {
			System.out.println("Cart opened !");
		}
		else {
			System.out.println("cart not opened properly :)");
		}
	}
	
	//checkout
	public static void checkout(WebDriver driver) {
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Divya");
		driver.findElement(By.id("last-name")).sendKeys("Renganathan");
		driver.findElement(By.id("postal-code")).sendKeys("600097");
		driver.findElement(By.id("continue")).click();
		String checkoutOverviewTitle = driver.findElement(By.className("title")).getText();
		if(checkoutOverviewTitle.equals("Checkout: Overview")){
			System.out.println("checkout overview screen opened !");
		}
		else {
			System.out.println("issue with Checkout overview screen :(");
		}
	}
	
	public static void completeOrder(WebDriver driver) {
		driver.findElement(By.id("finish")).click();
		String checkoutCompleteTitle = driver.findElement(By.className("title")).getText();
		String completeSuccessMsg = driver.findElement(By.className("complete-header")).getText();
		if(checkoutCompleteTitle.equals("Checkout: Complete!") && completeSuccessMsg.equals("Thank you for your order!")) {
			System.out.println("checkout complete page opened !");
		}
		else {
			System.out.println("Problem with checkout complete page");
		}
		driver.findElement(By.id("back-to-products")).click();
		String backToHome = driver.findElement(By.className("title")).getText();
		if(backToHome.equals("Products")) {
			System.out.println("Yah, Back to Home !!!!");
		}
		else {
			System.out.println("Issue with back to home !");
		}
		
	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://saucedemo.com/");
		login(driver);
		addBackpackToCart(driver);
		openCart(driver);
		checkout(driver);
		completeOrder(driver);
		
		driver.close();
	}

}
