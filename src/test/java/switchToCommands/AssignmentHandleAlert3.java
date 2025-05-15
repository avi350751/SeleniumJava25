package switchToCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AssignmentHandleAlert3 {

	public static void main(String[] args) {


		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//ul/li/button[text()='Click for JS Prompt']")).click();

		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		if(altText.contains("JS Prompt")) {
			System.out.println("Alert text is correct");
		}
		else {
			System.out.println("Alert text is incorrect");
		}
		System.out.println("Alert text: " + altText);
		alt.sendKeys("Selenium");
		alt.accept();
		String resultText = driver.findElement(By.id("result")).getText();
		if(resultText.contains("Selenium")) {
			System.out.println("Result text is correct");
		}
		else {
			System.out.println("Result text is incorrect");
		}
		
		driver.close();
	}

}
