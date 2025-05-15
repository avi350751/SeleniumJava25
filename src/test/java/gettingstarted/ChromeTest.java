package gettingstarted;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/documentation/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Page title is: " + title);
		
		if(title.contains("Browser Automation")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
		driver.quit();
		

	}

}
