package switchToTabsWindows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window is: " + parent_window);
		
		List<WebElement> icons = driver.findElements(By.xpath("//div[@id='login_container']//div[@class='social-btns']/a"));
		for(WebElement ele : icons) {
			
			ele.click();
		}
		

		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("Total number of windows: " + all_windows);
		
		
		for(String handle: all_windows) {
			
			driver.switchTo().window(handle);
			String title = driver.getTitle();
			System.out.println("Current title is: "+title);
			if(title.contains("Facebook")) {
				break;
			}
		}
		
		driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("password");
		driver.close();
		driver.switchTo().window(parent_window);
		driver.quit();
	}

}
