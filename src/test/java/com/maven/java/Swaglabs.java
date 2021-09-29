package com.maven.java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swaglabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saravananan\\eclipse-workspace\\selenium\\Seleniumproject\\drivers\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        WebElement verify = driver.findElement(By.xpath("//div[@id='']"));
        boolean s= verify.isDisplayed();
		 System.out.println("The Swaglabs is present : " + s);
		 Thread.sleep(2000);
		 WebElement product = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
		 product.click();
		 Thread.sleep(2000);
		 WebElement card = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"));
		 card.click();
		 Thread.sleep(2000);
		 WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
		 checkout.click();
		 Thread.sleep(2000);
		 WebElement firstname = driver.findElement(By.cssSelector("#first-name"));
		 firstname.sendKeys("Saravanan");
		 Thread.sleep(2000);
		 WebElement lastname = driver.findElement(By.cssSelector("#last-name"));
		 lastname.sendKeys("Anbalagan");
		 Thread.sleep(2000);
		 WebElement postcode = driver.findElement(By.cssSelector("#postal-code"));
		 postcode.sendKeys("123456");
		 Thread.sleep(2000);
		 JavascriptExecutor scroll  = (JavascriptExecutor)driver;
		 scroll .executeScript("window.scrollBy(0,250)", "");
		 WebElement cont = driver.findElement(By.xpath("//input[@id='continue']"));
		 cont.click();
		 Thread.sleep(2000);
		 JavascriptExecutor scroll1 = (JavascriptExecutor)driver;
		 scroll1.executeScript("window.scrollBy(0,250)", "");
		 WebElement finish=driver.findElement(By.xpath("//button[@id='finish']"));
		 finish.click();
		 Thread.sleep(2000);
		 WebElement backtohome = driver.findElement(By.xpath("//button[@id='back-to-products']"));
		 backtohome.click();
		 Thread.sleep(2000);		 
		 WebElement lo = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
		 lo.click();
		 Thread.sleep(2000);
		 WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		 logout.click();
		 Thread.sleep(2000);
	}
	

}
