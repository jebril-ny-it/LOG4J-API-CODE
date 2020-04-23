package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

	// what is logs???capturing info.activites at the time of program execution
	// what types of logs
	// 1.info
	// 2.warn
	// 3.debug
	// 4.fatal
	// how to generate the logs?use Apache Log4j API (Log4j dependency)
	// how it works??it reads Log4j configuration from Log4j.properties file
	// where to create ::create inside resources folder

	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp() {
		log.info("############################# Starting Before Method ############################");
		log.info("############################# freeCRMTitle ############################");
	
		driver = new ChromeDriver();
		log.info("launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.FreeCRM.com");
		log.info("Entering application the URL");
		log.warn("Hey this is just a warning message");
		log.fatal("Hey this is just a fatal error message");
		log.debug("Hey this is a debug message");
	
		log.info("############################# Ending Before Method ############################");
		log.info("############################# freeCRMTitle ############################");
	
	}

	@Test
	public void freeCRMTitle() {
		log.info("############################# Starting Test case ############################");
		log.info("############################# freeCRMTitle ############################");
	
		String title = driver.getTitle();
		System.out.println(title);
		log.info("Login page title"+title);
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
		log.info("############################# Ending Test case ############################");
		log.info("############################# freeCRMTitle ############################");
	}
	

	@Test
	public void freeCRmLogoTest() {
		log.info("############################# Starting Test case ############################");
		log.info("############################# freeCRMTitle ############################");
	
		boolean b = driver.findElement(By.xpath("//div[@class='rd-navbar-panel']//a[@class='brand-name']"))
				.isDisplayed();
		Assert.assertTrue(b);
		
		log.info("############################# Ending Test case ############################");
		log.info("############################# freeCRMTitle ############################");
	}

	@AfterMethod
	public void tearDown() {
		log.info("############################# Starting After Method ############################");
		log.info("############################# freeCRMTitle ############################");
		driver.quit();
		log.info("############################# Ending After method ############################");
		log.info("############################# freeCRMTitle ############################");
	
	}
}
