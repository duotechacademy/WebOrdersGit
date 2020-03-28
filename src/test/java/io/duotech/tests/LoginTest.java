package io.duotech.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.duotech.pages.LoginPage;
import io.duotech.utils.ConfigReader;

public class LoginTest extends TestBase {
	
	
	
	
	
	
	@Test
	public void loginPOMPattern() {
		logger = reporter.createTest("Positive Login Test");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Logging in by entering the correct credentials");
		loginPage.positiveLogin();
		logger.info("Verifying the title contains \"Web Orders\"");
		
		Assert.assertTrue(driver.getTitle().contains("Web Orders"));
		
		logger.pass("Verified that the title contains \"Web Orders\"");
		
	}
	
	@Test
	public void loginPOMPatternNegative() {
		logger = reporter.createTest("Negative Login Test");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Entering the invalid credentials");

		loginPage.usernameField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("usrname")).reverse().toString());
		loginPage.passwordField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("password")).reverse().toString());
		logger.info("Clicking on  login button");
		loginPage.loginButton.click();
		String expected = "Invalid Login or Password.";
		String actual = loginPage.errorMessage.getText();
		logger.info("Verifying that the error message is \"Invalid Login or Password.\"");
		Assert.assertEquals(actual, expected);
		
		logger.pass("Verified that the error message is \"Invalid Login or Password.\"");
	}
	
	@Test
	public void loginFailingTest() {
		logger = reporter.createTest("Login Test with invalid credentials");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Entering the invalid credentials");

		loginPage.usernameField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("usrname")).reverse().toString());
		loginPage.passwordField.sendKeys(new StringBuilder(ConfigReader.getConfiguration("password")).reverse().toString());
		logger.info("Clicking on  login button");

		loginPage.loginButton.click();
		logger.info("Verifying that the title is equal to \"Web Orders\"");

		Assert.assertEquals(driver.getTitle(), "Web Orders");
		
		logger.pass("Verified that the  title is equal to\"Web Orders\"");
		
	}
	
	@Test
	public void loginSkip() {
		logger = reporter.createTest("Positive Login Test using Skip");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Logging in by entering the correct credentials");
		loginPage.positiveLogin();
		logger.info("Verifying the title contains \"Web Orders\"");
		
		throw new SkipException("Skipping this test because the rest of the test is not ready");
		
	}
	
	@Test
	public void loginPOMForGit() {
		logger = reporter.createTest("Positive Login Test");
		
		LoginPage loginPage = new LoginPage();
		logger.info("Logging in by entering the correct credentials");
		loginPage.positiveLogin();
		logger.info("Verifying the title contains \"Web Orders\"");
		
		Assert.assertTrue(driver.getTitle().contains("Web Orders"));
		
		logger.pass("Verified that the title contains \"Web Orders\"");
		
	}
	
	
	
	
	
	
	

}
