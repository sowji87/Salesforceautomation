package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Accounts']")
	WebElement CreateAccount;

	@FindBy(xpath = "//input[@value=' New ']")
	WebElement New;

	@FindBy(id = "acc2")
	WebElement AccountName;

	@FindBy(xpath = "//select[@id='acc6']")
	WebElement Type;

	@FindBy(id = "00N5g00000bxNJi")
	WebElement Priority;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@title='Save']")
	WebElement save;

	@FindBy(xpath = "//a[normalize-space()='Create New View']")
	WebElement CreateNewView;

	@FindBy(id = "fname")
	WebElement ViewName;

	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement ViewSave;

	public void clickOnViewSaveButton() {
		ViewSave.click();
	}

	public void enterViewName(String strName) {

		waitForElement(10, ViewName);

		ViewName.sendKeys(strName);
	}

	@FindBy(id = "devname")
	WebElement UniqueViewName;

	@FindBy(xpath = "//select[@id='fcf']")
	WebElement SelectView;

	@FindBy(xpath = "//a[normalize-space()='Edit']")
	WebElement Edit;

	@FindBy(xpath = "(//select[@id='fcol1'])[1]")
	WebElement FilterField;

	public void selectByAccountName() {
		waitForElement(20, FilterField);
		Select AccName = new Select(FilterField);
		AccName.selectByValue("ACCOUNT.NAME");
	}

	@FindBy(xpath = "//select[@id='fop1']")
	WebElement operator;

	public void selectOperator() {
		waitForElement(10, operator);
		Select AccName = new Select(operator);
		AccName.selectByValue("c");
	}

	@FindBy(xpath = "(//input[@id='fval1'])[1]")
	WebElement Value;

	@FindBy(xpath = "(//input[@title='Save'])[2]")
	WebElement clickSave;

	public void ClickonSave() {
		clickSave.click();
	}

	public void enterValue(String strValue) {
		waitForElement(20, Value);

		Value.sendKeys(strValue);
	}

	public void clickEdit() {

		waitForElement(10, Edit);

		Edit.click();
	}

	public void selectView() {
		waitForElement(10, SelectView);
		Select view = new Select(SelectView);
		view.selectByVisibleText("work");

	}

	public void enterUniqueViewName(String strUName) {
		waitForElement(10, UniqueViewName);
		UniqueViewName.clear();
		UniqueViewName.sendKeys(strUName);
	}

	public void clickOnNewView() {
		waitForElement(10, CreateNewView);

		CreateNewView.click();
	}

	public void clickOnSaveButton() {
		save.click();
	}

	public void customerPriority() {
		waitForElement(10, Priority);

		Select PriorityOption = new Select(Priority);
		PriorityOption.selectByValue("High");
	}

	public void clickOnSelectType() {

		waitForElement(20, Type);

		Select typeOption = new Select(Type);
		typeOption.selectByValue("Technology Partner");

	}

	public void enterAccountName(String accName) {

		waitForElement(30, AccountName);

		AccountName.sendKeys(accName);
	}

	public void clickOnNewButton() {
		waitForElement(20, New);

		New.click();

	}

	public void clickOnCreateAccount() {
		waitForElement(20, CreateAccount);
		CreateAccount.click();
	}

	@FindBy(xpath = "//a[@href=\"/001/o\"]")
	WebElement AccountTab;

	public void clickOnAccountTab() {
		waitForElement(30, AccountTab);
		AccountTab.click();

	}
	@FindBy(xpath = "//input[@id='cid0']")
	WebElement Button1;


	public void mergeAccounts1() throws Exception {

		WebElement fb = driver.findElement(By.id("srch"));
		fb.clear();

		enterText(fb, "sai", "FindAccounts");
		WebElement FindAcc = driver.findElement(By.name("srchbutton"));
		waitForElement(20, FindAcc);

		clickObj(FindAcc, "FindAcc");
		waitForElement(20, Button1);
		Radiobutton(Button1, "RadioButton");
		WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
		Radiobutton(Button2, "RadioButton");
		WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
		Radiobutton(Button3, "RadioButton");
		WebElement Next = driver
				.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]"));
		Next.click();
		WebElement Merge = driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
		Merge.click();
		switchtoAlert(driver);
		System.out.println("TC13_MergeAccounts is completed");
	}

	@FindBy(xpath = "//a[@href=\"/merge/accmergewizard.jsp?retURL=%2F001%2Fo\"]")
	WebElement Mergeacc;

	public void mergeAccounts() {

		waitForElement(20, Mergeacc);

		clickObj(Mergeacc, "Mergeacc");
	}

	
}