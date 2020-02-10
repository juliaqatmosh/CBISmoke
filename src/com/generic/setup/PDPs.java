package com.generic.setup;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class PDPs extends SelTestCase {
	public static Random random = new Random();

	static String[] GHproducts = new String[] {};

	static String[] BDproducts = new String[] {};

	static String[] GRproducts = new String[] {};

	static String[] FGproducts = new String[] {};

	static String[] RYproducts = new String[] {};

	public static void navigateToRandomPDP() throws URISyntaxException {
		getCurrentFunctionName(true);

		String productURL;
		
		ArrayList<String> brandProduct = (ArrayList<String>) products.get(getBrand());

		productURL = brandProduct.get(random.nextInt(brandProduct.size()-1));
	

		getDriver().get(new URI(getDriver().getCurrentUrl()).resolve(productURL).toString());

		getCurrentFunctionName(false);

	}//Navigate Method


}//Class
