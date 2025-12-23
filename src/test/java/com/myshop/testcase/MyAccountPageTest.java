package com.myshop.testcase;

import com.myshop.pageobjects.IndexPage;
import com.myshop.pageobjects.MyAccountPage;
import com.myshop.utilities.ReportLogger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {
	
	IndexPage ip;
	
	MyAccountPage ma;
	
	String expectedTitle="Login - My Shop";
	
	String actualTitle;
	
	@BeforeMethod
	
	public void pageSetUp()
	{
		ip=new IndexPage(driver);
		ma=ip.clickOnSignIn();
		System.out.println("Inside Account Page Test");
	}
	
	@Test
	public void createAccount()
	{
		actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title Mismatch on Login");
		ma.enterEmail();
		ma.clickCreate();
		logger1.info("Entered new account creation details");
		ReportLogger.getTest().info("Entered new account creation details");
	}
	
	@Test
	public void registeredDetails()
	{
		ma.enterDetails();
		logger1.info("Entered existing user details");
		ReportLogger.getTest().info("Entered existing user details");
		
	}

}
