package io.duotech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utils.ConfigReader;
import io.duotech.utils.Driver;

public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy	(xpath = "//input[@class='txt'][@type='text']")
	public WebElement usernameField ;
	
	@FindBy	(id = "ctl00_MainContent_password")
	public WebElement passwordField;
	
	@FindBy	(name = "ctl00$MainContent$login_button")
	@CacheLookup // will cache /save the element once we find it and next it is used, it is not going to find it anew
	public WebElement loginButton;
	
	@FindBy	(id = "ctl00_MainContent_status")
	public WebElement errorMessage;
	
	
	public void positiveLogin() {
		usernameField.sendKeys(ConfigReader.getConfiguration("usrname"));
		passwordField.sendKeys(ConfigReader.getConfiguration("password"));
		loginButton.click();
		
	}
	
	
	
	// Using "how" and "using" parameters
//	@FindBy	(how = How.NAME , using = "ctl00$MainContent$login_button")
//	public WebElement loginButtons;
	

}
