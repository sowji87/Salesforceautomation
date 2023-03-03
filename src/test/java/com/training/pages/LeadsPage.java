package com.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.training.base.BasePage;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) { // parameterized constructor
		super(driver);
	}

	@FindBy(xpath="//a[@title='Leads Tab']")
	WebElement LeadsTab;
	public void clickOnLeadsTab() {
		waitForElement(40, LeadsTab);
		LeadsTab.click();
		
	}
	@FindBy(xpath="//select[@id='fcf']")
	WebElement LeadSelect;
	public void clickOnLeadSelect() {
		waitForElement(40, LeadSelect);
		LeadSelect.click();
		Select view = new Select(LeadSelect);
		view.selectByIndex(3);

	    //Get all options
	    List<WebElement> vew = view.getOptions();

	    //Get the length
	    System.out.println(vew.size());

	    // Loop to print one by one
	    for (int j = 0; j < vew.size(); j++) {
	        System.out.println(vew.get(j).getText());

	    }
	
	}
	@FindBy(xpath="//input[@value=\" Go! \"]")
	WebElement Go;
	
	
	  public void clickOnButton() { 
		  waitForElement(40, Go); 
		  Go.click();
	  
	  }
	  @FindBy( xpath="//input[@title='New']")
	  WebElement New;
		public void clickOnNew() {
			waitForElement(40, New); 
			New.click();
		}
		
		@FindBy(xpath="//input[@id='name_lastlea2']")
		WebElement LastName;
		public void enterLastName(String lastname) {
			waitForElement(40, LastName); 
			LastName.sendKeys(lastname);
		}
		@FindBy(xpath="//input[@id='lea3']")
		WebElement CompanyName;
		public void enterCompantName(String name) {
			waitForElement(40, CompanyName); 
			CompanyName.sendKeys(name);
			
		}
		@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")
		WebElement SaveButton;
		public void clickOnSave() {
			waitForElement(40, SaveButton);
			SaveButton.click();
		}
}
