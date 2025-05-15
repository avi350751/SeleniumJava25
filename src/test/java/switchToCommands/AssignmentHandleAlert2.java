package switchToCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AssignmentHandleAlert2 {

	public static void main(String[] args) {


		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//ul/li/button[text()='Click for JS Confirm']")).click();

		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		if(altText.contains("JS Confirm")) {
			System.out.println("Alert text is correct");
		}
		else {
			System.out.println("Alert text is incorrect");
		}
		System.out.println("Alert text: " + altText);
		alt.dismiss();
		
		driver.close();		
		
	}

}
