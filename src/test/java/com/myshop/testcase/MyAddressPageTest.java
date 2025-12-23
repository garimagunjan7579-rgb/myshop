package com.myshop.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myshop.pageobjects.IndexPage;
import com.myshop.pageobjects.MyAccountPage;
import com.myshop.pageobjects.MyShop;
import com.myshop.pageobjects.YourAddress;
import com.myshop.utilities.ReportLogger;

public class MyAddressPageTest extends BaseTest {

	IndexPage ip;
	MyAccountPage ma;
	MyShop ms;
	YourAddress ya;

	@BeforeMethod
	public void myAddressSetUp() {
		ip = new IndexPage(driver);
		ma = ip.clickOnSignIn();
		ms = ma.enterDetails();
		ya = ms.clickFirstAddress();
	}

	@Test
	public void enterNewAddress() {
		logger1.info("In the Add adress details Page");
		ReportLogger.getTest().info("In the Add adress details Page");
		Assert.assertEquals(ya.getFirstName(), "GGGG", "Mismatch of Firstname");
		Assert.assertEquals(ya.getLastName(), "GGGG", "Mismatch of Lastname");
		Assert.assertEquals(ya.getCompany(),"Amazon","Mismatch of company");
		Assert.assertEquals(ya.getCountry(), "Utah", "Mismatch of country");
		
	}

}
