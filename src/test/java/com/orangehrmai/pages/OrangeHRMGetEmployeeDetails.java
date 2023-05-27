package com.orangehrmai.pages;

import com.orangehrm.objectrepository.ObjectRepository;
import com.orangehrmai.utilities.ExcelWrite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OrangeHRMGetEmployeeDetails {
    public static WebDriver driver;
    public void OrangeHRMGetEmployeeDetails(WebDriver driver){
        this.driver=driver;
    }

    String dataFilePath = ".\\RetrivedData\\EmployeeJobDetails.xlsx";
    String sheetName = "Sheet1";
    String colNameOne = "employeeId";
    String colNameTwo = "firstName";
    String colNameThree = "lastName";
    String colNameFour = "jobTitle";
    @FindBy(xpath= ObjectRepository.baseXpath+"32"+ObjectRepository.employeeIdBaseXpath)
    @CacheLookup
    WebElement employeeId;
    @FindBy(xpath= ObjectRepository.baseXpath+"32"+ObjectRepository.employeeLastNameBaseXpath)
    @CacheLookup
    WebElement employeeLastName;
    @FindBy(xpath= ObjectRepository.baseXpath+"32"+ObjectRepository.employeeFirstNameBaseXpath)
    @CacheLookup
    WebElement employeeFirstName;
    @FindBy(xpath= ObjectRepository.baseXpath+"32"+ObjectRepository.employeeJobTitleBaseXpath)
    @CacheLookup
    WebElement employeeJobTitle;



    public void getTableDetails() throws Exception {
        String employeeIdValue=employeeId.getText();
        System.out.println(employeeIdValue);
        Reporter.log(employeeIdValue);
        String employeeLastNameValue=employeeLastName.getText();
        System.out.println(employeeLastNameValue);
        Reporter.log(employeeLastNameValue);
        String employeeFirstNameValue=employeeFirstName.getText();
        System.out.println(employeeFirstNameValue);
        Reporter.log(employeeFirstNameValue);
        String employeeJobTitleValue=employeeJobTitle.getText();
        System.out.println(employeeJobTitleValue);
        Reporter.log(employeeJobTitleValue);
        //Setting Data to excel
        ExcelWrite set = new ExcelWrite(dataFilePath);
        set.setCellData(sheetName, colNameOne, 1, employeeIdValue);
        set.setCellData(sheetName, colNameTwo, 1, employeeFirstNameValue);
        set.setCellData(sheetName, colNameThree, 1, employeeLastNameValue);
        set.setCellData(sheetName, colNameFour, 1, employeeJobTitleValue);
    }
  }
