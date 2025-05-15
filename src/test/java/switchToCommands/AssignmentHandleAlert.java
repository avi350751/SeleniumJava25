package switchToCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentHandleAlert {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//ul/li/button[text()='Click for JS Alert']")).click();

		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		System.out.println("Alert text: " + altText);
		alt.accept();
		
		driver.close();
	}

}
