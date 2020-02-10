package com.generic.tests.BD.HomePage;

import com.generic.setup.Common;
import com.generic.setup.SelTestCase;
import com.generic.page.HomePage;

public class GlobalFooterValidation extends SelTestCase {
	public static boolean validate() throws Exception {
		getCurrentFunctionName(true);
		if(isMobile())
			Common.refreshBrowser();
		boolean isCountrySelectorDisplayed = HomePage.validateCountrySelectorDisplayed();
		boolean isFooterItemsDisplayed = HomePage.validateGlobalFooterItemsDisplayed();

		sassert().assertTrue(isCountrySelectorDisplayed && isFooterItemsDisplayed,
				"Global footer validation has some problems");
		getCurrentFunctionName(false);
		return isCountrySelectorDisplayed && isFooterItemsDisplayed;
	}
}
