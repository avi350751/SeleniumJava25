package switchToTabsWindows;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window is: " + parent_window);
		
		

		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("Total number of windows: " + all_windows);
		
		
	}

}
