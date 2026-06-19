import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		// Scenario 1
//		Login
//		↓
//		Add Backpack to Cart
//		↓
//		Read Cart Badge Text
//		↓
//		If badge = "1"
//		    Print "Product Added Successfully"
//		Else
//		    Print "Product Not Added"
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		if(driver.findElement(By.className("title")).getText().equals("Products")) {
			System.out.println("Login passed");
		}
		else {
			System.out.println("Login failed");
	}
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		String CartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
		if(CartCount.equals("1")) {
			System.out.println("Item added to cart successfully");
		}
		else {
			System.out.println("Item not added");
		}
//		Scenario 2
//		Login
//		↓
//		Add Backpack
//		↓
//		Verify Cart Count = 1
//		↓
//		Click Remove
//		↓
//		Verify Cart Badge Disappears
//		↓
//		Print Pass/Fail
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		int CartBadgeCount = driver.findElements(By.className("shopping_cart_badge")).size();
		if(CartBadgeCount > 0) {
			System.out.println("Removal fails");
		}
		else {
			System.out.println("Removal Passed");
		}
		
//		Scenario 3
//		Login
//		↓
//		Add Backpack
//		↓
//		Add Bike Light
//		↓
//		Add Bolt T-Shirt
//		↓
//		Verify Cart Count = 3
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		if(driver.findElement(By.className("shopping_cart_badge")).getText().equals("3")) {
			System.out.println("its 3");
		}
		else {
			System.out.println(driver.findElement(By.className("shopping_cart_badge")).getText());
			}
		
		driver.close();
}
}
