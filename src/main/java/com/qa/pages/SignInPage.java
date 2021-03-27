package com.qa.pages;

import com.qa.base.Page;

public class SignInPage extends Page {

	public ZohoAppPage doSignIn(String email, String password) {

		// Enter the EmailID
		type("loginID_XPATH", email);

		// Click on Next button
		click("nextBtn_XPATH");

		// Enter the Password
		type("passwoord__XPATH", password);

		// Click on Login button
		click("loginBtn_XPATH");

		return new ZohoAppPage();

	}

}
