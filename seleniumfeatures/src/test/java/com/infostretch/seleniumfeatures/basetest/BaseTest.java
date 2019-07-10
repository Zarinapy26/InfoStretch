package com.infostretch.seleniumfeatures.basetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import com.infostretch.seleniumfeatures.util.ExtentReportGenerator;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest
{
  public WebDriver driver;
  public ExtentReports eReport=ExtentReportGenerator.getExtentReportInstance();
  public ExtentTest eTest;
  
  //@BeforeMethod()
  public void browserSetup()
  {
	 
	 eTest.log(LogStatus.INFO, "Setting up Chrome Browser");
	 System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
	 ChromeOptions option=new ChromeOptions();
	 option.addArguments("--disable-notifications");
	 option.addArguments("--disable-infobars");
	 option.addArguments("--start-maximized");
	 driver=new ChromeDriver(option);
	 eTest.log(LogStatus.INFO, "Chrome Browser opened with defined settings");
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  
}
