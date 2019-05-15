//4th Exercise

package exercises;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class winHandles {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		dr.get("http://the-internet.herokuapp.com");
		dr.findElement(By.linkText("Multiple Windows")).click();
		dr.findElement(By.linkText("Click Here")).click();
		
		Set<String> wins = dr.getWindowHandles();		
		Iterator<String> ir = wins.iterator();		
		
		String initial = ir.next();
		String second = ir.next();
		
		dr.switchTo().window(second);
		String msg = dr.findElement(By.cssSelector("h3")).getText();
		System.out.println(msg);
		dr.switchTo().window(initial);
		String msgF = dr.findElement(By.cssSelector("h3")).getText();
		System.out.println(msgF);		
	}
}