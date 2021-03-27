package com.qa.pages;

import com.qa.base.Page;

public class HomePage extends Page {

	public void customers() {

		// Click on Customer link
		click("customers_XPATH ");

	}

	public void support() {

		// Click on support link
		click("support_XPATH");

	}

	public void contactSales() {

		// Click on contact Sales link
		click("contactSales_XPATH");

	}

	public SignInPage signIn() {

		// Click on signIn link
		click("signIn_XPATH");
		return new SignInPage();

	}

	public void FreeSignUp() {

		// Click on Free SignUp link
		click("FreeSignUp_XPATH");

	}

	public void searchIcon() {

		// Click on searchIcon link
		click("searchIcon_XPATH");

	}

	public void learnMore() {

		// Click on learn More link
		click("learnMore_XPATH");

	}

	public void validateFooterLinks() {

	}

}
