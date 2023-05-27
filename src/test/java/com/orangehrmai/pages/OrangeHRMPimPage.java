package com.orangehrmai.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.orangehrm.objectrepository.ObjectRepository;

public class OrangeHRMPimPage {

	public static WebDriver driver;
	public void OrangeHRMPimPage(WebDriver driver){
		this.driver=driver;
	}
	@FindBy(xpath=ObjectRepository.pimButtonXpath) 
	@CacheLookup
	WebElement pimButton;
	
	@FindBy(xpath=ObjectRepository.pimHeadingXpath) 
	@CacheLookup
	WebElement pimHeading;
	
	@FindBy(xpath=ObjectRepository.addEmployeeTabXpath)
	@CacheLookup
	WebElement addEmployeeTab;

	@FindBy(xpath=ObjectRepository.addEmployeeFirstNameXpath) 
	@CacheLookup
	WebElement addEmployeeFirstName;
	
	@FindBy(xpath=ObjectRepository.addEmployeeLastNameXpath)
	@CacheLookup
	WebElement addEmployeeLastName;
	
	@FindBy(xpath=ObjectRepository.addEmployeeIdXpath)
	@CacheLookup
	WebElement addEmployeeId;
	
	@FindBy(xpath=ObjectRepository.createLoginDetailsSwitchButtonXpath)
	@CacheLookup
	WebElement addEmployeeCreateLoginDetails;
	
	@FindBy(xpath=ObjectRepository.addEmployeeUsernameXpath)
	@CacheLookup
	WebElement addEmployeeUsername;
	
	@FindBy(xpath=ObjectRepository.addEmployeePasswordXpath)
	@CacheLookup
	WebElement addEmployeePassword;
	
	@FindBy(xpath=ObjectRepository.addEmployeeConfirmPasswordXpath)
	@CacheLookup
	WebElement addEmployeeConfirmPassword;
	
	@FindBy(xpath=ObjectRepository.addEmployeeEnabledRadioButton)
	@CacheLookup
	WebElement addEmployeeEnabledRadioButton;
	
	@FindBy(xpath=ObjectRepository.addEmployeeSaveButtonXpath)
	@CacheLookup
	WebElement addEmployeeSaveButton;
	
	@FindBy(xpath=ObjectRepository.addedEmployeeProfileNameXpath)
	@CacheLookup
	WebElement addedEmployeeProfileName;

	@FindBy(xpath=ObjectRepository.reportsButtonXpath)
	@CacheLookup
	WebElement reportsButton;

	@FindBy(xpath=ObjectRepository.reportsTitleXpath)
	@CacheLookup
	WebElement reportsPageTitle;

	@FindBy(xpath = ObjectRepository.reportEmployeeJobDetailsTableButtonXpath)
	@CacheLookup
	WebElement reportEmployeeJobDetailsTableButton;
	
	
	
	
	
	public void pimTitleValidation() {
		pimButton.click();
		System.out.println("PIM button clicked");
		Reporter.log("PIM button clicked");
		String actualTitle = pimHeading.getText();
		String expectedTitle = "PIM";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PIM heading is displayed");
			Reporter.log("PIM heading is displayed");
		}else {
			System.out.println("PIM heading is not displayed");
			Reporter.log("PIM heading is not displayed");
		}
	}
	
	public void addEmployeeNameAndId(String firstName, String lastName, String employeeId) throws InterruptedException {
		addEmployeeTab.click();
		addEmployeeFirstName.sendKeys(firstName);
		addEmployeeLastName.sendKeys(lastName);
		addEmployeeId.click();
		addEmployeeId.clear();
		addEmployeeId.sendKeys(employeeId);
		
	}
	
	public void addEmployeeCredentials(String userName, String password) throws InterruptedException {
		addEmployeeCreateLoginDetails.click();
		addEmployeeUsername.sendKeys(userName);
		if (addEmployeeEnabledRadioButton.isSelected()) {
			System.out.println("Enabled status is already selected");
		}else {
			System.out.println("Enabled status is not selected on startup"); 
			addEmployeeEnabledRadioButton.click();
		}
		addEmployeePassword.sendKeys(password);
		addEmployeeConfirmPassword.sendKeys(password);
		addEmployeeSaveButton.click();		
		System.out.println("New Employee Added Successfully");	
		Reporter.log("New Employee Added Successfully");
	}
	
	public void addedEmployeeProfileNameValidation(String employeeName) throws InterruptedException{

		//Thread.sleep(5000);
		String actualName= addedEmployeeProfileName.getText();
		Thread.sleep(5000);
		String expectedName = employeeName;
		if(actualName.equals(expectedName)) {
			System.out.println("New Employee name is displayed");
			Reporter.log("New Employee name is displayed");
		}else {
			System.out.println("New Employee name is not displayed");
			Reporter.log("New Employee name is not displayed");
		}
		
	}

	public void clickReports(){
		reportsButton.click();
		System.out.println("Reports button is clicked");
		Reporter.log("Reports button is clicked");
		String actualTitle=reportsPageTitle.getText();
		String expectedTitle="Employee Reports";
		if(actualTitle.equals(expectedTitle)){
			System.out.println("Employee reports page is displayed");
			Reporter.log("Employee reports page is displayed");
		}else {
			System.out.println("Employee reports page is not displayed");
			Reporter.log("Employee reports page is not displayed");
		}

	}

	public void clickEmployeeJobDetailsReports(){
		reportEmployeeJobDetailsTableButton.click();
	}
}
