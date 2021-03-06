package com.generic.selector;

import com.generic.setup.cselector;

public class CLPSelectors
{
	public static final String header = "yCmsContentSlot product-grid-section1-slot";
	public static final cselector CLPItems = new cselector("css,div.container.grid-subcategories>div>div>div.wrapper>a" , "css,div.container.grid-subcategories>div>div>div.wrapper>a" , "css,.t-category-list__category > a.pw-link");
	public static final cselector GHCLPItems = new cselector("css,div.gwt-sub-sub-category-main-container > a","css,div > div.gwt-product-info-panel-image-container > a", "css,div.t-category-list__categories a.pw-link");
	//#gwt-uid-192 > a
	public static final cselector BDCLPItems = new cselector("css,.gwt-MenuItem a" , "css,.pw-nav-menu__panel > div > div > a");
}
