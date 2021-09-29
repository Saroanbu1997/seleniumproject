package com.picnic.maven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
//Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
//create firefox instance
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

//Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
//set path to chromedriver.exe
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver","C:\\Users\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			//driver.manage().window().maximize();
		}

		else {
//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testParameterWithXML() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
        


		WebElement uname = driver.findElement(By.id("txtUsername"));

		uname.sendKeys("Admin");
		Thread.sleep(2000);
		 //		boolean s= uname.isDisplayed();

		boolean s= uname.isDisplayed();
		 System.out.println("The return value: " + s);
		WebElement passwd = driver.findElement(By.id("txtPassword"));

		passwd.sendKeys("admin123");
		boolean s1= passwd.isDisplayed();
		 System.out.println("The return value: " + s1);
		WebElement submit = driver.findElement(By.className("button"));

		submit.click();
		//WebElement forgotpwd = driver.findElement(By.linkText("Forgot your password?" ));
		//forgotpwd.click();
		
	
		// driver.findElement(By.id("menu_dashboard_index")).click();
	
		//ADMIN

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

		// pim
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		driver.findElement(By.id("firstName")).sendKeys("Ether");
		driver.findElement(By.id("lastName")).sendKeys("tent");
		driver.findElement(By.xpath(" //input[@id='btnSave']")).click();
		Thread.sleep(2000);
		//ADD ADMIN EMPLOYEE

		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#btnAdd")).click();
		Thread.sleep(2000);
		Select userrole1 = new Select(driver.findElement(By.cssSelector("#systemUser_userType")));
		userrole1.selectByIndex(0);
		WebElement employeename = driver.findElement(By.xpath(" //input[@id='systemUser_employeeName_empName']"));
		employeename.sendKeys("Ether tent");
		WebElement useraname = driver.findElement(By.name("systemUser[userName]"));
		useraname.sendKeys("Ether1997");
		Select Status = new Select(driver.findElement(By.cssSelector("#systemUser_status")));
		Status.selectByIndex(0);
		WebElement password = driver.findElement(By.id("systemUser_password"));
		password.sendKeys("Password123");
		WebElement confrimpasswrod = driver.findElement(By.id("systemUser_confirmPassword"));
		confrimpasswrod.sendKeys("Password123");
		WebElement save = driver.findElement(By.xpath(" //input[@id='btnSave']"));
		save.click();
		Thread.sleep(2000);
		
		//SEARCH EMPLOYEE
      
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		WebElement adminname1 = driver.findElement(By.id("searchSystemUser_userName"));
		adminname1.sendKeys("Ether1997");
		Select userrole2 = new Select(driver.findElement(By.cssSelector(" #searchSystemUser_userType")));
		userrole2.selectByIndex(1);
		WebElement empname1 = driver.findElement(By.name("searchSystemUser[employeeName][empName]"));
		empname1.sendKeys("Ether tent");
		Select Status2 = new Select(driver.findElement(By.cssSelector("#searchSystemUser_status")));
		Status2.selectByIndex(1);
		driver.findElement(By.className("searchbutton")).click();
		Thread.sleep(2000);
		
        //LOGOUT
		
		WebElement logout = driver.findElement(By.linkText("Welcome Elakkiya12SA;DMA;DM@!K2" ));
		logout.click();
		WebElement logout1 = driver.findElement(By.partialLinkText("Logo"));
		logout1.click();
		 driver.quit();
	}
}
