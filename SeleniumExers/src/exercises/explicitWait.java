//3rd Exercise

package exercises;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;


public class explicitWait {


public static void main(String[] args) {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

WebDriver dr = new ChromeDriver();

dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

dr.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

dr.findElement(By.linkText("Click to load get data via Ajax!")).click();

WebDriverWait pause = new WebDriverWait(dr, 20);

pause.until(ExpectedConditions.visibilityOfElementLocated(By.id("results")));

String msg = dr.findElement(By.id("results")).getText();

System.out.println(msg);

}

}
