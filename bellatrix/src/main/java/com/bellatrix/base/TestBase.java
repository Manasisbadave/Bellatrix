package com.bellatrix.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.bellatrix.config.configuration;





public class TestBase {

	public static RemoteWebDriver driver;
	public configuration config;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public RemoteWebDriver setUp(@Optional String browserName) {

		config = new configuration();

		if (browserName == null) {
			browserName = "Chrome";
		}

		if (browserName.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();

		else if (browserName.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else {
			System.out.println("Launching default browser:Chrome");
			driver = new ChromeDriver();
		}
		String url = config.getAppUrl();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		return driver;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	public static RemoteWebDriver getDriver() {

		return driver;
	}

}
