package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearningMouseHover {

	WebDriver web;

	@Before
	public void launching() {
		System.setProperty("webdriver.chrome.driver", "driver4\\chromedriver.exe");
		web = new ChromeDriver();
		web.manage().deleteAllCookies();
		web.manage().window().maximize();
		web.get("https://www.dell.com/en-us");
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void LoginTest() {
		By PRODUCT_LOCATOR = By.xpath("//span[text()= 'Products']");
		By MONITOR_LOCATOR = By.xpath("//a[text()='Monitors']");
		By FORHOME_LOCATOR = By.xpath("//a[contains(text(), 'Monitors')]/following-sibling::ul/descendant::a[2]");
		By FOR_HOME_LOCATOR = By.xpath("//a[contains(text(), 'Monitors')]/parent::li/descendant::a[3]");

		Actions action = new Actions(web);
		action.moveToElement(web.findElement(PRODUCT_LOCATOR)).build().perform();
		action.moveToElement(web.findElement(MONITOR_LOCATOR)).build().perform();
		web.findElement(FORHOME_LOCATOR).click();

	}
}
