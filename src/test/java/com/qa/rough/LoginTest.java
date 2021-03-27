package com.qa.rough;

import com.qa.base.Page;
import com.qa.pages.HomePage;
import com.qa.pages.SignInPage;
import com.qa.pages.ZohoAppPage;
import com.qa.pages.crm.accounts.AccountsPage;
import com.qa.pages.crm.accounts.CreateAccountPage;

public class LoginTest {

	public static void main(String[] args) {

		//This is rough work
		HomePage home = new HomePage();
		SignInPage sip = home.signIn();

		ZohoAppPage appPage = sip.doSignIn("practiceselenium7@gmail.com", "Sonyc905");
		appPage.crm();

		AccountsPage account = Page.menu.accounts();
		CreateAccountPage cap = account.ClickOnCreateAccounts();
		cap.createAccount("Rohit");

	}

}
