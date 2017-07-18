package scripts;

import org.testng.annotations.Test;

import reuse.BusinessFunctions;

public class UpdateAccount extends BusinessFunctions{
	
  @Test
  public void testUpdateAccount() throws InterruptedException {
	  logger = report.startTest("Update Account");
	  signIn();
	  updateAccount();
	  signOut();
	  report.endTest(logger);
	  report.flush();
	  
  }
}
