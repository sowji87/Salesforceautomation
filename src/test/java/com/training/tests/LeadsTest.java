package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LeadsPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;



public class LeadsTest extends BaseTest {
 
	static WebDriver driver;
	CommonUtilities common = new  CommonUtilities();
	String url;
	String browser;
	String Newlead;
	LoginPage login;
	LeadsPage leads;
	String email;
	String password;
	HomePage home;
	WebElement Go;
	 WebElement New;
	BasePage base;
	String lastName;
	String companyName;
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		
		url = common.getProperty("url");
		browser=common.getProperty("browser");
		email=common.getProperty("email");
		password=common.getProperty("password");
		lastName=common.getProperty("LastName");
		companyName=common.getProperty("CompanyName");
		driver=getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver); //Parameterized constructor
		home = new HomePage(driver); //Parameterized constructor
        leads = new LeadsPage(driver);
		
    }
		
	 @Test   //TC20-leadsTab  
	    public void leadsTab() {
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
	 }
	 @Test   //TC21-leadsSelectView  
	    public void leadsSelectView() {
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
		  leads.clickOnLeadSelect();
	 }
	 @Test   //TC22-defaultView  
	    public void defaultView() {
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
		  leads.clickOnLeadSelect();
		  home.selectUsernameDropdown();
		  home.clickOnLogout();
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
		 // leads.clickOnButton(Go);
		  leads.clickOnButton();
	 }
	 @Test   //TC23-Todays Leads  
	    public void todaysLeads() {
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
		  leads.clickOnLeadSelect();
		//  leads.clickOnButton(Go);
		  leads.clickOnButton();
	 }
	 @Test   //TC24-New Lead creation 
	    public void newLeads() {
		  login.enterIntoEmail(email);
		  login.enterIntoPassword(password);
		  login.clickOnLogin();
		  leads.clickOnLeadsTab();
		  //leads.clickObj(New, Newlead);
		  leads.clickOnNew();
		  leads.enterLastName(lastName);
		  leads.enterCompantName(companyName);
		  leads.clickOnSave();
	 }
	@AfterMethod
		public void teardown() {
		takescreenshot(driver);
		 driver.close();
		}
	
	}
	

