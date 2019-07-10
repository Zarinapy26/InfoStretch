package com.infostretch.seleniumfeatures.util;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportGenerator 
{
	public static ExtentReports getExtentReportInstance()
	{
		Date date=new Date();
		String eReportFile=date.toString().replace(" ","_").replace(":", "_")+".html";
		String eReportFilePath="Reports//"+eReportFile;
		ExtentReports eReport=new ExtentReports(eReportFilePath, false, DisplayOrder.NEWEST_FIRST);
		return eReport;
	}
}
