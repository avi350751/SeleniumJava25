package switchToCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alt = driver.switchTo().alert();
		
		String altText = alt.getText();
		System.out.println("Alert text: " + altText);
		
		if(altText.equals("Please enter a valid user name")) {
			System.out.println("Alert text is correct");
		} else {
			System.out.println("Alert text is incorrect");
		}
		
		alt.accept();
		//alt.dismiss();
		//alt.sendKeys("Hello");
		
		

	}

}
