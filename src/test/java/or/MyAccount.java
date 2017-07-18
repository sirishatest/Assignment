package or;

import org.openqa.selenium.By;

public class MyAccount {
	
	public static By btnMyAccount = By.id("myaccount-t123");
	public static By lnkSignOut = By.xpath("//input[@value='Sign Out']");
	public static By lnkAddressBook = By.linkText("Address Book");
	//Address book
	public static By btnAddAnAddress = By.xpath("//button[@class='submit costco-button']");
	public static By ddAddressType = By.id("addressType");
	public static By txtFirstName = By.id("_firstName");
	public static By txtLastName = By.id("_lastName");
	public static By ddCountry = By.id("_country");
	public static By txtCity = By.id("_city");
	public static By ddState = By.id("_state");
	public static By txtZip = By.id("_zipCode");
	public static By txtPhone = By.id("_phone1");
	public static By btnCancel = By.xpath("//span[text()='Cancel']");
	
	
}
