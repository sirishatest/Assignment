package or;

import org.openqa.selenium.By;

public class ProductsPage {
	
	public static By lnkProduct = By.xpath("//div[@class='product-list grid']/div//img");
	public static By headerProductName = By.xpath("//h1[@itemprop='name']");
	public static By btnAddtoCart = By.xpath("//input[@value='Add to Cart']");
	public static By btnViewCart = By.xpath("//button[contains(.,'View Cart')]");
	public static By txtQty = By.id("quantity_1");
	public static By lnkUpdate = By.linkText("Update");
	
	
	
	
}
