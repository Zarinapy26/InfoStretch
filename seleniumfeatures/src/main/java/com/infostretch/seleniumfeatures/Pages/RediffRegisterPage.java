package com.infostretch.seleniumfeatures.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.infostretch.seleniumfeatures.util.WriteToExcel;

public class RediffRegisterPage 
{
	Select select;
	
	@FindBy(id="country")
	  WebElement CountryDropDown;

   public RediffRegisterPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  select =new Select(CountryDropDown);
  }
   
    
  

  public void selectByIndex(int index)
  {
	  select.selectByIndex(index);
  }
  
  public void selectByVisbileText(String text)
  {
	  select.selectByVisibleText(text);
  }
  
  public void selectByValue(String value)
  {
	  select.selectByValue(value);
  }
  
  public void displayAllOption() throws IOException
  {
	 
	  List<WebElement> allOption=select.getOptions();
	  List<String> s=new ArrayList<String>();
	  for(WebElement we:allOption)
	  {
		  s.add(we.getText());
	  }
	  
	  
	  
	  WriteToExcel.writeToExcel("Output//TestOutputFile.xlsx","TestOutput",s);	  
	
  }
  
}
