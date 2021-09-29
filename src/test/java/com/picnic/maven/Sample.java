package com.picnic.maven;

//import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 

public class Sample {
	
	@Test
    
	public void login() throws InterruptedException
        {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        
        //System.setProperty("webdriver.gecko.driver","C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\geckodriver.exe");
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtUsername"));
        WebElement username=driver.findElement(By.id("txtUsername"));
        driver.findElement(By.id("txtPassword"));
        WebElement password=driver.findElement(By.id("txtPassword"));
        
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(3000);
        //driver.quit();
        
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.cssSelector("#btnAdd")).click();
        
    }

	//@Test
	public void loginfb()
	{
		
		String baseUrl ="http://www.facebook.com/";
    	WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get(baseUrl);
        WebElement txtUsername=driver.findElement(By.id("email"));
        Actions builder= new Actions(driver);
        Action seriesOfActions = builder
        	.moveToElement(txtUsername)	
        	.click()
        	.keyDown(txtUsername,Keys.SHIFT)
        	.sendKeys(txtUsername,"hello")
        	.keyUp(txtUsername,Keys.SHIFT)
        	.doubleClick(txtUsername)
        	.contextClick()
        	.build();
        seriesOfActions.perform();
        
		
	}
	
	

	
	
}



 