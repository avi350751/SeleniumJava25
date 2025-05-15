package allelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewUser {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("New user? Signup")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.name("name")).sendKeys("John Doe");
		driver.findElement(By.name("email")).sendKeys("abc@dlx.com");
		driver.findElement(By.name("password")).sendKeys("abc1234");
		
		List<WebElement> elements = driver.findElements(By.className("interest"));
		for (WebElement element : elements) {
			if (element.getText().equals("Tosca")) {
				element.click();
				break;
			}
		}
		
		driver.findElement(By.id("gender2")).click();
		
		WebElement stateOption = driver.findElement(By.id("state"));
		Select option = new Select(stateOption);
		option.selectByVisibleText("West Bengal");
		
		WebElement hobbiesOption = driver.findElement(By.id("hobbies"));
		Select option1 = new Select(hobbiesOption);
		option1.selectByVisibleText("Reading");
		
		driver.findElement(By.className("submit-btn")).click();

	}

}
