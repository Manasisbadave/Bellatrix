package com.bellatrix.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.base.TestBase;
import com.bellatrix.base.keyword;

public class SearchComponentPage extends TestBase{

	@FindBy(css="#woocommerce-product-search-field-0")
	WebElement searchComponent;

	@FindBy(xpath="//p[@class='woocommerce-info']")
	WebElement searchResults;
	
	@FindBy(css="h2[class*='title']")
	List<WebElement> productTitles;
	
	
	public void searchComponentSendKeys(String searchItem) throws InterruptedException {

		Thread.sleep(3000);
		searchComponent.sendKeys(searchItem+Keys.ENTER);
		
	}
	
	public List<String> verifySearchResult(String productName) {

		keyword key = new keyword();
		WebElement searchKeyword = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
		searchKeyword.sendKeys(productName+Keys.RETURN);
			
		List<String> productsList = key.getTexts("css","h2.woocommerce-loop-product__title");
		return productsList;

	}
	public List<String> getProductTitles() {
		List<String> titles =  new ArrayList<String>();
		
		for (WebElement productTitle : productTitles)
		{
			titles.add(productTitle.getText());
		}
		
		return titles;
	}
	
	public void searchProduct(String productName) {

		searchComponent.sendKeys(productName);

		searchComponent.sendKeys(Keys.RETURN);

	}
	public boolean verifyInvalidSearchResult(String productName) {
		
		/*WebElement searchKeyword = driver.findElement(By.cssSelector("#woocommerce-product-search-field-0"));
		searchKeyword.sendKeys(productName+Keys.RETURN);

		//WebElement searchResult=driver.findElement(By.xpath("//p[@class='woocommerce-info']"));
		String result="";
		
		result=searchResult.getText();
		
		System.out.println(result);
		
		
	
		
		return result.contains("No products were found");*/
		searchComponent.sendKeys(productName+Keys.RETURN);
		
		List<String> titles =  new ArrayList<String>();
		
		for (WebElement productTitle : productTitles)
		{
			titles.add(productTitle.getText());
		}
		if(titles.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
