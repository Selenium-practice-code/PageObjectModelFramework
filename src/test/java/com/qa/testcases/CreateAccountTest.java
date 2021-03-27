package com.qa.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qa.base.Page;
import com.qa.pages.ZohoAppPage;
import com.qa.pages.crm.accounts.AccountsPage;
import com.qa.pages.crm.accounts.CreateAccountPage;
import com.qa.utilities.Utilities;

public class CreateAccountTest extends Page {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {

		ZohoAppPage appPage = new ZohoAppPage();
		appPage.crm();

		AccountsPage account = Page.menu.accounts();

		CreateAccountPage createAccountPage = new CreateAccountPage();
		account.ClickOnCreateAccounts();
		createAccountPage.createAccount(data.get("AccountName"));

	}

}
