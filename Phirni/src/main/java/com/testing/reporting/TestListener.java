package com.testing.reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestListener implements ITestListener{
	
	public void onStart(ITestContext context)
	{
		System.out.println("Test Suite "+context.getName()+" ");
	}

}
