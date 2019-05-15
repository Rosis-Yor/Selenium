//7th Exercise

package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
 
public class hiddenEls {
 
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		dr.get("http://www.qaclickacademy.com/practice.php");
		
		dr.findElement(By.cssSelector("#autocomplete")).sendKeys("can");
		Thread.sleep(20000);
		
		JavascriptExecutor js = (JavascriptExecutor) dr;
		
		String script = "return document.getElementById(\"autocomplete\").value";		
		String res = (String) js.executeScript(script);
		int i = 0;	
	
		while (!res.equalsIgnoreCase("Canada")) {			
			dr.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
			res = (String) js.executeScript(script);
			System.out.println(res);
			i++;
			if(i > 9) {
				
				System.out.println("The country is not in this list");
				break;
			}
		}
		
		Assert.assertEquals(res, "Canada");
		dr.findElement(By.cssSelector("#autocomplete")).click();
		dr.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.ENTER);
		System.out.println("Success");
	}
}