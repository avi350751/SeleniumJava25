package switchToTabsWindows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleWindowAssignment {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("email1")).sendKeys("admin@email.com");
		driver.findElement(By.name("password1")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement element = driver.findElement(By.xpath("//div[@class='nav-menu-item-manage']/span[text()='Manage']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		WebElement category = driver.findElement(By.xpath("//a[text()='Manage Categories']"));
		action.moveToElement(category).click().build().perform();
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window is: " + parent_window);
		
		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("Total number of windows: " + all_windows);
		
		for(String handle: all_windows) {
			driver.switchTo().window(handle);
			System.out.println("Current window is: "+handle);
			
			String title = driver.getTitle();
			System.out.println("Current title is: "+title);
			if(title.contains("Facebook")) {
				break;
			}
		}
		
		
		

	}

}
