package com.orangehrm.objectrepository;

/*
 * All the locators values are mentioned here
 * 
 * Naming Rule:
 * For link and partial link text locator => add Link as suffix 
 * 
 * Rest of the locators use relative xpath tricks
 * 
 * 
 */

public class ObjectRepository {	

	// Object Repository of OrangeHRM Web Pages

	// Login Page OR
	public static final String loginPageTitleXpath="//h5[text()='Login']";
	public static final String usernameXpath= "//input[@name='username']";
	public static final String passwordXpath= "//input[@name='password']";
	public static final String loginButtonXpath= "//button[text()=' Login ']";
	
	//Home Page OR 
	public static final String homePageHeadingXpath="//h6[text()='Dashboard']";
	public static final String profileTabDropDownXpath="//p[@class='oxd-userdropdown-name']";
	public static final String logoutXpath="//a[normalize-space()='Logout']";
	
	//PIM Page OR
	public static final String pimButtonXpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']";
	public static final String pimHeadingXpath="//h6[text()='PIM']";
	public static final String addEmployeeTabXpath="//a[normalize-space()='Add Employee']";
	public static final String addEmployeeFirstNameXpath="//input[@placeholder='First Name']";
	public static final String addEmployeeLastNameXpath="//input[@placeholder='Last Name']";
	public static final String addEmployeeIdXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input";
	public static final String createLoginDetailsSwitchButtonXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span";
	public static final String addEmployeeUsernameXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input";
	public static final String addEmployeePasswordXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input";
    public static final String addEmployeeConfirmPasswordXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input";
    public static final String addEmployeeSaveButtonXpath="//button[text()=' Save ']";
	public static final String addEmployeeEnabledRadioButton="//label[normalize-space()='Enabled']";
	public static final String addedEmployeeProfileNameXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6";

	//Employee Login Myinfo Page OR
	public static final String myInfoTabXpath="//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span";
	public static final String myInfoPersonalDetailsXpath="//*[@id='app']/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[1]/a";

}