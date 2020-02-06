package com.generic.tests.RY.e2e;

import java.text.MessageFormat;
import java.util.NoSuchElementException;
import com.generic.page.PDP;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.PDPs;
import com.generic.setup.SelTestCase;
import com.generic.tests.RY.PDP.PDPValidation;

public class PDP_e2e extends SelTestCase {

	public static final String singlePDPSearchTerm = "Rugs";

	public static void Validate() throws Exception {

		try {
			getCurrentFunctionName(true);
			/*
			PDP.NavigateToPDP();
			PDPValidation.validate();
			*/
			PDPs.navigateToRandomPDP();
			Thread.sleep(2500);
			PDP.clickAddToCartButtonNoBundle();
			Thread.sleep(3500);

			getCurrentFunctionName(false);
		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}
