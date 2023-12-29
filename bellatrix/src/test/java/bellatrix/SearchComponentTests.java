package bellatrix;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.bellatrix.base.TestBase;
import com.bellatrix.pages.SearchComponentPage;
import com.bellatrix.base.keyword;

public class SearchComponentTests extends TestBase{

	
	keyword key = new keyword();
	
	@Test
	public void verifySearchResultsArePopulatingCorrectResults() throws InterruptedException {
		
		SearchComponentPage searchPage = PageFactory.initElements(getDriver(), SearchComponentPage.class);
		searchPage.searchProduct("falcon");
		String Product = "Falcon";
		List<String> productsList=searchPage.getProductTitles();
		for(String productTitle:productsList)
		{
			System.out.println(productTitle);
		
		boolean x=productTitle.toLowerCase().contains(Product.toLowerCase());
			Assert.assertEquals(x,true);
		}
	}
	
	@Test
	public void verifySearchResultWithInvalidInput() {
		SearchComponentPage searchPage = PageFactory.initElements(getDriver(), SearchComponentPage.class);
		boolean searchResult=searchPage.verifyInvalidSearchResult("facn");
		
		Assert.assertTrue(searchResult);
		
	}
}
