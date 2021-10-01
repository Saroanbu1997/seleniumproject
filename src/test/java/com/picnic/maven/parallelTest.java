package com.picnic.maven;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTest {
	
	private WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	  private static final Logger logger = LogManager.getLogger(parallelTest.class);

	@Parameters({"browser"})
	@BeforeTest
public void openbrowser(String browser)
{
	try
	{
		if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
			System.setProperty("webdriver.gecko.driver","C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

	
	
	}else if (browser.equalsIgnoreCase("chrome")){
		
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\saravananan\\eclipse-workspace\selenium\Seleniumproject\drivers\chromedriver.exe");
		driver = new ChromeDriver();

		}

	}catch(WebDriverException e){
		//If no browser passed throw exception
		System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void login_Testcase()
	{
		driver.navigate().to(baseURL);
		 BasicConfigurator.configure();
		  logger.info("Hello world");
		  logger.info("we are in logger info mode");
	
WebElement uname = driver.findElement(By.id("txtUsername"));
		
		uname.sendKeys("Admin");
		//Thread.sleep(2000);
	    WebElement passwd = driver.findElement(By.id("txtPassword"));
		
		passwd.sendKeys("admin123");
WebElement submit = driver.findElement(By.id("btnLogin"));
		
		submit.click();
	    
	}
	
	@Test
	public void search_Testcase() throws InterruptedException
	{
		
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		WebElement menulog=driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
		menulog.click();
		//driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']")).click();
		WebElement adminname = driver.findElement(By.id("searchSystemUser_userName"));
		adminname.sendKeys("sara199790");
		Select userrole = new Select(driver.findElement(By.cssSelector(" #searchSystemUser_userType")));
		userrole.selectByIndex(1);
		WebElement empname = driver.findElement(By.name("searchSystemUser[employeeName][empName]"));
		empname.sendKeys("Ether tent");
		Select Status1 = new Select(driver.findElement(By.cssSelector("#searchSystemUser_status")));
		Status1.selectByIndex(1);
		driver.findElement(By.className("searchbutton")).click();
		Thread.sleep(2000); 

		
	}
	
	@AfterTest
	public void close_browser()
	{
		driver.quit();
	}
	
}
	

	
