//6th Exercise

package exercises;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;


public class Assignment6 {


public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub


String defaultbrowser = "chrome"; // chrome, firefox, ie

WebDriver driver = null;

if (defaultbrowser == "chrome") {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\risha\\Drivers\\chromedriver.exe");

driver = new ChromeDriver();

} else if (defaultbrowser == "firefox") {

System.setProperty("webdriver.gecko.driver", "C:\\Users\\risha\\Drivers\\geckodriver.exe");

driver = new FirefoxDriver();

} else if (defaultbrowser == "ie") {

System.setProperty("webdriver.ie.driver", "C:\\Users\\risha\\Drivers\\MicrosoftWebDriver.exe");

driver = new InternetExplorerDriver();

} else {

System.out.println("Please specify the browser on which test need to be peeformed");

}


driver.manage().window().maximize();

driver.get("http://www.qaclickacademy.com/practice.php");


driver.findElement(By.id("checkBoxOption2")).click();

String chkBoxName = driver.findElement(By.id("checkBoxOption2")).getAttribute("value");

System.out.println(chkBoxName);


WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

Select s = new Select(dropdown);

s.selectByValue(chkBoxName);

//positive scenario

driver.findElement(By.id("name")).sendKeys(chkBoxName);

//Negative scenario

//driver.findElement(By.id("name")).sendKeys("Negative scenario Should fail");

driver.findElement(By.id("alertbtn")).click();

String message = driver.switchTo().alert().getText();

System.out.println(message);


if (message.contains(chkBoxName)) {

Assert.assertTrue(true);

System.out.println("Test is Passed");

Thread.sleep(2000L);

driver.switchTo().alert().accept();


} else {

Assert.assertFalse(true);

System.out.println("Test is Failed");

Thread.sleep(2000L);

driver.switchTo().alert().accept();

}


}


}

