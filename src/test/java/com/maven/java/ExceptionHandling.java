package com.maven.java;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtUsername"));

        try
        {
            WebElement username=driver.findElement(By.id("txtUseme")); //invalilocator
            username.sendKeys("Admin");
            //Thread.sleep(3000);

        }
        catch(NoSuchElementException e) {
        	System.out.println("locator is invalid");
        }
        
        driver.findElement(By.id("txtPassword"));
        WebElement password=driver.findElement(By.id("txtPassword"));
        
        password.sendKeys("admin123");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        Thread.sleep(3000);
        driver.quit();
	}

}
