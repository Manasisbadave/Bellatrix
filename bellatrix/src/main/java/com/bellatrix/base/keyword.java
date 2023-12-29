package com.bellatrix.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class keyword {

@BeforeMethod
	public void openBrowser(String browserName) {


		if (browserName.equalsIgnoreCase("Chrome")) {
			TestBase.driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox ")) {
			TestBase.driver = new FirefoxDriver();
		}
		TestBase.driver.manage().window().maximize();
	}

	public void launchUrl(String url) {
		TestBase.driver.get(url);
	}

	public void enterText(WebElement e, String textToEnter) {

		e.sendKeys(textToEnter);
	}

	public WebElement getWebElement(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {
			return TestBase.driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return TestBase.driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return TestBase.driver.findElement(By.cssSelector(locatorValue));
		} else
			return null;
	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {
			return TestBase.driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return TestBase.driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return TestBase.driver.findElements(By.cssSelector(locatorValue));
		} else
			return null;
	}
	public void enterText(String locatorType, String locatorValue, String textToEnter) {

		getWebElement(locatorType, locatorValue).sendKeys(textToEnter,Keys.RETURN);

	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();

	}
	
	public String getText(String locatorType,String locatorValue) {

		return getWebElement(locatorType,locatorValue).getText();
	}
	public List<String> getTexts(String locatorType, String locatorValue) {

		List<WebElement> data=getWebElements(locatorType,locatorValue);
		System.out.println(locatorType+" "+locatorValue);
		List<String> stringData=new ArrayList();
		for(WebElement element:data) {
			
			stringData.add(element.getText());
		}
		return stringData;
	}
}
