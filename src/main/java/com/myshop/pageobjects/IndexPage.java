package com.myshop.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
	
	WebDriver driver;
	
	public IndexPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		System.out.println("In Index Page");
	}
	
	@FindBy(xpath ="//a[contains(@class, 'login')]")
	private WebElement signInLink;

	
	
	public MyAccountPage clickOnSignIn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(signInLink));
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Sign in displayed? " + signInLink.isDisplayed());
        System.out.println("Sign in enabled? " + signInLink.isEnabled());
        signInLink.click();
        System.out.println("Link clicked");
		return new MyAccountPage(driver);
		
	}

}
