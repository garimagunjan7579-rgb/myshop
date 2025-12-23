package com.myshop.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myshop.pageobjects.IndexPage;
import com.myshop.pageobjects.MyAccountPage;
import com.myshop.pageobjects.MyShop;
import com.myshop.pageobjects.PersonalInfoPage;
import com.myshop.utilities.ReportLogger;


public class PersonalInfoTest extends BaseTest {
	
	IndexPage ip;
	MyAccountPage ma;
	MyShop ms;
	PersonalInfoPage pi;
//	YourAddress ya;
	
	@BeforeMethod
	public void personalInfoSetUp()
	{
		ip = new IndexPage(driver);
		ma = ip.clickOnSignIn();
		ms = ma.enterDetails();
		pi = ms.clickPersonalInfo();	
	}
	
	@Test
	public void fieldDisplayed()
	{
logger1.info("Personal Info url opened");
ReportLogger.getTest().info("Personal Info url opened");
Assert.assertTrue(driver.getCurrentUrl().contains("controller=identity"));
Assert.assertEquals(pi.getFirstNameInfo(),"Gggg","First Name Mismatch");
Assert.assertEquals(pi.getLastNameInfo(),"GGGG","Last Name Mismatch");
Assert.assertEquals(pi.getEmailInfo(),"abcd123459@gmail.com","Last Name Mismatch");
pi.backToAccount();
logger1.info("Back To Account clicked");
ReportLogger.getTest().info("Back To Account clicked");
Assert.assertEquals(driver.getTitle(), "My account - My Shop","Navigation is incorrect");



	}

}
