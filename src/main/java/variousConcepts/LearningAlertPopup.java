package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningAlertPopup {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver4\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void alertLogin() throws InterruptedException {
		By SIGN_IN_LOCATOR = By.xpath("//input[@name='proceed']");
		driver.findElement(SIGN_IN_LOCATOR).click();
		Thread.sleep(2000);

		// To capture the alert message:
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		// To click on the 'OK' button:
		driver.switchTo().alert().accept();

	}
}
