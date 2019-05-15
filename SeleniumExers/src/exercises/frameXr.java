//5th Exercise

package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
public class frameXr {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		dr.get("http://the-internet.herokuapp.com");
		
		dr.findElement(By.linkText("Nested Frames")).click();
		
		dr.switchTo().frame(0);
		dr.switchTo().frame(1);
		String msg = dr.findElement(By.tagName("body")).getText();
		System.out.println(msg);
	}
}
