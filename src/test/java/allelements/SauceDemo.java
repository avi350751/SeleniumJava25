package allelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> pricetags = driver.findElements(By.className("inventory_item_price"));
		for(WebElement element : pricetags) {
			String price = element.getText();
			System.out.println("Price: " + price);
		}
		
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(@class,'btn_primary')]"));
		for(WebElement btn : addToCartButtons) {
			String addToCart = btn.getText();
			if(addToCart.equals("ADD TO CART")) {
				btn.click();
			}
		}
		
		List<WebElement> socialMediaBtns = driver.findElements(By.xpath("//ul[@class='social']/li"));
		for(WebElement socialMediaBtn : socialMediaBtns) {
			String socialMedia = socialMediaBtn.getText();
			System.out.println("Social Media: " + socialMedia);
		}
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		
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
		
		driver.quit();

	}

}
