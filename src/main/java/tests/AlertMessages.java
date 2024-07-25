package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AlertTypes;

public class AlertMessages extends BaseClass{
	
	@BeforeTest
	public void setData() {
		excelFileName="AlertMessages";
	}
	
	@Test(dataProvider="alertMessages")
	public void checkalertMessages(String alertMsg1) throws InterruptedException {
		
		new AlertTypes(driver)
		.alert1(alertMsg1);
	}
}
