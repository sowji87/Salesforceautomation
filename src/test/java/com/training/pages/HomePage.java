package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "home_Tab")
	WebElement Home;

	@FindBy(xpath = "//a[@title='My Profile']")
	WebElement MyProfile;

	@FindBy(id = "name")
	WebElement Name;

	@FindBy(xpath = "//div[@id='userNav-arrow']")
	WebElement UserMenu;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']")
	WebElement editProfile;

	@FindBy(xpath = "//iframe[@id='contactInfoContentId']")
	WebElement profileIframe;

	@FindBy(xpath = "//li[@id='aboutTab']")
	WebElement About;

	@FindBy(xpath = "//a[@title='My Settings']")
	WebElement MySettings;

	@FindBy(xpath = "//span[@id='PersonalInfo_font']")
	WebElement Personal;

	@FindBy(xpath = "//a[@id='LoginHistory_font']")
	WebElement loginHistory;

	@FindBy(xpath = "//a[contains(text(),'Download login history for last six months, includ')]")
	WebElement loginDownload;

	@FindBy(xpath = "//span[@id='DisplayAndLayout_font']")
	WebElement displayLayout;

	@FindBy(xpath = "//span[@id='CustomizeTabs_font']")
	WebElement CustomizeTab;

	@FindBy(id = "p4")
	WebElement dropdown;

	@FindBy(id = "duel_select_0")
	WebElement availableTabs;

	@FindBy(xpath = "//img[@class='rightArrowIcon']")
	WebElement Add_Aroow;

	@FindBy(id = "EmailSetup_font")
	WebElement Email;

	@FindBy(id = "EmailSettings_font")
	WebElement emailSetting;

	@FindBy(id = "sender_email")
	WebElement email;

	@FindBy(xpath = "//input[@id='sender_name']")
	WebElement senderName;

	@FindBy(xpath = "//input[@id='auto_bcc1']")
	WebElement RadioButton;

	@FindBy(id = "CalendarAndReminders_font")
	WebElement CalenderAndReminder;

	@FindBy(id = "Reminders_font")
	WebElement ActivityRemainder;

	@FindBy(xpath = "//input[@value='Open a Test Reminder']")
	WebElement Remainder;

	@FindBy(xpath = "//a[normalize-space()='Developer Console']")
	WebElement DeveloperConsole;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement Logout;

	public void clickOnLogout() {
		waitForElement(30, Logout);
		Logout.click();
	}

	public void clickOnDeveloperConsole() {
		DeveloperConsole.click();
	}

	public void clickOnTestRemainder() {
		Remainder.click();
	}

	public void clickOnActivityRemainder() {
		ActivityRemainder.click();
	}

	public void clickOnCallenderAndReminder() {

		CalenderAndReminder.click();
	}

	public void clickOnRadioButton() {
		RadioButton.click();
	}

	public void enterName(String Sname) {
		senderName.sendKeys(Sname);
	}

	public void enterIntoEmail(String stremail) {

		waitForElement(30, email);
		email.clear();
		email.sendKeys(stremail);
	}

	public void cliclOnEmailSettings() {
		waitForElement(30, emailSetting);
		emailSetting.click();
	}

	public void clickOnEmail() {
		waitForElement(30, Email);
		Email.click();
	}

	public void clickOnAdd() {

		waitForElement(10, Add_Aroow);

		Add_Aroow.click();
	}

	public void availableTabsDropdown() {

		waitForElement(10, availableTabs);

		Select options = new Select(availableTabs);
		options.selectByVisibleText("Reports");
	}

	public void dropDown() {

		waitForElement(10, dropdown);

		Select dropdownOptions = new Select(dropdown);
		dropdownOptions.selectByVisibleText("Salesforce Chatter");
	}

	public void customizeTab() {

		waitForElement(10, CustomizeTab);

		CustomizeTab.click();
	}

	public void displayAndLayout() {
		waitForElement(30, displayLayout);
		displayLayout.click();

	}

	public void clickOnLoginhistoryDownload() {
		waitForElement(30, loginDownload);
		loginDownload.click();
	}

	public void clickOnLoginHistory() {
		waitForElement(30, loginHistory);
		loginHistory.click();
	}

	public void clickOnPersonal() {
		waitForElement(20, Personal);

		Personal.click();
	}

	public void selectMySettings() {
		MySettings.click();
	}

	public void clickOnAbout() {
		waitForElement(30, About);

		About.click();
	}

	public void switchFrame() {

		waitForElement(30, profileIframe);

		driver.switchTo().frame(profileIframe);

	}

	public void edit() {

		waitForElement(20, editProfile);

		editProfile.click();

	}

	public void clickHome() {
		waitForElement(20, Home);
		Home.click();

	}

	public void selectUsernameDropdown() {
		waitForElement(30, UserMenu);
		UserMenu.click();
	}

	public void selectMyProfile() {

		waitForElement(30, MyProfile);
		MyProfile.click();

	}
}