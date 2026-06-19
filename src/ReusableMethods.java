import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

		//Login
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
		
		//Cart count
		public static String getCartCount(WebDriver driver) {
			return driver.findElement(By.className("shopping_cart_badge")).getText();
		}
		
		//Backpack Title
		public static String getBackpackTitle(WebDriver driver) {
			return driver.findElement(By.id("item_4_title_link")).getText();
		}
		
		//Bike light title
		public static String getBikeLightTitle(WebDriver driver) {
			return driver.findElement(By.id("item_0_title_link")).getText();
		}
		
		//Adding backpack to cart 
		public static void addBackpackToCart(WebDriver driver) {
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			System.out.println("backpack added to cart");
		}
		
		//Adding Bike light to cart
		public static void addBikeLightToCart(WebDriver driver) {
			driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
			System.out.println("Bikelight added to cart");
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
		
//		checkout
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
		
		public static void removeBackpackFromCart(WebDriver driver) {
			driver.findElement(By.id("remove-sauce-labs-backpack")).click();
			int cartCount = driver.findElements(By.className("shopping_cart_badge")).size();
			if(cartCount > 0) {
				System.out.println("Backpack not removed properly !");
			}
			else {
				System.out.println("Backpack removed successfully and shopping cart is empty !");
			}
		}
		
//		public static void checkoutOverview(WebDriver driver, String firstName, String lastName, String pinCode) {
//			driver.findElement(By.id("shopping_cart_container")).click();
//			driver.findElement(By.id("checkout")).click();
//			driver.findElement(By.id("first-name")).sendKeys(firstName);
//			driver.findElement(By.id("last-name")).sendKeys(lastName);
//			driver.findElement(By.id("postal-code")).sendKeys(pinCode);
//		}
		
		public static void verifyCheckoutError(WebDriver driver, String firstName, String lastName, String postalCode, String expectedError) {
			driver.findElement(By.id("first-name")).sendKeys(firstName);
			driver.findElement(By.id("last-name")).sendKeys(lastName);
			driver.findElement(By.id("postal-code")).sendKeys(postalCode);
			driver.findElement(By.id("continue")).click();
			String actualError = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
			System.out.println(actualError);
			if(actualError.equals(expectedError)) {
				System.out.println("Error displayed correctly");
			}
			else {
				System.out.println("Error displayed wrongly");
			}
		}
		
		//We are calling reusable methods from another reusable method. This is called Method Composition.
		public static void navigateToCartWithBackpack(WebDriver driver) {
			login(driver);
			addBackpackToCart(driver);
			openCart(driver);
		}
		
		public static void navigateToCheckout(WebDriver driver) {
			login(driver);
			addBackpackToCart(driver);
			openCart(driver);
			driver.findElement(By.id("checkout")).click();
			String checkoutTitle = driver.findElement(By.cssSelector("span[data-test='title']")).getText();
			System.out.println("actual title:" + checkoutTitle);
			if(checkoutTitle.equals("Checkout: Your Information")) {
				System.out.println("title matches");
			}
			else {
				System.out.println("title not matched");
			}
		}
		
		public static void addProductToCart(WebDriver driver, String ProductId) {
			driver.findElement(By.id("add-to-cart-" + ProductId)).click();
			System.out.println("Product added");
		}
		
		public static void verifyCartCount(WebDriver driver, String expectedCount) {
			String actualCount = driver.findElement(By.className("shopping_cart_badge")).getText();
			if(actualCount.equals(expectedCount)) {
				System.out.println("items added to cart successfully. its verified");
			}
			else {
				System.out.println("Issue with items adding to cart !");
			}
			System.out.println("Expected count: "+expectedCount + ", Actual count: " + actualCount);
		}
		
		
		public static void verifyProductInCart(WebDriver driver, String expectedProduct) {
			//int cartCount = Integer.parseInt(ReusableMethods.getCartCount(driver).trim());
			List <WebElement> items = driver.findElements(By.className("inventory_item_name"));
			boolean isProduct = false;
			for(WebElement actualProduct : items) {
				System.out.println(actualProduct.getText());
				if (actualProduct.getText().equals(expectedProduct)) {
					isProduct = true;
					break;
				}
			}
			if(isProduct) {
				System.out.println("product matched");
			}
			else {
				System.out.println("Product not matched");
			}
		}
		
		
		

}
	
