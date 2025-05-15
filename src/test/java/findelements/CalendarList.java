package findelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarList {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("datepicker")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));
		for(WebElement element : elements) {
			String date = element.getText();
			System.out.println("Date is: " +date);
			if(date.equals("15")) {
				element.click();
				break;
			}
		}

	}

}
