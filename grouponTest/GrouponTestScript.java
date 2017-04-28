package grouponTest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GrouponTestScript {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setupSelenium(){
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		driver = new FirefoxDriver(capabilities);
		String url = "https://www.groupon.com/login";
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass
	public static void closeBrowser() throws InterruptedException{	// Destroy Scanner object at the end
		Thread.sleep(5000);
		driver.quit();
	}
	
	/*@Test
	public void testTitle(){
		String title = driver.getTitle();
		
		assertEquals("Sign In", title);
	}*/
	
	/*@Test
	public void testLoggedInUserName() throws InterruptedException{
		WebElement link = driver.findElement(By.id("email-input"));
		link.sendKeys("groupontest102@gmail.com");
		driver.findElement(By.id("password-input")).sendKeys("Passwd!1");
		driver.findElement(By.id("signin-button")).click();
		Thread.sleep(5000);
		String uname = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div[2]/div/nav/a[3]/span")).getText();
		System.out.println("UName: "+uname);
		assertEquals("Charles", uname);
	}*/
	
	@Test
	public void visitElectronics() throws InterruptedException{
		WebElement link = driver.findElement(By.id("email-input"));
		link.sendKeys("groupontest102@gmail.com");
		driver.findElement(By.id("password-input")).sendKeys("Passwd!1");
		driver.findElement(By.id("signin-button")).click();
		Thread.sleep(5000);
		
		WebElement goods = driver.findElement(By.id("sls-aria-3"));
		goods.click();
		Thread.sleep(5000);
		
		try{
			// Item with rating
			WebElement child = driver.findElements(By.className("rating")).get(0);
			
			Thread.sleep(5000);

			WebElement parent = child.findElement(By.xpath("..")).findElement(By.xpath("..")).findElement(By.xpath(".."));
			parent.click();
			
			Thread.sleep(5000);
			
			// To Rate the product 4
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/div/div/article/div[1]/div[1]/div/div[2]/ul/li[4]")).click();
			
			// To write a review
			String review = "Nice Product";
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/div/div/article/div[1]/div[2]/textarea")).sendKeys(review);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/section[2]/div/div/article/div[1]/div[2]/button")).click();
			
			Thread.sleep(5000);
			
			String recordedReview = driver.findElement(By.cssSelector(".review-text")).getText();
			
			Thread.sleep(3000);
			
			assertEquals(review, recordedReview);
			
			Thread.sleep(5000);
		}catch(Exception e){
			System.out.println("No Item Present with rating");
		}
		
	}

}
