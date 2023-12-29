package bellatrix;

import com.bellatrix.listeners.myListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bellatrix.base.TestBase;
import com.bellatrix.pages.HomePage;

//@Listeners(myListener.class)
public class HomePageTests extends TestBase {

	HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);

	@Test
	public void verifyUrl() {

		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.equalsIgnoreCase("https://demos.bellatrix.solutions/"),
				"URL does not match with current URL");
	}

	@Test
	public void verifySearchFieldPresentOnHomePage() {

		boolean isElementPresent = homepage.isSearchComponentPresent();
		Assert.assertTrue(isElementPresent);
	}

	@Test
	public void verifyCartButtonPresentOnHomePage() {

		boolean isElementPresent = homepage.isCartButtonPresent();
		Assert.assertTrue(isElementPresent);
	}

	// DriverTransfer
//	public HomePage login()
//	{
//		login.click();
//		return new HomePage(driver);
//		
//	}

	@Test
	public void verifySortByPriceLowToHigh() throws InterruptedException {

		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
		homepage.selectSortingMethod("price");
		Thread.sleep(5000);
		float[] priceL = homepage.getProductPriceList();
		boolean areElementsSorted = homepage.areElementsSortedByPriceLowToHigh(priceL);
		Assert.assertTrue(areElementsSorted);

	}

	@Test
	public void verifySortByPriceHighToLow() throws InterruptedException {

		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
		homepage.selectSortingMethod("price-desc");
		Thread.sleep(5000);
		float[] priceL = homepage.getProductPriceList();
		boolean areElementsSorted = homepage.areElementsSortedByPriceHighToLow(priceL);
		Assert.assertTrue(areElementsSorted);

	}

	@Test
	public void isProductAddedInCart() throws InterruptedException {

		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
		homepage.selectSortingMethod("price-desc");
		homepage.clickOnAddToCartBtn();
		
	}
}
