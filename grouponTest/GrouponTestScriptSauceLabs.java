package grouponTest;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
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
import org.openqa.selenium.remote.RemoteWebDriver;

public class GrouponTestScriptSauceLabs {
	public static final String USERNAME = "prateeksharmamay";
	public static final String ACCESS_KEY = "d8c23b6d-c5c4-4ecf-ad5c-a6060698a27d";
	public static final String myURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	static WebDriver driver;
	
	public static void main(String args[]) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows XP");
	    caps.setCapability("version", "43.0");
	    
	    WebDriver driver = new RemoteWebDriver(new URL(myURL), caps);
	    Thread.sleep(5000);
	    driver.get("https://www.groupon.com/login");
	    Thread.sleep(5000);
	    System.out.println("title of page is: " + driver.getTitle());
	    Thread.sleep(5000);
	    driver.quit();
	}
}
