package com.myshop.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInfoPage {
	
	private WebDriver driver;
	
	public PersonalInfoPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	System.out.println("Inside Personal Info");
	}
	
	@FindBy(id="uniform-id_gender1")
	private WebElement male;
	
	@FindBy(id="id_gender2")
	private WebElement female;
	
	@FindBy(id="firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id="lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(id="email")
	private WebElement emailTextBox;
	
	@FindBy(id="days")
	private WebElement daysDropDown;
	
	@FindBy(id="uniform-months")
	private WebElement monthsDropDown;
	
	@FindBy(id="years")
	private WebElement yearsDropDown;
	
	@FindBy(css=".btn .btn-default .button .button-small")
	private WebElement backToAccountsButton;
	
	public boolean socialTitle() {
		return female.isSelected();
	}
	
	public String getFirstNameInfo() {
		return firstNameTextBox.getAttribute("value");
	}
	
	public String getLastNameInfo() {
		return lastNameTextBox.getAttribute("value");
	}
	
	public String getEmailInfo() {
		return emailTextBox.getAttribute("value");
	}
	
//*****only in case you want to edit the existing values from this page****	
	public void editTitle()
	{
		System.out.println("Male Radio btn displayed? " + male.isDisplayed());
        System.out.println("Male Radio btn enabled? " + male.isEnabled());
		male.click();
	}
	
	public void editFirstName(String firstName)
	{
		System.out.println("First Name text box displayed? " + firstNameTextBox.isDisplayed());
        System.out.println("First Name text box enabled? " + firstNameTextBox.isEnabled());
        firstNameTextBox.click();
        firstNameTextBox.clear();
      //  firstNameTextBox.sendKeys("DDDDDDD");
        firstNameTextBox.sendKeys(firstName);
	}
	
	public void editlastName(String lastName)
	{
		System.out.println("Last Name Text Box displayed? " + lastNameTextBox.isDisplayed());
        System.out.println("Last Name Text Box enabled? " + lastNameTextBox.isEnabled());
        lastNameTextBox.click();
        lastNameTextBox.clear();
      //  lastNameTextBox.sendKeys("DDDDDDD");
        lastNameTextBox.sendKeys(lastName);
	}
	
	public void editEmail(String email)
	{
		System.out.println("Last Name Text Box displayed? " + lastNameTextBox.isDisplayed());
        System.out.println("Last Name Text Box enabled? " + lastNameTextBox.isEnabled());
        emailTextBox.click();
        emailTextBox.clear();
     //   emailTextBox.sendKeys("DDDDDDD");
        emailTextBox.sendKeys(email);
	}
	
	public void editDateOfBirth(String date1)
	{
		Select dob=new Select(daysDropDown);
		dob.deselectAll();
	//	dob.selectByValue("10");
		dob.selectByValue(date1);
	}
	
	public void editMonthOfBirth(String month1)
	{
		Select dob=new Select(daysDropDown);
	//	dob.deselectByValue("January");
		dob.deselectAll();
		dob.selectByValue(month1);
	}
	
	public void editYearOfBirth(String year1)
	{
		Select dob=new Select(daysDropDown);
	//	dob.deselectByValue("2007");
		dob.deselectAll();
		dob.selectByValue(year1);
	}
	
	public MyAccountPage backToAccount()
	{
	/*	System.out.println("Is back to accounts displayed"+ backToAccountsButton.isDisplayed());
		System.out.println("Is back to accounts enabled"+ backToAccountsButton.isEnabled());
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(backToAccountsButton));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true),backToAccountsButton");
		backToAccountsButton.click();
	*/	
		driver.navigate().back();
		return new MyAccountPage(driver);
	}
	
	}
	
	
	

