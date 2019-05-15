// 1st Exercise

package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
 
public class chbXexercise {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		
		WebDriver dr = new ChromeDriver();
		
		dr.get("http://qaclickacademy.com/practice.php");
		WebElement we = dr.findElement(By.xpath("(//div[@id='checkbox-example']//fieldset//input[@type='checkbox'])[2]"));
		we.click();
		Assert.assertTrue(we.isSelected());
		we.click();
		Assert.assertFalse(we.isSelected());
		int count = dr.findElements(By.xpath("//div[@id='checkbox-example']//fieldset//input[@type='checkbox']")).size();
		System.out.println(count);
	}
}