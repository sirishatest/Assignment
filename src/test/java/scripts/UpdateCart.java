package scripts;

import org.testng.annotations.Test;

import reuse.BusinessFunctions;

public class UpdateCart extends BusinessFunctions{
	
  @Test
  public void testCart() throws InterruptedException {
	  logger = report.startTest("Update Cart");
	  signIn();
	  updateCart(); 
	  signOut();
	  report.endTest(logger);
	  report.flush();
	  
  }
}
