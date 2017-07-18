package scripts;

import org.testng.annotations.Test;

import reuse.BusinessFunctions;

public class CreateAccount extends BusinessFunctions{
	
  @Test
  public void testCreateAccount() throws InterruptedException {
	  logger = report.startTest("Create Account");
	  createAccount();
	  report.endTest(logger);
	  report.flush();
	  
  }
}
