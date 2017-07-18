package scripts;

import org.testng.annotations.Test;

import reuse.BusinessFunctions;

public class SignIn_Out extends BusinessFunctions{
	
  @Test
  public void testCreateAccount() throws InterruptedException {
	  logger = report.startTest("Sign In and SignOut");
	  signIn();
	  signOut();
	  report.endTest(logger);
	  report.flush();
	  
  }
}
