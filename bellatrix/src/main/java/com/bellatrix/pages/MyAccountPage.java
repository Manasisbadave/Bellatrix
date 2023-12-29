package com.bellatrix.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.config.configuration;

public class MyAccountPage{

	public configuration config;
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[@class='show-password-input']")
	WebElement passwordVisibility;
	
	public void enterUsername() {
		config=new configuration();
		String uname=config.getUsername();
		username.sendKeys(uname);
	}
	
	public void enterPassword() {

		config=new configuration();
		String passw=config.getPassword();
		password.sendKeys(passw);
	}
	
	public void clickOnLoginBtn() {

		loginBtn.click();
	}

	public void selectPasswordVisibilty() {

		passwordVisibility.click();
	}
}
