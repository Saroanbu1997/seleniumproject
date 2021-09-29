/**
* 
*/
package com.wordpress.Testcases;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
 
import com.wordpress.Pages.LoginPage;
 
/**
* @author Mukesh_50
*
*/
public class VerifyWordpressLogin 
{
 
 
//@Test
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\geckodriver.exe");

WebDriver driver=new FirefoxDriver();
 
driver.manage().window().maximize();
 
driver.get("https://opensource-demo.orangehrmlive.com/");
 
LoginPage login=new LoginPage(driver);
 login.typeUserName("Admin");
 Thread.sleep(2000);
 login.typePassword("admin123");
 
 
 
login.clickOnLoginButton();
 
 
driver.quit();
 
}
 
 
}