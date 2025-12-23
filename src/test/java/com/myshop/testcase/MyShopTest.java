package com.myshop.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myshop.pageobjects.IndexPage;
import com.myshop.pageobjects.MyAccountPage;
import com.myshop.pageobjects.MyShop;
import com.myshop.utilities.ReportLogger;

public class MyShopTest extends BaseTest {
	
	IndexPage ip;
	MyAccountPage ma;
	MyShop ms;
	
	String expectedTitle="My account - My Shop";
	
	@BeforeMethod
	public void pageSetUp()
	{
		ip=new IndexPage(driver);
		ma=ip.clickOnSignIn();
		ms=ma.enterDetails();
		logger1.info("On MyShop Details Page");
		ReportLogger.getTest().info("On MyShop Details Page");
	}
	
	@Test
	public void checkPageTitle()
	{
		String actualPageTitle=driver.getTitle();
		System.out.println("Actual Page Title for MyShop"+actualPageTitle);
		Assert.assertEquals(actualPageTitle, expectedTitle);
	}
	
	
	

	
	
	
	

}
