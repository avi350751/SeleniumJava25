package findelements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentFindElements {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.linkText("New user? Signup")).click();
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int noOfCheckboxes = checkboxes.size();
		if(noOfCheckboxes > 5) {
			System.out.println("There are more than 5 checkboxes");
		} else {
			System.out.println("There are not more than 5 checkboxes");
		}
		
		List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@type='radio']"));
		int noOfRadioBtns = radioBtns.size();
		if(noOfRadioBtns == 2) {
			System.out.println("There are two radio buttons");
		} else {
			System.out.println("There are not two radio buttons");
		}
		
		WebElement state = driver.findElement(By.id("state"));
		Select selectState = new Select(state);
		int noOfStates = selectState.getOptions().size();
		
		System.out.println("Number of states: " + noOfStates);
		if(noOfStates > 20 ) {
			System.out.println("There are more than 20 states");
		} else {
			System.out.println("Incorrect no of states");
		}
		
		List<WebElement> stateOptions = selectState.getOptions();
		for(WebElement option : stateOptions) {
			String stateName = option.getText();
			if(stateName.equals("Goa")){
				System.out.println("State is Goa");
				break;
		}
		
	}

		driver.quit();
}
}
