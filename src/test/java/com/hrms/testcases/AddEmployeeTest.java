package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.hrms.testbase.PageInitializer;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends PageInitializer{

	@Test
	public void addEmployeePage() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(7);	
	}
}
