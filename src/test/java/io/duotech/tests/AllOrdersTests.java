package io.duotech.tests;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import io.duotech.pages.ListOfAllOrdersPage;
import io.duotech.pages.LoginPage;
import io.duotech.utils.BrowserUtilities;
import io.duotech.utils.Driver;

public class AllOrdersTests extends TestBase{
	@BeforeMethod
	public void setUpTest() {
		
		LoginPage login  = new LoginPage();
		login.positiveLogin();
		Assert.assertTrue(driver.getTitle().contains("Web Orders"));

	}
	
	@Test
	public void verifyCheckAllButton() throws InterruptedException {
		
		
		ListOfAllOrdersPage allOrders = new ListOfAllOrdersPage();
		
		//allOrders.checkAllButton.click();
		//actions.moveToElement(e).click().build().perform();

		
		for (WebElement e : allOrders.checkboxes) {
			e.click();
			Assert.assertTrue(e.isSelected());
		}
	}
	
	
	@Test 
	
	public void verifyUncheckAllButton() throws InterruptedException, IOException {
		
		
		ListOfAllOrdersPage allOrders = new ListOfAllOrdersPage();
		
		allOrders.checkAllButton.click();
 //		BrowserUtilities.takeFullScreenshot("Clicked Check ALL");
		
 		allOrders.uncheckAllButton.click();
 	//	BrowserUtilities.takeFullScreenshot("Clicked Uncheck ALL");

		
		for (WebElement e : allOrders.checkboxes) {
			Assert.assertFalse(e.isSelected());
		}
	}
	
	
	@Test
	public void verifyMessageAfterDeleteAll() {
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertTrue(driver.getTitle().contains("Web Orderz"), "Title is not correct");

		
		ListOfAllOrdersPage allOrdersPage = new ListOfAllOrdersPage();
		
		
		
		softAssert.assertTrue(allOrdersPage.welcomeMessage.getText().contains("Wlcome, Tester"), "Welcome message was wrong");
		
		
//		try {
//			Assert.assertTrue(allOrdersPage.welcomeMessage.getText().contains("Wlcome, Tester"), "Welcome message was wrong");
//		} catch (AssertionError e) {
//			System.out.println("Inside catch");
//			e.printStackTrace();
//		}
		
		System.out.println("After Soft Assertion");
		allOrdersPage.checkAllButton.click();
		allOrdersPage.deleteSelectedButton.click();
		
		softAssert.assertTrue(allOrdersPage.orderEmptyMessage.getText().contains("List of orders is empty."));
		softAssert.assertAll();
	}

}
