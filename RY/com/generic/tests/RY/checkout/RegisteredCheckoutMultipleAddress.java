package com.generic.tests.RY.checkout;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import com.generic.page.CheckOut;
import com.generic.page.Registration;
import com.generic.setup.ExceptionMsg;
import com.generic.setup.GlobalVariables;
import com.generic.setup.LoggingMsg;
import com.generic.setup.SelTestCase;
import com.generic.util.RandomUtilities;

public class RegisteredCheckoutMultipleAddress extends SelTestCase {

	public static void startTest(int productsCount, LinkedHashMap<String, String> addressDetails,
			LinkedHashMap<String, String> paymentDetails, LinkedHashMap<String, String> userDetalis) throws Exception {
		getCurrentFunctionName(true);

		try {
			String orderSubTotal;
			String orderTax;
			String orderShipping;

			String fName = "FirstVisa";
			String lName = "LastVisa";
			String userMail = RandomUtilities.getRandomEmail();
			String userPassword = "TestITG226";

			int productsCountStepTWO = 0;

			// Perform Registration
			Registration.registerFreshUser(userMail, userPassword, fName, lName);

			// Add products to cart
			 CheckOut.searchForProductsandAddToCart(productsCount);

			 // Navigating to Cart by URL
			CheckOut.navigatetoCart();

			// Clicking begin secure checkout
			CheckOut.clickBeginSecureCheckoutButton();

			// Clicking multiple addresses tab
			CheckOut.clickMultipleAddressesTab();

			Thread.sleep(1000);

			// Add addresses for each product and save them
			CheckOut.fillCheckoutFirstStepAndSave(productsCount, addressDetails);

			Thread.sleep(2500);

			CheckOut.proceedToStepTwo();

			Thread.sleep(1500);

			// Check number of products in step 2
			sassert().assertTrue(CheckOut.checkProductsinStepTwo() >= productsCount,
					"Some products are missing in step 2 ");
			productsCountStepTWO = CheckOut.checkProductsinStepTwo();

			// Proceed to step 3
			CheckOut.proceedToStepThree();

			// Proceed to step 4
			CheckOut.proceedToStepFour();

			Thread.sleep(4000);

			// Saving tax and shipping costs to compare them in the confirmation page
			orderShipping = CheckOut.getShippingCostsRYInStep4();
			orderTax = CheckOut.getTaxCostsRYInStep4();
			orderSubTotal = CheckOut.getSubTotal();

			logs.debug(MessageFormat.format(LoggingMsg.SEL_TEXT, "Shippping cost is: " + orderShipping
					+ " ---- Tax cost is:" + orderTax + " ---- Subtotal is:" + orderSubTotal));

			Thread.sleep(2000);

			// Fill payment details in the last step
			CheckOut.fillPayment(paymentDetails);

			// Click place order button
			CheckOut.placeOrder();

			Thread.sleep(3500);

			CheckOut.closePromotionalModal();

			// Check number of products in confirmation page
			sassert().assertTrue(CheckOut.checkProductsinConfirmationPage() == productsCountStepTWO,
					"Some products are missing in confirmation page ");

			// Check if shipping costs match
			sassert().assertTrue(CheckOut.getShippingCosts().equals(orderShipping),
					"Shipping cost value issue " + CheckOut.getShippingCosts() + "vs" + orderShipping);

			// Check if tax cost match
			sassert().assertTrue(CheckOut.getTaxCosts(GlobalVariables.FG_TAX_CONFIRMATION).equals(orderTax),
					"Tax value issue " + CheckOut.getTaxCosts(0) + "vs" + orderTax);

			// Check if subtotal value match
			sassert().assertTrue(CheckOut.getSubTotal().equals(orderSubTotal),
					"Subtotal value issue " + CheckOut.getSubTotal() + "vs" + orderSubTotal);

			getCurrentFunctionName(false);

		} catch (NoSuchElementException e) {
			logs.debug(MessageFormat.format(ExceptionMsg.PageFunctionFailed, new Object() {
			}.getClass().getEnclosingMethod().getName()));
			throw e;
		}

	}

}