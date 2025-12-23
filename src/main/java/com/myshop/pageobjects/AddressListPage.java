package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressListPage {
	
	private WebDriver driver;
	
	public AddressListPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("Inside AddressListPage");
	}
	
	@FindBy(id="btn btn-default button button-small")
	WebElement backToAccountButton;
	
	public MyAccountPage backToAccount()
	{
		System.out.println("Clicked the back button");
		backToAccountButton.click();
	return new MyAccountPage(driver);
	}

}
