package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.ConfigsReader;


public class LoginTest extends PageInitializer{
	
	
	@Test(groups="smoke")
	public void validAdminLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		// DashboardPageElements dashboard = new DashboardPageElements();
		String expectedUser = "Welcome Admin";
		String actualUser = dashboard.welcome.getText();
		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}

	@Test
	public void invalidPasswordLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "uiuguig");
		click(login.loginBtn);

		String expected = "Invalid credential";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}

	@Test
	public void emptyUsernameLogin() {
		// LoginPageElements login = new LoginPageElements();
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		String expected = "Username cannot be empty";

		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
	}
	
	@Test 
	public void timeStamp() {
		Date d=new Date();
		System.out.println(d.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		System.out.println(sdf.format(d.getTime()));
		
		
	}
}
