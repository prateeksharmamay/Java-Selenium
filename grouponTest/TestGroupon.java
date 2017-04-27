package grouponTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestGroupon {
	public static void main(String args[]) throws InterruptedException{
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		
		WebDriver driver = new FirefoxDriver(capabilities);
		String url = "https://www.groupon.com/login";
		
		driver.get(url);
		
		WebElement link = driver.findElement(By.id("email-input"));
		link.sendKeys("groupontest102@gmail.com");
		driver.findElement(By.id("password-input")).sendKeys("Passwd!1");
		driver.findElement(By.id("signin-button")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
