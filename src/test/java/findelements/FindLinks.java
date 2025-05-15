package findelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLinks {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> elements = driver.findElements(By.xpath("//a[@href]"));
		System.out.println("Number of links: " + elements.size());
		
		
		for (WebElement element : elements) {
			String linkText = element.getText();
			String hrefValue = element.getDomAttribute("href");
			System.out.println("Link Text: " + linkText);
			System.out.println("Href Value: " + hrefValue);
		}

		driver.quit();
	}
	}

	
