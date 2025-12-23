package com.myshop.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myshop.pageobjects.IndexPage;
import com.myshop.pageobjects.MyAccountPage;
import com.myshop.utilities.ReportLogger;

public class IndexPageTest extends BaseTest{
	
IndexPage ip;	 

MyAccountPage ma;

String expectedTitle="My Shop";

String actualTitle;

@BeforeMethod

public void pageSetUp()
{
	ip=new IndexPage(driver);
	System.out.println("Inside Index Page Test");
}

@Test
public void signInClick()
{
	actualTitle=driver.getTitle();
	Assert.assertEquals(expectedTitle,actualTitle,"Title mismatch");
	
	ma=ip.clickOnSignIn();
	
	logger1.info("Sign In button clicked");
	ReportLogger.getTest().info("Sign In button clicked");
	
	
}

}
