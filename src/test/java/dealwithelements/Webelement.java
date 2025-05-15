package dealwithelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelement {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.get("https://www.facebook.com");
		driver.get("https://www.amazon.com");
		driver.get("https://www.flipkart.com");
		
		driver.navigate().back();
		driver.navigate().back();
		driver.getCurrentUrl();
		driver.getTitle();
		driver.navigate().forward();
		driver.getTitle();
		driver.quit();
	}

}
