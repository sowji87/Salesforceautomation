package com.training.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.base.BasePage;
import com.training.base.BaseTest;
import com.training.pages.ContactsPage;
import com.training.pages.HomePage;
import com.training.pages.LoginPage;
import com.training.utilities.CommonUtilities;



public class ContactsTest extends BaseTest {
 
	static WebDriver driver;
	CommonUtilities common = new  CommonUtilities();
	String url;
	String browser;
	LoginPage login;
	String email,excepted;
	String password;
	HomePage home;
	WebElement RememberMe;
    WebElement menu;
	WebElement NoThanks;
	String loginError;
    ContactsPage contacts;



	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		
		url = common.getProperty("url");
		browser=common.getProperty("browser");
		email=common.getProperty("email");
		password=common.getProperty("password");

		driver=getDriver(browser);
		driver.get(url);
		login = new LoginPage(driver); //Parameterized constructor
		home = new HomePage(driver); //Parameterized constructor
        contacts = new ContactsPage(driver);
		

		
	}
	@Test   //TC25- Create new contact
	public void Createnewcontact() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		contacts.clickOnContacts();
		contacts.clickOnNew();
		contacts.enterIntoFirstname();
		contacts.enterIntolastname();
		contacts.clickOnSave();
	}
	
	@Test
	public void loginAndEnterHome() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.clickOnLogin();
		home.clickHome();
	}
	
	@Test 
	public void checkRememberMe() {
		login.enterIntoEmail(email);
		login.enterIntoPassword(password);
		login.selectCheckBox(RememberMe);
		login.clickOnLogin();
		login.selectDropDown(menu );
		login.clickOnLogout();
	}

		@Test           //forgot password
	 public void forgotPassword() {
			login.forgotpassword();
			login.enterIntoforgotEmail(email);
			login.continueTo();
		
	}
		@Test               //validate login error message
		public void invalidUsernamePassword() {
			login.enterIntoInvalidEmail();
			login.enterIntoInvalidPasswor();
			login.clickOnLogin();
			login.assertion(loginError,excepted);

		}
	@AfterMethod
		public void teardown() {
		takescreenshot(driver);
		 driver.close();
		}
	
	}
	

