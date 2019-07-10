package com.infostretch.seleniumfeatures.test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.infostretch.seleniumfeatures.Pages.RediffRegisterPage;
import com.infostretch.seleniumfeatures.basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class DropDownTest extends BaseTest 
{
   @Test()
   public void dropDown() throws IOException
   {
	   eTest=eReport.startTest("Selenium DropDown Feature Test");
	   browserSetup();
	   
	   driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
	  
	   eTest.log(LogStatus.INFO, "Navigated to User Register Page");
	   RediffRegisterPage rf=new RediffRegisterPage(driver);
	  
	   rf.selectByIndex(34);
	   eTest.log(LogStatus.INFO, "Selected Country option at given index");
	   rf.selectByVisbileText("India");
	   eTest.log(LogStatus.INFO, "Selected Country option at given text");
	   rf.selectByValue("5");
	   eTest.log(LogStatus.INFO, "Selected Country option at given value");
	   rf.displayAllOption();
	   eTest.log(LogStatus.INFO, "Displayed All option from dropdown");
   }
   
   @AfterTest()
   public void closure()
   {
	   driver.quit();
	   if(eTest!=null)
	   {
		   eReport.endTest(eTest);
	   }
	   
	   eReport.flush();
	   
   }
}
