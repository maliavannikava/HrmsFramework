package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.ConfigsReader;


public class LoginTest extends PageInitializer{
	
	
	@Test
	public void validAdminLogin() {
		
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		//DashBoardPageElements db=new DashBoardPageElements();
		String expectedUser="Welcome Admin";
		String actualUser=dashboard.welcome.getText();
		AssertJUnit.assertEquals(actualUser, expectedUser, "Admin is NOT logged in");
		AssertJUnit.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	
	public void invalidAdminLogin() {
		sendText(login.username, ConfigsReader.getProperty("marga"));
		sendText(login.password, ConfigsReader.getProperty("mmmm"));
		String expectedText="Invalid credentials";
		String actualText=login.errorMsg.getText();
		AssertJUnit.assertEquals(actualText, expectedText, "Error message is not correct");
	}
	
	@Test (groups="regression")
	public void emptyUsername () {
		login.login("","sdfsdffdsf");
		String expectedText="Username cannot be empty";
		String actualText=login.errorMsg.getText();
		AssertJUnit.assertEquals(actualText,expectedText,"Error message is not correct");
	}
}
