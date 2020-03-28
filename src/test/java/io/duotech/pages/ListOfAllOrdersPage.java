package io.duotech.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utils.Driver;

public class ListOfAllOrdersPage {
	
	public ListOfAllOrdersPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}
	
	@FindBy(linkText = "Order")
	public WebElement orderLink;
	
	@FindBy(id = "ctl00_MainContent_btnCheckAll")
	public WebElement checkAllButton;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public List<WebElement> checkboxes;
	
	@FindBy(id = "ctl00_MainContent_btnUncheckAll")
	public WebElement uncheckAllButton;
	
	
	@FindBy(name= "ctl00$MainContent$btnDelete")
	public WebElement deleteSelectedButton;
	
	
	@FindBy(className = "login_info")
	public WebElement welcomeMessage;
	

	@FindBy(id = "ctl00_MainContent_orderMessage")
	public WebElement orderEmptyMessage;
	
	
	

	

}
