package com.qa.pages.crm.accounts;

import com.qa.base.Page;

public class AccountsPage extends Page {

	public CreateAccountPage ClickOnCreateAccounts() {

		// Click on create account button
		click("createAccount_XPATH");

		return new CreateAccountPage();
	}

	public void clickOnImportBtn() {

		// Click on Import button
		click("importButton_XPATH");

	}

	public void ClickOnimportAccounts() {

		// Click on Import account
		click("importAccount_XPATH");

	}

}
