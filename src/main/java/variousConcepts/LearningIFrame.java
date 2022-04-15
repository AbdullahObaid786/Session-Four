package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningIFrame {

	WebDriver web;
	
	@Before
	public void launchingIframe () {
		System.setProperty("webdriver.chrome.driver", "driver4\\chromedriver.exe");
		web = new ChromeDriver ();
		web.manage().deleteAllCookies();
		web.get("https://docs.oracle.com/javase/8/docs/api/\r\n");
		web.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void iFrameTest () {
		// Switch Between Frames : By index:	driver.switchTo.frame();
		web.switchTo().frame("packageListFrame");
		web.findElement(By.linkText("java.awt")).click();
		
		web.switchTo().parentFrame();
		web.switchTo().frame("packageFrame");
		web.findElement(By.linkText("Adjustable")).click();;
		
		web.switchTo().parentFrame();
		web.switchTo().frame("classFrame");
		web.findElement(By.xpath("/html/body/div[2]/div[2]/ul[2]/li[2]/a"));
	}
}
