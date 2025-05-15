package gettingstarted;

import org.openqa.selenium.chrome.ChromeDriver;

public class RapidFire {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("www.google.com");
		driver.quit();
		
		
		

	}

}
