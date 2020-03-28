package io.duotech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.duotech.utils.Driver;

public class OrderPage {
	
	public OrderPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement processButton;
	
	
	@FindBy (id = "ctl00_MainContent_fmwOrder_RegularExpressionValidator1")
	public WebElement quantityErrMessage;
	

}
