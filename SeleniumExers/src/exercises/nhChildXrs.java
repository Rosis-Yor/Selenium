//8th Exercise

package exercises;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
abstract class nthChildXrs {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe") ;
		
		WebDriver dr = new ChromeDriver();		
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		dr.get("http://www.qaclickacademy.com/practice.php");
		
		WebElement table = dr.findElement(By.cssSelector("#product"));
		
		// task N 1
		int rowCount = table.findElements(By.tagName("tr")).size();
		
		// 2nd task
		WebElement row = dr.findElement(By.cssSelector("table#product tr:nth-child(3)"));
		int colCount = row.findElements(By.tagName("td")).size();
		System.out.println(" rowCount : " + rowCount);
		System.out.println(" colCount : " + colCount);
		
		// 3rd task
		String course = row.findElement(By.cssSelector("td:nth-child(2)")).getText() ;
		
		
		System.out.println(course);
	}
}


