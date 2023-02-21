package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) { // parameterized constructor
		super(driver);
	}

	@FindBy(id = "username")
	WebElement email;

	public void enterIntoEmail(String stremail) {

		waitForElement(30, email);

		email.sendKeys(stremail);

	}

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	public void enterIntoPassword(String strpassword) {

		password.sendKeys(strpassword);
	}

	public void clearPasswordField(String strpassword) {

		password.clear();

	}

	@FindBy(id = "Login")
	WebElement Login;

	public void clickOnLogin() {
		Login.click();
	}

	@FindBy(xpath = "//div[@id='error']")
	WebElement loginError;

	@FindBy(id = "rememberUn")
	WebElement Rememberme;

	@FindBy(xpath = "//*[@id='userNavButton']")
	WebElement UserMenu;

	@FindBy(xpath = "//a[@title='Logout']")
	WebElement LogOut;

	@FindBy(id = "forgot_password_link")
	WebElement ForgotPassword;

	@FindBy(id = "un")
	WebElement UserEmail;

	@FindBy(id = "continue")
	WebElement Continue;

	@FindBy(xpath = "//input[@id='lexNoThanks']")
	WebElement NoThanks;

	public void continueTo() {
		Continue.click();
	}

	public void alertPopUp() {
		NoThanks.click();
	}

	public void forgotpassword() {
		ForgotPassword.click();
	}

	public void clickOnLogout() {
		LogOut.click();
	}

	public void selectDropDown(WebElement menu) {
		waitForElement(10, UserMenu);

		UserMenu.click();
	}

	public void selectCheckBox(WebElement obj) {
		waitForElement(20, Rememberme);

		Rememberme.click();

	}

	public void enterIntoInvalidEmail() {

		waitForElement(30, email);

		email.sendKeys("123");

	}

	public void enterIntoInvalidPasswor() {

		password.sendKeys("22131");
	}

	public void enterIntoforgotEmail(String stremail) {

		waitForElement(30, UserEmail);
		UserEmail.sendKeys(stremail);

	}

	public void assertion(String actualTitle, String expected) {

		String actualText = loginError.getText();
		String expectedText = loginError.getText();
		Assert.assertEquals(actualText, expectedText, expectedText);
	}

}
