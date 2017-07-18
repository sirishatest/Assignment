package reuse;

import com.relevantcodes.extentreports.LogStatus;

import or.HomePage;
import or.LoginPage;
import or.MyAccount;
import or.ProductsPage;
import wdCustCmds.ActionDriver;

public class BusinessFunctions extends ActionDriver{

	/*
	 * this is reusable method for Creating account 
	 */
	public void createAccount() throws InterruptedException
	{
		launchApplication("https://www.costco.com");
		if(isElePresent(HomePage.btnAccount))
		{
			click(HomePage.btnAccount, "Account Button");	
		}
		else
		{
			click(HomePage.btnSignIn, "Account Button");
		}

		type(LoginPage.txtEmail, reader.getCellData("CA", "Email", 2), "Email Address field");
		type(LoginPage.txtPassword, reader.getCellData("CA", "Password", 2), "Password field");
		type(LoginPage.txtCPassword, reader.getCellData("CA", "CPassword", 2), "CPassword field");
		type(LoginPage.txtMemberNumber, reader.getCellData("CA", "MemberNumber", 2), "MemberNumber field");
		click(LoginPage.btnRegister, "Register Button");

	}

	/*
	 * this is reusable method for SignIn
	 */
	public void signIn() throws InterruptedException
	{
		launchApplication("https://www.costco.com");
		if(isElePresent(HomePage.btnAccount))
		{
			click(HomePage.btnAccount, "Account Button");	
		}
		else
		{
			click(HomePage.btnSignIn, "Account Button");
		}

		type(LoginPage.txtLEmail, reader.getCellData("CA", "Email", 2), "Email Address field");
		type(LoginPage.txtLPassword, reader.getCellData("CA", "Password", 2), "Password field");
		click(LoginPage.btnSignIn, "Signin Button");

	}

	/*
	 * this is reusable method for SignOut
	 */
	public void signOut() throws InterruptedException
	{
		mouseHover(MyAccount.btnMyAccount, "My Account");
		click(MyAccount.lnkSignOut, "Sign Out link");

	}
	
	/*
	 * this is reusable method for product search
	 */
	public void searchProduct() throws InterruptedException
	{
		type(HomePage.txtSearch, "Mobiles", "Search box ");
		click(HomePage.btnSearch, "Search Button");
		click(ProductsPage.lnkProduct, "First Product");
		click(ProductsPage.btnAddtoCart, "Add to Cart Button");
		waitEleClickable(ProductsPage.btnViewCart);
		click(ProductsPage.btnViewCart, "View Cart Button");
		Thread.sleep(2000);
		/*driver.findElement(ProductsPage.txtQty).clear();
		type(ProductsPage.txtQty, "0", "Quantity field");
		click(ProductsPage.lnkUpdate, "Update Link");*/

	}
	
	/*
	 * this is reusable method for Update Cart
	 */
	public void updateCart() throws InterruptedException
	{
		click(HomePage.btnCart, "Cart button");
		if(isElePresent(ProductsPage.txtQty))
		{
			driver.findElement(ProductsPage.txtQty).clear();
			type(ProductsPage.txtQty, "0", "Quantity field");
			click(ProductsPage.lnkUpdate, "Update Link");
		}
		
		else
		{
			logger.log(LogStatus.PASS, "Cart is Empty" );
			System.out.println("Shopping cart is empty");
		}

	}
	
	/*
	 * this is reusable method for update Account
	 */
	public void updateAccount() throws InterruptedException
	{
		click(MyAccount.lnkAddressBook, "Addressbook link");
		click(MyAccount.btnAddAnAddress, "Add Addressbook button");
		selectValueFromDD(MyAccount.ddAddressType, "Billing Address", "Address type Dropdown");
		type(MyAccount.txtFirstName, "Naga", "First Name");
		type(MyAccount.txtLastName, "Dasam", "Last Name");
		selectValueFromDD(MyAccount.ddCountry, "United States", "Country Dropdown");
		type(MyAccount.txtCity, "Albany", "City Name");
		selectValueFromDD(MyAccount.ddState, "New York", "State Dropdown");
		type(MyAccount.txtZip, "22012", "Zip Code");
		type(MyAccount.txtPhone, "1478529632", "Phone Number");
		click(MyAccount.btnCancel, "Cancel button");
		
		
	}


}
