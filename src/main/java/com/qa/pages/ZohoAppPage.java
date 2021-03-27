package com.qa.pages;

import com.qa.base.Page;
import com.qa.pages.crm.CrmHomePage;

public class ZohoAppPage extends Page {

	public void books() {

		// Click on books
		click("books_XPATH");

	}

	public void calendar() {

		// Click on calendar
		click("calendar_XPATH");

	}

	public void campaigns() {

		// Click on campaigns
		click("campaigns_XPATH");

	}

	public void cliq() {

		// Click on cliq
		click("cliq_XPATH");

	}

	public void connect() {

		// Click on connect
		click("connect_XPATH");

	}

	public CrmHomePage crm() {

		// Click on crm
		click("crm_XPATH");

		return new CrmHomePage();

	}

	public void desk() {

		// Click on desk
		click("desk_XPATH");

	}

	public void inVoice() {

		// Click on inVoice
		click("inVoice_XPATH");

	}

	public void mail() {

		// Click on mail
		click("mail_XPATH");
	}

	public void meeting() {

		// Click on meeting
		click("meeting_XPATH");
	}

	public void sheet() {

		// Click on sheet
		click("sheet_XPATH");
	}

	public void show() {

		// Click on show
		click("show_XPATH");
	}

	public void workDrive() {

		// Click on workDrive
		click("workDrive_XPATH");
	}

	public void writer() {

		// Click on writer
		click("writer_XPATH");

	}

}
