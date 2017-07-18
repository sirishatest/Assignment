package scripts;

import org.testng.annotations.Test;

import reuse.BusinessFunctions;

public class Cart extends BusinessFunctions{
	
  @Test
  public void testCart() throws InterruptedException {
	  logger = report.startTest("Add Product To Cart");
	  signIn();
	  searchProduct(); 
	  signOut();
	  report.endTest(logger);
	  report.flush();
	  
  }
}
