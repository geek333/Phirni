package com.testing.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyHandler {
	
	private FileReader reader;
	private Properties prop;
	
	public PropertyHandler() {
		
	}
	
	
	public boolean setFileName(String folderName , String fileName)
	{
		boolean flag=true;
		
		try {
			
			reader=new FileReader(System.getProperty("user.dir"+"\\"+folderName+"\\"+fileName+".properties"));
			prop=new Properties();
			prop.load(reader);
			
		}
		catch(Exception e)
		{
			flag=false;
			System.out.println("Exception Occured  while reading file "+e.getMessage());
		}
		
		return flag;
	}

	
	public String readProperty(String key)
	{
		if(prop==null)
		{
			return null;
		}
		else
		{
			return (String) prop.get(key);
		}
	}
	

}
