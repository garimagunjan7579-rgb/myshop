package com.myshop.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	Properties prop;
	String path="C:/Users/sidbh/eclipse-workspace/myshop/src/main/resources/config/config.properties";
	{
	try
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	
	catch(IOException e)
	{
		e.printStackTrace();
	}

}
	public String getValues(String key)
	{
		return prop.getProperty(key);
	}
}
