package com.training.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public  void waitForElement(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}   
	
	  public void clickOnButton(WebElement nameofWebelement) { 
	  waitForElement(40, nameofWebelement);
	  nameofWebelement.click();
	  
	  }
	  public void clickObj(WebElement obj,String objName)
		{
			if(obj.isDisplayed())
				
			{	 
				//waitForElement(40, obj);

				obj.click();
				System.out.println("pass :" +objName + "button is clicked");
			}
			else
			{
				System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
			//logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
			}
		}
	  public static void Radiobutton(WebElement obj, String objName) {
			
			if(obj.isDisplayed() ){
				obj.click();
				System.out.println("Pass: "+objName+" is clicked");
			}else {
				System.out.println("Fail:"+objName+" is not displayed .Please check your application");			
			}
		}
	  public static void switchtoAlert(WebDriver driver) {
			 driver.switchTo().alert().accept();
			 System.out.println("Pass: alert is present and accept");
		}
	  
	  
	  public static void enterText(WebElement obj,String textval,String objName) throws Exception

		{
			if(obj.isDisplayed())
			{
				Thread.sleep(4000);
				obj.sendKeys(textval);
				System.out.println("pass: "+textval+"value is entered in "+objName+"field");
				//Call take screenshot function
			//logger.log(LogStatus.PASS,textval+"value is entered in "+objName+"field");
				
				
			}
			else
			{
				System.out.println("fail:" +objName+ "field does not exist please check application");
			//logger.log(LogStatus.FAIL,textval+objName+"field does not exist please check application");
				
			}
		}
		
}




