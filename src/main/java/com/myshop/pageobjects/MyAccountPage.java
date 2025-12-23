package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	private WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		System.out.println("In My Accounts Page");
	}
	
	@FindBy(id="email_create")
	private WebElement emailaddress;
	
	@FindBy(id="SubmitCreate")
	private WebElement createbtn;
	
	@FindBy(id="email")
	private WebElement emailtextbox;
	
	@FindBy(id="passwd")
	private WebElement passwordbox;
	
	@FindBy(id="SubmitLogin")
	private WebElement submitbtn;
	
	public void enterEmail()
	{
		emailaddress.clear();
		emailaddress.sendKeys("abcdepqr1973@gmail.com");
	}
	
	public void clickCreate()
	{
		createbtn.click();
	}
	
	public MyShop enterDetails()
	{
		emailtextbox.clear();
	emailtextbox.sendKeys("abcd123459@gmail.com");
	//	emailtextbox.sendKeys("gggggg@gmail.com");
		passwordbox.clear();
	passwordbox.sendKeys("GGGGGG");
	//	passwordbox.sendKeys("gggggg");
		submitbtn.click();
		return new MyShop(driver);
		
	}

}
