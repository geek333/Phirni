package com.testing.reporting;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;




@SuppressWarnings("unused")
public class ExtentManager {
	
	private static ExtentReports extent;
	private static String reportFileName="Test-Automation-Report"+".html";
	private static String fileSeperator=System.getProperty("file.seperator");
	private static String reportFilePath=System.getProperty("user.dir")+fileSeperator+"TestReport";
	private static String reportFileLocation=reportFilePath+fileSeperator+reportFileName;
	
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
			createInstance();
		return extent;
	}
	
	
	public static ExtentReports createInstance()
	{
		String fileName=getReportPath(reportFilePath);
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Phirni - Automation Expert");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTimeStampFormat("EEEE , MMM dd yyyy , hh:mm a '('zzz')'");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("OS","Windows");
		
		return extent;
		
	}
	
	private static String getReportPath(String path)
	{
		File testDirectory=new File(path);
		if(!testDirectory.exists())
		{
			if(testDirectory.mkdir())
			{
				System.out.println("Directory : "+path+" is created! ");
				return reportFileLocation;
			}
			else
			{
				System.out.println(" Failed to created directory : "+path);
				return System.getProperty("user.dir");
			}
			
		}
		else
		{
			System.out.println("Directory already exists : "+path);
		}
		
		return reportFileLocation;
	}
	

}
