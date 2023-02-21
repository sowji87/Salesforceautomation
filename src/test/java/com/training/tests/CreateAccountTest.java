package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;
import com.training.pages.CreateAccountPage;
public class CreateAccountTest extends BaseTest{
 static WebDriver driver;
 
 CommonUtilities common = new CommonUtilities();
 LoginPage login;
 String url;
 String email;
 String password;
 String browser;
 CreateAccountPage account;
 String AccountName;
 String ViewName;
 String UniqueViewName;
 String ViewName1;
 String UniqueViewName1;
 String Value;
 
 @BeforeMethod
 public void beforeMethod() throws IOException {
	 
	url= common.getProperty("url");
	browser = common.getProperty("browser");
	email = common.getProperty("email");
	password = common.getProperty("password");
	AccountName=common.getProperty("AccountName");
	ViewName=common.getProperty("ViewName");
	UniqueViewName=common.getProperty("UniqueViewName");
	ViewName1=common.getProperty("ViewName1");
	UniqueViewName1=common.getProperty("UniqueViewName1");
	Value=common.getProperty("Value");
	
	
	driver = getDriver(browser);
	driver.get(url);
	driver.manage().window().maximize();
	
	login = new LoginPage(driver); // Parameterized constructor
	 account = new CreateAccountPage(driver);
 }
 @Test    //TC10 CreateAccount
 public void createAccount() {
	 login.enterIntoEmail(email);
	 login.enterIntoPassword(password);
	 login.clickOnLogin();
	 account.clickOnCreateAccount();
	 account.clickOnNewButton();
	 account.enterAccountName(AccountName);
	 account.clickOnSelectType();
	 account.customerPriority();
	 account.clickOnSaveButton();
 }
 
 @Test   //TC11 Create New view
 public void createNewView() {
	 login.enterIntoEmail(email);
	 login.enterIntoPassword(password);
	 login.clickOnLogin();
	 account.clickOnCreateAccount();
	 account.clickOnNewView();
	 account.enterViewName(ViewName);
	 account.enterUniqueViewName(UniqueViewName);
	 account.clickOnViewSaveButton();
	 
 }
 
 @Test      //TC12 Edit view
 public void editView() {
	 login.enterIntoEmail(email);
	 login.enterIntoPassword(password);
	 login.clickOnLogin();
	 account.clickOnCreateAccount();
	 account.selectView();
	 account.clickEdit();
	 account.enterViewName(ViewName1);
	 account.enterUniqueViewName(UniqueViewName1);
	 account.selectByAccountName();
	 account.selectOperator();
	 account.enterValue(Value);
	 account.ClickonSave();

 }
 
 @AfterMethod
	public void teardown() {
	takescreenshot(driver);
	 driver.close();
	}
}
