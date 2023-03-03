package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) { // parameterized constructor
		super(driver);
	}
	@FindBy(xpath="//a[@title='Contacts Tab']")
	WebElement contact ;
	public void clickOnContacts() {
		waitForElement(10, contact);
		contact.click();
	}
	@FindBy(xpath="//input[contains(@title,'New')]")
	WebElement  new_Element ;
	public void clickOnNew() {
		waitForElement(10,  new_Element);
		 new_Element.click();
	}
	@FindBy(xpath="//input[@id='name_firstcon2']")
	WebElement  first_Name ;
	public void enterIntoFirstname() {
		waitForElement(10,  first_Name);
		first_Name.sendKeys("Mango");
	}
	@FindBy(xpath="//input[@id='name_lastcon2']")
	WebElement  last_Name ;
	public void enterIntolastname() {
		waitForElement(10,  last_Name);
		last_Name.sendKeys("Trade");
	}
	@FindBy(xpath=" //td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement SaveButton;
	public void clickOnSave() {
		waitForElement(40, SaveButton);
		SaveButton.click();
	}

}


