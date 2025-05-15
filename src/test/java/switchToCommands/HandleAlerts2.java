package switchToCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts2 {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("submitSearch")).click();
		
		Alert alt = driver.switchTo().alert();
		
		String altText = alt.getText();
		System.out.println("Alert text: " + altText);
		
		if(altText.equals("Please select start place.")) {
			System.out.println("Alert text is correct");
		} else {
			System.out.println("Alert text is incorrect");
		}
		
		alt.accept();
		//alt.dismiss();
		//alt.sendKeys("Hello");
		
		

	}

}
