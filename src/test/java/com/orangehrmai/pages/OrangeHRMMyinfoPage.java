package com.orangehrmai.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class OrangeHRMMyinfoPage {
	
	@FindBy(xpath=ObjectRepository.addedEmployeeProfileNameXpath)
	@CacheLookup
	WebElement addedEmployeeProfileName;
	@FindBy(xpath=ObjectRepository.myInfoTabXpath)
	@CacheLookup
	WebElement employeeLoginMyinfoTab;
	@FindBy(xpath=ObjectRepository.myInfoPersonalDetailsXpath)
	@CacheLookup
	WebElement employeeLoginMyinfoPersonalDetailsTab;
	

	public void userLoginProfileNameValidation(String employeeName) {
		
		employeeLoginMyinfoTab.click();
		employeeLoginMyinfoPersonalDetailsTab.click();
		String actualName= addedEmployeeProfileName.getText();
		String expectedName = employeeName;
		if(actualName.equalsIgnoreCase(expectedName)) {
			System.out.println("Employee Name is :-"+actualName);
			Reporter.log("Employee Name is :-"+actualName);
		}else {
			System.out.println("Employee name is not displayed");
			Reporter.log("Employee name is not displayed");
		}
		
	}

}