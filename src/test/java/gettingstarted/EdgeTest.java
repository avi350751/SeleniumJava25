package gettingstarted;


import org.openqa.selenium.edge.EdgeDriver;

public class EdgeTest {

	public static void main(String[] args) {
		
		EdgeDriver driver = new EdgeDriver();
		
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
