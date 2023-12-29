package bellatrix;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.bellatrix.base.TestBase;
import com.bellatrix.pages.HomePage;
import com.bellatrix.pages.MyAccountPage;

public class MyAccountTests extends TestBase{

	

	@Test
	public void verifyLoginSuccess() throws InterruptedException {

		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
		MyAccountPage myaccpage = PageFactory.initElements(getDriver(), MyAccountPage.class);
		
		homepage.navigateToMyAccountPage();
		myaccpage.enterUsername();
		Thread.sleep(2000);
		myaccpage.enterPassword();
		Thread.sleep(5000);
		myaccpage.clickOnLoginBtn();
		Thread.sleep(5000);
		
		
	}
}
