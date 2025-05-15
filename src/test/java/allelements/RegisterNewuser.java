package allelements;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterNewuser {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String title = driver.getTitle();
		if (title.contains("demo")){
				System.out.println("Title is correct");
		} else {
			System.out.println("Title is incorrect");
		}
		driver.findElement(By.linkText("Register")).click();
		
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("register")){
				System.out.println("URL is correct");
		} else {
			System.out.println("URL is incorrect");
		}
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));
		for (WebElement element : elements) {
			if(element.isSelected()) {
				System.out.println("Gender not selected");
				
			}
			else {
				System.out.println("Gender is selected");
			}
		}
		
		driver.findElement(By.xpath("//input[@type='radio'][@id='gender-male']")).click();
		
		driver.findElement(By.id("FirstName")).sendKeys("John");
		driver.findElement(By.id("LastName")).sendKeys("Bhattacharjee");
		
		String email = "avi"+Instant.now().getEpochSecond()+"dlx.com";
		driver.findElement(By.name("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys("GGMU123");
		
		WebElement newsLetter = driver.findElement(By.id("Newsletter"));
		if(newsLetter.isSelected()) {
			System.out.println("Newsletter is selected");
			newsLetter.click();
		} else {
			System.out.println("Newsletter is not selected");
		}
		
		driver.findElement(By.id("Password")).sendKeys("admin123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("admin123");
		
		WebElement registerButton = driver.findElement(By.id("register-button"));
		if(registerButton.getText().equals("Register")) {
			System.out.println("Register button is displayed");
			registerButton.click();
		} else {
			System.out.println("Register button is not displayed");
		}
		
		driver.quit();

	}

}
