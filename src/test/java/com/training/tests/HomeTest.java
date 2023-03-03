package com.training.tests;

import java.io.IOException;
//import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;

public class HomeTest extends BaseTest {
	static WebDriver driver;
	CommonUtilities common = new CommonUtilities();
	String url;
	String browser;
	HomePage home;
	String Name;
	LoginPage login;
	String email;
	String password;
	BasePage basePage;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {

		url = common.getProperty("url");
		browser = common.getProperty("browser");
		email = common.getProperty("email");
		password = common.getProperty("password");

		driver = getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
		login = new LoginPage(driver); // Parameterized constructor
		home = new HomePage(driver); // Parameterized constructor

	}

	@Test
	public void vallidHomePage() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
	}

	@Test
	public void selectUserNameforDropdown() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Home page is Displayed");
		home.selectUsernameDropdown();

	}
	@Test //Test case-6
	public void selectMyProfile() {
			login.enterIntoEmail(email);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.selectUsernameDropdown();
			home.selectMyProfile();
			home.edit();
			home.switchFrame();
			home.clickOnAbout();
		
	}
	@Test //Test Case-7
	public void selectMySettings() {
			login.enterIntoEmail(email);
			login.enterIntoPassword(password);
			login.clickOnLogin();
			home.selectUsernameDropdown();
			home.selectMySettings();
			home.clickOnPersonal();
			home.clickOnLoginHistory();
			home.clickOnLoginhistoryDownload();
			home.displayAndLayout();
			home.customizeTab();
			home.dropDown();
			home.availableTabsDropdown();
			home.clickOnAdd();
			home.clickOnEmail();
			home.cliclOnEmailSettings();
			home.enterName("Name");
			home.enterIntoEmail(email);
			home.clickOnRadioButton();
			home.clickOnCallenderAndReminder();
			home.clickOnActivityRemainder();
			home.clickOnTestRemainder();
	}
	
	@Test //Test Case-8
	public void selectDevelopersConsole() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.selectUsernameDropdown();
		home.clickOnDeveloperConsole();
		//driver.switchTo().win

	}
	@Test  // Test case-09 Logout
	public void selectLogout() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.selectUsernameDropdown();
		home.clickOnLogout();
	}
	
	@AfterMethod
	public void teardown() {
		takescreenshot(driver);
		driver.close();
	}

}