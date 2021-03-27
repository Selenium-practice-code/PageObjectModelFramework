package com.qa.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qa.base.Page;
import com.qa.pages.HomePage;
import com.qa.pages.SignInPage;
import com.qa.utilities.Utilities;

public class SignInTest extends Page {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void signInTest(Hashtable<String,String> data) {

		HomePage home = new HomePage();
		SignInPage sip = home.signIn();
	    sip.doSignIn(data.get("username"), data.get("password"));

	}

}
