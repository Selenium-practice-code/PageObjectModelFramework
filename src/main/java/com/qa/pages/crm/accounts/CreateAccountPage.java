package com.qa.pages.crm.accounts;

import com.qa.base.Page;

public class CreateAccountPage extends Page {

	public void createAccount(String accountName) {

		// Enter the Account Name
		type("accountName_XPATH", accountName);

	}

}
