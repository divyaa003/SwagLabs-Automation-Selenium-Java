
package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods {

	// =========================================
	// LOGIN METHODS
	// =========================================

	public static void login(WebDriver driver) {

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		String mainPageTitle = driver.findElement(By.className("title")).getText();

		if (mainPageTitle.equals("Products")) {
			System.out.println("Login success !");
		} else {
			System.out.println("Login not success :(");
		}
	}

	// =========================================
	// PRODUCT METHODS
	// =========================================

	public static void addBackpackToCart(WebDriver driver) {

		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		System.out.println("Backpack added to cart");
	}

	public static void addBikeLightToCart(WebDriver driver) {

		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		System.out.println("Bike light added to cart");
	}

	public static void addProductToCart(WebDriver driver, String ProductId) {

		driver.findElement(By.id("add-to-cart-" + ProductId)).click();
		System.out.println(ProductId+" added");
	}

	public static void removeBackpackFromCart(WebDriver driver) {

		driver.findElement(By.id("remove-sauce-labs-backpack")).click();

		int cartCount = driver.findElements(By.className("shopping_cart_badge")).size();

		if (cartCount > 0) {
			System.out.println("Backpack not removed properly !");
		} else {
			System.out.println("Backpack removed successfully and shopping cart is empty !");
		}
	}

	// =========================================
	// CART METHODS
	// =========================================

	public static void openCart(WebDriver driver) {

		driver.findElement(By.className("shopping_cart_link")).click();

		String cartPageTitle = driver.findElement(By.className("title")).getText();

		if (cartPageTitle.equals("Your Cart")) {
			System.out.println("Cart opened !");
		} else {
			System.out.println("Cart not opened properly");
		}
	}

	public static String getCartCount(WebDriver driver) {

		return driver.findElement(By.className("shopping_cart_badge")).getText();
	}

	public static void verifyCartCount(WebDriver driver, String expectedCount) {

		String actualCount = getCartCount(driver);

		if (actualCount.equals(expectedCount)) {
			System.out.println("Items added to cart successfully. Verified !");
		} else {
			System.out.println("Issue with items adding to cart !");
		}

		System.out.println("Expected count: " + expectedCount +
				", Actual count: " + actualCount);
	}

	public static String getBackpackTitle(WebDriver driver) {

		return driver.findElement(By.id("item_4_title_link")).getText();
	}

	public static String getBikeLightTitle(WebDriver driver) {

		return driver.findElement(By.id("item_0_title_link")).getText();
	}

	public static void verifyProductInCart(WebDriver driver, String expectedProduct) {

		List<WebElement> items =
				driver.findElements(By.className("inventory_item_name"));

		boolean isProduct = false;

		for (WebElement actualProduct : items) {

			if (actualProduct.getText().equals(expectedProduct)) {
				isProduct = true;
				break;
			}
		}

		if (isProduct) {
			System.out.println(expectedProduct + " is present in cart");
		} else {
			System.out.println(expectedProduct + " is not present in cart");
		}
	}
	
	//Verifying multiple products dynamically [Its a powerful logic 🔥]
	public static void verifyMultipleProducts(WebDriver driver, String[] expectedProducts) {
		for(String product : expectedProducts) {
			verifyProductInCart(driver, product);
		}
	}
	

	// =========================================
	// CHECKOUT METHODS
	// =========================================

	public static void checkout(WebDriver driver) {

		driver.findElement(By.id("checkout")).click();

		driver.findElement(By.id("first-name")).sendKeys("Divya");
		driver.findElement(By.id("last-name")).sendKeys("Renganathan");
		driver.findElement(By.id("postal-code")).sendKeys("600097");

		driver.findElement(By.id("continue")).click();

		String checkoutOverviewTitle =
				driver.findElement(By.className("title")).getText();

		if (checkoutOverviewTitle.equals("Checkout: Overview")) {
			System.out.println("Checkout overview screen opened !");
		} else {
			System.out.println("Issue with Checkout overview screen :(");
		}
	}

	public static void completeOrder(WebDriver driver) {

		driver.findElement(By.id("finish")).click();

		String checkoutCompleteTitle =
				driver.findElement(By.className("title")).getText();

		String completeSuccessMsg =
				driver.findElement(By.className("complete-header")).getText();

		if (checkoutCompleteTitle.equals("Checkout: Complete!")
				&& completeSuccessMsg.equals("Thank you for your order!")) {

			System.out.println("Checkout complete page opened !");
		} else {
			System.out.println("Problem with checkout complete page");
		}

		driver.findElement(By.id("back-to-products")).click();

		String backToHome =
				driver.findElement(By.className("title")).getText();

		if (backToHome.equals("Products")) {
			System.out.println("Back to Home successful !");
		} else {
			System.out.println("Issue with Back to Home !");
		}
	}

	public static void verifyCheckoutError(
			WebDriver driver,
			String firstName,
			String lastName,
			String postalCode,
			String expectedError) {

		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);

		driver.findElement(By.id("continue")).click();

		String actualError =
				driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

		System.out.println(actualError);

		if (actualError.equals(expectedError)) {
			System.out.println("Error displayed correctly");
		} else {
			System.out.println("Error displayed wrongly");
		}
	}

	// =========================================
	// NAVIGATION METHODS
	// =========================================

	// Method Composition Example
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
		
		String checkoutTitle =
				driver.findElement(By.cssSelector("span[data-test='title']")).getText();

		System.out.println("Actual title: " + checkoutTitle);

		if (checkoutTitle.equals("Checkout: Your Information")) {
			System.out.println("Title matches");
		} else {
			System.out.println("Title not matched");
		}
	}
	
	public static void removeProductFromCart(WebDriver driver, String productId) {
		driver.findElement(By.id("remove-sauce-labs-"+productId)).click();;
		System.out.println(productId + " removed from cart");
	}
	
	//Adding multiple products dynamically
	public static void addMultipleProducts(WebDriver driver, String[] productIds) {
		for(String product : productIds) {
			driver.findElement(By.id("add-to-cart-" + product)).click();
			System.out.println(product + " added to cart");
		}
		System.out.println("Items added to cart. cart count: "+getCartCount(driver));
	}
	
	//remove multiple products dynamically
	public static void removeMultipleProducts(WebDriver driver, String[] removeProducts) {
		for(String product : removeProducts) {
			driver.findElement(By.id("remove-"+product)).click();
			System.out.println(product + " Item removed");
		}
		System.out.println("Items removed. Cart count: "+getCartCount(driver));
	}
	
	public static void verifyProductNotInCart(WebDriver driver, String expectedProduct) {

		List<WebElement> items =
				driver.findElements(By.className("inventory_item_name"));

		boolean isProduct = false;

		for (WebElement actualProduct : items) {

			if (actualProduct.getText().equals(expectedProduct)) {
				isProduct = true;
				break;
			}
		}

		if (isProduct) {
			System.out.println(expectedProduct + " is present in cart");
		} else {
			System.out.println(expectedProduct + " is removed from cart");
		}
	}
	
	public static void verifyMultipleProductsNotInCart(WebDriver driver, String[] productsToBeRemoved) {
		for(String product : productsToBeRemoved) {
			verifyProductNotInCart(driver, product);
		}
	}
	
	public static void verifyCartProductsPresent(WebDriver driver, String Product) {
		verifyProductInCart(driver, Product);
	}
	
	
}










