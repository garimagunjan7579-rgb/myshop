package com.myshop.actions;

import org.openqa.selenium.WebElement;

public class AppActions {
	
	public void click(WebElement e)
	{
		e.click();
	}
	
	public void enterFieldData(WebElement e,String s)
	{
		e.clear();
		e.sendKeys(s);
	}

}
