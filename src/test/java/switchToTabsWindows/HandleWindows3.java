package switchToTabsWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HandleWindows3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		
		String parent_window = driver.getWindowHandle();
		System.out.println("Parent window is: " + parent_window);
		
		driver.findElement(By.xpath("//div[@class='social']//a[contains(@href,'linkedin')]")).click();

		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("Total number of windows: " + all_windows);
		Iterator<String> itr = all_windows.iterator();
		
		while(itr.hasNext()) {
			String child_window = itr.next();
			if(!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-modal='base-sign-in-modal']")).click();
		
		
		driver.close();
		driver.switchTo().window(parent_window);
		driver.quit();

}
}
