package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BaseTest;
import com.training.pages.CreateOpertunitiesPage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class CreateOpportunitiesTest extends BaseTest {
	static WebDriver driver;

	CommonUtilities common = new CommonUtilities();
	LoginPage login;
	String url;
	String email;
	String password;
	String browser;
	CreateOpertunitiesPage opportunities;

	@BeforeMethod
	public void beforeMethod() throws IOException {

		url = common.getProperty("url");
		browser = common.getProperty("browser");
		email = common.getProperty("email");
		password = common.getProperty("password");

		driver = getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();

		login = new LoginPage(driver); // Parameterized constructor
		opportunities = new CreateOpertunitiesPage(driver);
	}
	
	@Test   //TC15 opportunities drop down
	public void opportunitiesDropDown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunityTab();
		opportunities.clickOnAllOpportunities();
	}
	@Test   //TC16 Create a new Opty
	public void CreateANewOpty() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunityTab();
		opportunities.clickOnNewButton();
	}
	@Test   //TC17 Test Opportunity Pipeline Report
	public void testOpportunityPipelineReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunityTab();
		opportunities.clickOnOpportunityPipeline();
	}
	@Test   //TC18 Test Stuck Opportunities Report
	public void testStuckOpportunityReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunityTab();
		opportunities.clickOnStuckOpportunities();
	}
	@Test   //TC19 Test Quarterly Summary Report
	public void TestQuarterlySummaryReport() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		opportunities.clickOnOpportunityTab();
		opportunities.clickOnRunReport();
	}
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}
}