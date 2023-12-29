package com.bellatrix.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.base.TestBase;

public class cartPage extends TestBase{

	@FindBy(xpath="//div[@class='quantity']/input[@id='quantity_655c9655b2ede']")
	WebElement quantity;
	
	String productId="12";
	@FindBy(xpath="//a[@data-product_id='12']")
	WebElement removeFromCartBtn;
	
	public void adjustQuantity(String quantityNo) throws InterruptedException {

		Actions action=new Actions(driver);
		
		action.click(quantity);
		action.sendKeys(quantity, quantityNo);
		action.sendKeys("2"+Keys.ENTER);
		/*quantity.click();
		quantity.clear();
		quantity.sendKeys(quantityNo+Keys.RETURN);*/
		
		
		System.out.println("Quantity updated to "+quantityNo);
		
	}
	public void removeFromCart() {

		removeFromCartBtn.click();
	}
	public void verifySubtotal() {

		
	}
}
