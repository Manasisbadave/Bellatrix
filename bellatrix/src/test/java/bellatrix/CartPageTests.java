package bellatrix;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.bellatrix.base.TestBase;
import com.bellatrix.pages.HomePage;
import com.bellatrix.pages.SearchComponentPage;
import com.bellatrix.pages.cartPage;
import com.bellatrix.pages.productSpecificationPage;

public class CartPageTests extends TestBase{

	@Test
	public void testScenario1() throws InterruptedException {
		
		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
		SearchComponentPage searchPage = PageFactory.initElements(getDriver(), SearchComponentPage.class);
		productSpecificationPage productPage=PageFactory.initElements(getDriver(), productSpecificationPage.class);
		cartPage cartpage = PageFactory.initElements(getDriver(), cartPage.class);
		
		
		homepage.selectSortingMethod("price-desc");
		homepage.clickOnHighestPriceElement();
		Thread.sleep(3000);
		
		productPage.clickOnAddToCartBtn();
		homepage.clickOnCartButton();
		Thread.sleep(10000);
		cartpage.adjustQuantity("2");

		//cartpage.removeFromCart();
		Thread.sleep(5000);
		
		
		
		

	}
	
	
}
