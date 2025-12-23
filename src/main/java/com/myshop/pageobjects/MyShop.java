package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyShop {
	
	private WebDriver driver;
	
	public MyShop(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		System.out.println("MyShop Page");
	}
	
	@FindBy(xpath="//a[@title='Add my first address']")
	private WebElement addAddressLink;
	
	@FindBy(xpath="//a[@title='Orders'")
	private WebElement ordersLink;
	
	@FindBy(xpath="//a[@title='Credit slips']")
	private WebElement creditLink;
	
	@FindBy(xpath="//a[@title='Addresses']")
	private WebElement savedAddressLink;
	
	@FindBy(xpath="//a[@title='Information']")
	private WebElement informationLink;
	
	@FindBy(xpath="//a[@class='account']")
	private WebElement accountNameLink;
	
	@FindBy(xpath="//a[@title='Information']")
	private WebElement myInfo;
	
	@FindBy(xpath="//a[@title='T-shirts'")
	private WebElement tShirtsOption;
	
	public YourAddress clickFirstAddress()
	{
		System.out.println(driver.getTitle());
		System.out.println("Is addAddressLink displayed"+ addAddressLink.isDisplayed());
		System.out.println("Is addAddressLink enabled"+ addAddressLink.isEnabled());
		addAddressLink.click();
		System.out.println("add Address Link clicked");
		return new YourAddress(driver);
	}
	
	public PersonalInfoPage clickPersonalInfo()
	{
		System.out.println(driver.getTitle());
		System.out.println("Is my Personal Info displayed"+ myInfo.isDisplayed());
		System.out.println("Is my Personal Info enabled"+ myInfo.isEnabled());
		myInfo.click();
		System.out.println("add Address Link clicked");
		return new PersonalInfoPage(driver);
	}
	
	public TShirts clickTShirt()
	{
		System.out.println(driver.getTitle());
		System.out.println("Is TShirts option displayed"+ tShirtsOption.isDisplayed());
		System.out.println("Is TShirts option enabled" + tShirtsOption.isEnabled());
		tShirtsOption.click();
		System.out.println("TShirts Clicked");
		return new TShirts(driver);
	}
		
		}


