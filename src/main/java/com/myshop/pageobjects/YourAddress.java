package com.myshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YourAddress {

	private WebDriver driver;

	public YourAddress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("Inside Your Address Page");
	}

	@FindBy(id = "firstname")
	private WebElement firstName;

	@FindBy(id = "lastname")
	private WebElement lastName;

	@FindBy(id = "company")
	private WebElement companyTextBox;

	@FindBy(id = "address1")
	private WebElement addressTextBox1;

	@FindBy(id = "city")
	private WebElement cityTextBox;

	@FindBy(id = "postcode")
	private WebElement zipCode;

	@FindBy(id = "id_state")
	private WebElement stateDropDown;

	@FindBy(id = "id_country")
	private WebElement countryDropDown;

	@FindBy(id = "phone")
	private WebElement phoneTextBox;

	@FindBy(id = "phone_mobile")
	private WebElement mobileTextBox;

	@FindBy(id = "alias")
	private WebElement addressName;

	@FindBy(id = "submitAddress")
	private WebElement submitButton;

	public AddressListPage enterNewAddressDetails() {
		companyTextBox.clear();
		companyTextBox.sendKeys("AAAAA");

		addressTextBox1.clear();
		addressTextBox1.sendKeys("New Town");

		cityTextBox.clear();
		cityTextBox.sendKeys("New Jersey");

		Select state = new Select(stateDropDown);
		state.selectByVisibleText("Utah");

		zipCode.clear();
		zipCode.sendKeys("233423");

		Select country = new Select(countryDropDown);
		country.getOptions();

		phoneTextBox.clear();
		phoneTextBox.sendKeys("12323233111");

		mobileTextBox.clear();
		mobileTextBox.sendKeys("1212323232");

		addressName.clear();
		addressName.sendKeys("My Home Address");

		submitButton.click();

		return new AddressListPage(driver);

	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public String getLastName() {
		return lastName.getAttribute("value");
	}

	public String getCompany() {
		return companyTextBox.getAttribute("value");
	}

	public String getCountry() {
		return countryDropDown.getAttribute("value");
	}

}
