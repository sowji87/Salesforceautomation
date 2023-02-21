package com.training.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.training.utilities.Constants.* ;

public class BaseTest {
	
	private WebDriver driver;
	
	public WebDriver getDriver(String browser) {
		
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		 	WebDriverManager.firefoxdriver().setup();
		 	driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		return driver;
		
	}
	
	public void takescreenshot(WebDriver driver)  {
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date currentDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(currentDate);
		
		String reportFilePath = USER_DIR+FILE_SEPARATOR+SCREENSHOT_PATH;
		String fileName = "Saleforce"+timeStamp+".png";
	    String filepath = reportFilePath+FILE_SEPARATOR+fileName;
		
         File destFile = new File(filepath);
    
	try {
		FileUtils.copyFile(scrFile, destFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}


}
