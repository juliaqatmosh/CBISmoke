package com.generic.tests.BD.HomePage;

import com.generic.page.HomePage;
import com.generic.setup.Common;
import com.generic.setup.SelTestCase;

public class LogoValidation extends SelTestCase {

	public static void validate() throws Exception {
		getCurrentFunctionName(true);
		if(isMobile())
			Common.refreshBrowser();
		sassert().assertTrue(HomePage.validateLogodisplayed(), "Logo is not displayed");
		HomePage.NavigateAwayFromHomePage();
		HomePage.clickOnLogo();
		sassert().assertTrue(HomePage.validateHomePageLink(), "Logo doesnt redirect to home page");
		getCurrentFunctionName(false);

	}

}
