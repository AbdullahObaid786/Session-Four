package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearningDropDown {

	WebDriver web;
	@Before
	public void Launching () {
		System.setProperty("webdriver.chrome.driver", "driver4\\chromedriver.exe");
		web = new ChromeDriver ();
		web.manage().deleteAllCookies();
		web.get("https://www.techfios.com/billing/?ng=admin/");
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	@Test
	public void dropDownTest () {
	By USERNAME_LOCATOR = By.xpath("//input[@id='username']");
	By PASSWORD_LOCATOR = By.xpath("//input[@id='password']");
	By SIGN_IN_LOCATOR = By.xpath("//button[@name='login']");
	By DASHBOARD_HEADER_LOCATOR = By.xpath("//h2[contains(text(),  'Dashboard' )]");
	By TRANSACTION_LOCATOR = By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]");
	By ADD_DEPOSIT_LOCATOR = By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a");
	By  ACCOUNT_LOCATOR = By.xpath("//*[@id=\"account\"]");
	
	web.findElement(USERNAME_LOCATOR).sendKeys("demo@techfios.com");
	web.findElement(PASSWORD_LOCATOR).sendKeys("abc123");
	web.findElement(SIGN_IN_LOCATOR).click();
	
	//To get Text out of the Element
	String dashboardHeaderText = web.findElement(DASHBOARD_HEADER_LOCATOR).getText();
	System.out.println(dashboardHeaderText);
	Assert.assertEquals("Wrong Page", "Dashboard", dashboardHeaderText);
	
	web.findElement(TRANSACTION_LOCATOR).click(); 
	web.findElement(ADD_DEPOSIT_LOCATOR).click();
	//To select dropDown we need to use from select class
	Select sel = new Select (web.findElement(ACCOUNT_LOCATOR));
	sel.selectByVisibleText("6032Md Checking");
	

	}
	
	
	
}
