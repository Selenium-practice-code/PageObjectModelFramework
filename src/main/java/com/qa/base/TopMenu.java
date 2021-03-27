package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.pages.crm.accounts.AccountsPage;

public class TopMenu {

	/*
	 * 
	 * 
	 * HomePage HASA TopMenu AccountSPage HASA TopMenu
	 * 
	 * 
	 */

	WebDriver driver;

	public TopMenu(WebDriver driver) {

		this.driver = driver;
	}

	public void home() {

	}

	public void leads() {

	}

	public void contacts() {

	}

	public AccountsPage accounts() {

		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();

		return new AccountsPage();

	}

	public void deals() {

	}

	public void activites() {

	}

	public void reports() {

	}

	public void analytics() {

	}

	public void signOut() {

	}
}
