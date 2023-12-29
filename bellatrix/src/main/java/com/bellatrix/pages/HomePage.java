package com.bellatrix.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.bellatrix.base.TestBase;
import com.bellatrix.base.keyword;

public class HomePage {

//	public HomePage(WebDriver driver1 )
//	{
//		WebDriver driver;
//		driver=driver1;
//	}

	@FindBy(xpath = "//input[@id='woocommerce-product-search-field-0']")
	WebElement searchComponent;

	@FindBy(xpath = "//ul[@class='nav-menu']//a[normalize-space()='Cart']")
	WebElement cartComponent;


	@FindBy(xpath = "(//select[@class='orderby'])[1]")
	WebElement homepgSort;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/main[1]/div[1]/form[1]/select[1]")
	WebElement homepageSort;
	
	@FindBy(xpath="//a[@aria-label='Add “Proton Rocket” to your cart']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Falcon Heavy']")
	WebElement clickOnProduct;
	
	@FindBy(xpath="(//select[@class='orderby'])[1]")
	WebElement sort;
	
	@FindBy(xpath="//h2[@class='woocommerce-loop-product__title']")
	List<WebElement> prodctTitlesList;
	
	@FindBy(xpath="//h2[normalize-space()='Proton Rocket']")
	WebElement highestPriceElement;

	@FindBy(xpath = "//ul[@class='products columns-4']//ins//bdi")
	List<WebElement> priceList;
	
	@FindBy(xpath="//a[@title='View your shopping cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//ul[@class='nav-menu']//a[normalize-space()='My account']")
	WebElement myAccountBtn;
	
	public void navigateToMyAccountPage() {

		myAccountBtn.click();
	}
	public void clickOnCartButton() {

		cartButton.click();
	}
	public void clickOnHighestPriceElement() {

		highestPriceElement.click();
	}
	public void getProductTitlesList() {

		keyword key = new keyword();
		
	}
	public void searchProduct(String productName) {

		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.RETURN);
	}
	public void openProductSpecification() {

		clickOnProduct.click();
	}
	public void clickOnAddToCartBtn() {

		addToCartBtn.click();
		
	}
	public boolean isSearchComponentPresent() {

		return searchComponent.isDisplayed();
	}

	public boolean isCartButtonPresent() {

		return cartComponent.isDisplayed();
	}
	

	public float[] getProductPriceList() {
	 	
		float[] priceL = new float[4];
		int i = 0;
		for (WebElement element : priceList) {

			String data = element.getText();
			data = data.replaceAll("[^0-9|.]", "");
			float price = Float.parseFloat(data);
			priceL[i] = price;

			System.out.println(priceL[i]);

			if (i < priceL.length) {
				i++;
			}
		}
		return priceL;
	}

	public boolean areElementsSortedByPriceLowToHigh(float[] priceList) {

		for (int i = 0; i < priceList.length - 1; i++) {
			if (priceList[i] > priceList[i + 1]) {
				return false;
			}
		}

		return true;

	}

	public boolean areElementsSortedByPriceHighToLow(float[] priceList) {

		for (int i = 0; i < priceList.length - 1; i++) {
			if (priceList[i] < priceList[i + 1]) {
				return false;
			}
		}

		return true;
	}
	
	public void selectSortingMethod(String sortType) throws InterruptedException {
		Thread.sleep(5000);
		
		Select select = new Select(sort);
		select.selectByValue(sortType);

	}
	
	
}
