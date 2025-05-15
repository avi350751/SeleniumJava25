package allelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SauceDemoXpathAxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*Login*/
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		/*Verify Login*/
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("inventory")) {
			System.out.println("Login is successfull");
		}
		else {
			System.out.println("Login is not successfull");
		}
		
		/*Add to cart- a particular product*/
		WebElement priceElement = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']/div[@class='pricebar']/div[@class='inventory_item_price']"));
		String priceOfProduct = priceElement.getText();
		System.out.println("Price of the product is: " + priceOfProduct);
		
		Thread.sleep(1000);
		WebElement addToCartButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item']/div[@class='pricebar']/button[contains(@class,'btn_primary')]"));
		addToCartButton.click();
		
		WebElement priceElement2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']/div[@class='pricebar']/div[@class='inventory_item_price']"));
		String priceOfProduct2 = priceElement2.getText();
		System.out.println("Price of the product is: " + priceOfProduct2);
		
		Thread.sleep(1000);
		WebElement addToCartButton2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']/div[@class='pricebar']/button[contains(@class,'btn_primary')]"));
		addToCartButton2.click();
		
		/*Cart count*/
		WebElement cartCount = driver.findElement(By.xpath("//div[@id='shopping_cart_container']//span[contains(@class,'shopping_cart_badge')]"));
		String cartCountValue = cartCount.getText();
		System.out.println("Cart count is: " + cartCountValue);
		
		if (cartCountValue.equals("2")) {
			System.out.println("Cart count is correct");
		}
		else {
			System.out.println("Cart count is not correct");
		}
		
		/*Click on cart*/
		WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
		cartButton.click();
		
		/*Checkout*/
		driver.findElement(By.linkText("CHECKOUT")).click();
		
		/*Enter checkout information*/
		driver.findElement(By.id("first-name")).sendKeys("Avinash");
		driver.findElement(By.id("last-name")).sendKeys("Kumar");
		driver.findElement(By.id("postal-code")).sendKeys("500062");
		
		
		/*Continue*/
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		/*Verify checkout information*/
		WebElement totalPriceField = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
		String totalPrice = totalPriceField.getText().replace("Total: $", "");
		if (totalPrice.equals("64.78")) {
			System.out.println("Right products are in the cart");
			}
		else {
			System.out.println("Wrong products are in the cart");
			System.out.println("Total price is correct");
		}
		
		WebElement finishButton = driver.findElement(By.xpath("//div[@class='cart_footer']/a[contains(@class,'cart_button')]"));
		finishButton.click();
		
		WebElement purchasemsg = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2"));
		String purchaseMessage = purchasemsg.getText();
		if (purchaseMessage.equals("THANK YOU FOR YOUR ORDER")) {
			System.out.println("Order is placed successfully");
		}
		else {
			System.out.println("Order is not placed successfully");
		}
		
		List<WebElement> menuItems = driver.findElements(By.xpath("//a[contains(@id,'_sidebar_link')]"));
		for(WebElement menuItem : menuItems) {
			if(menuItem.isEnabled()) {
				System.out.println("Menu Item: " + menuItem.getText());
				if(menuItem.getText().equals("Logout")) {
					menuItem.click();
					break;
				}
			}
		}
			
		String nowUrl = driver.getCurrentUrl();
		if (nowUrl.contains("index.html")) {
			System.out.println("Logout is successfull");
		}
		else {
			System.out.println("Logout is not successfull");
		}
		
		
		driver.quit();
		
}
}
