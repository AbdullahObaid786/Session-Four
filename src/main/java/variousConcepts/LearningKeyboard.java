package variousConcepts;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearningKeyboard {

	WebDriver driver;
	
	@Before
	public void launching () {
		System.setProperty("webdriver.chrome.driver", "driver4\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void loginTest () {
		By USERNAME_LOCATOR = By.xpath("//input[@id='username']");
		By PASSWORD_LOCATOR = By.xpath("//input[@id=\"password\"]");
		
		driver.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
		
		//Keyboard events generate by pressing a key or a combination of keys on a keyboard.
		Actions act = new Actions (driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}
	
}
