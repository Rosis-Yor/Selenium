//2nd Exercise

package exercises;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;


public class assignment2 {


public static void main(String[] args) throws Exception {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

WebDriver dr = new ChromeDriver();

dr.get("https://www.cleartrip.com/");



Thread.sleep(15000);


//the trip should be from Sofia, Bulgaria to Munich, Germany,

// but sometimes, bacause of the network latencies

// on this step it writes ind the field 'ofs' instead of 'sof'


dr.findElement(By.id("FromTag")).sendKeys("sof");

Thread.sleep(5000);

dr.findElement(By.id("FromTag")).sendKeys(Keys.ENTER);

dr.findElement(By.id("ToTag")).sendKeys("mun");

Thread.sleep(3000);

dr.findElement(By.id("ToTag")).sendKeys(Keys.ARROW_DOWN);

dr.findElement(By.id("ToTag")).sendKeys(Keys.ENTER);

Select s = new Select(dr.findElement(By.id("Adults")));

s.selectByValue("2");

Select s1 = new Select(dr.findElement(By.id("Childrens")));

s1.selectByValue("1");

Select s2 = new Select(dr.findElement(By.id("Infants")));

s2.selectByValue("2");

Thread.sleep(2000);

dr.findElement(By.cssSelector("i.icon.ir.datePicker")).click();

dr.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

}

}