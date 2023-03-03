package com.training.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class CreateOpertunitiesPage extends BasePage {
	public CreateOpertunitiesPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//li[@id='Opportunity_Tab']")
	WebElement OpportunityTab;

	public void clickOnOpportunityTab() {

		waitForElement(30, OpportunityTab);

		OpportunityTab.click();

	}

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement listDropdown;

	public void clickOnAllOpportunities() {

		waitForElement(30, listDropdown);
		Select dropdown = new Select(listDropdown);
		// Get all options
		List<WebElement> dd = dropdown.getOptions();

		// Get the length
		System.out.println(dd.size());

		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());

		}
	}

	@FindBy(xpath = "//input[contains(@title,'New')]")
	WebElement NewButton;

	public void clickOnNewButton() {
		waitForElement(30, NewButton);
		NewButton.click();

	}

	@FindBy(id = "opp3")
	WebElement Oppname;

	public void enterOpportunityName() {
		Oppname.clear();
		Oppname.sendKeys("XYZ");
		WebElement LookupWindow = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		LookupWindow.click();
		String oldWindow = driver.getWindowHandle();
		// Switching driver control to new window.
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);

		waitForElement(30, NewButton);
		// switch to first frame
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("abc456");
		driver.findElement(By.xpath("//input[@name='go']")).click();

		// Switching to Lookup Window
		driver.switchTo().defaultContent();

		// Switching to Insideframe(result)

		driver.switchTo().frame("resultsFrame");
		waitForElement(30, NewButton);
		driver.findElement(By.xpath("//tr[@class='dataRow even last first']/th/a")).click();

		driver.switchTo().window(getWindow[0]);
		waitForElement(30, NewButton);

		// Coming out of the window to original window.
		driver.findElement(By.xpath("//input[@id='opp9']")).click();
		WebElement today = driver.findElement(By.xpath("//a[@class='calToday']"));
		today.click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		WebElement Stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		Stage.click();

		Select dropdown = new Select(Stage);
		dropdown.selectByValue("Qualification");
		driver.findElement(By.xpath("//input[@id='opp12']")).sendKeys("80");
	}

	@FindBy(xpath = "//a[contains(text(),'Stuck Opportunities')]")
	WebElement StuckOpportunities;

	public void clickOnStuckOpportunities() {
		waitForElement(30, StuckOpportunities);
		StuckOpportunities.click();
	}
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	WebElement OpportunityPipeline;

	public void clickOnOpportunityPipeline() {
		waitForElement(30, OpportunityPipeline);
		OpportunityPipeline.click();
	}
	@FindBy(xpath = "//input[@title='Run Report']")
	WebElement  RunReport;

	public void clickOnRunReport() {
		waitForElement(30,  RunReport);
		 RunReport.click();
	}
}
