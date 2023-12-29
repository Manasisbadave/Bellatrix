package com.bellatrix.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productSpecificationPage {
	
	@FindBy(css="#quantity_655c85f4f38e0")
	WebElement quantity;
	
	
	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	WebElement addToCartBtn;
	
	
	public void clickOnAddToCartBtn() {

		addToCartBtn.click();
	}

}
