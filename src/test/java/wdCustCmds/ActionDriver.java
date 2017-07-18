package wdCustCmds;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import config.StartBrowser;

public class ActionDriver extends StartBrowser{
	/**
	 * This is to navigate to a specific URL
	 * @param url --Application URl
	 */
	public static void launchApplication(String url)
	{
		try {
			driver.get(url);
			//driver.navigate().to(url);
			logger.log(LogStatus.PASS, "Launched applciation successfully : "+url);
		} catch (Exception e) {
			// TODO: handle exception
			logger.log(LogStatus.FAIL, "Unable to launch URL  : "+url);
		}

	}
	/**
	 * Used to perform type action in text box
	 * @param locator --Get IT from OR
	 * @param text  ---your test data
	 */
	public static void type(By locator, String text, String elementName)
	{
		try {
			driver.findElement(locator).sendKeys(text);
			logger.log(LogStatus.PASS, "Able to Type "+text+" in : "+elementName );
		} catch (Exception e) {
			logger.log(LogStatus.PASS, "UnAble to Type "+text+" in : "+elementName +  logger.addScreenCapture(screenshot(driver)));
		}

	}
	/**
	 * perform click operation on button, checkbox, Rb and links
	 * @param locator --get it from OR
	 */
	public static void click(By locator, String elementName)
	{
		try {
			driver.findElement(locator).click();
			logger.log(LogStatus.PASS, "Able to Click on  : "+elementName );
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable  to Click on  : "+elementName + logger.addScreenCapture(screenshot(driver)));
		}

	}
	
	public static void waitEleClickable(By locator)
	{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			
		} catch (Exception e) {
			
		}

	}

	public static boolean isElePresent(By locator)
	{
		try {
			driver.findElement(locator);
			return true;

		} catch (Exception e) {
			System.out.println(locator + " is not visible");
			return false;
		}
	}
	/**
	 * select a vale from DD using visible text
	 * @param locator --get it from OR
	 * @param text --value from DD
	 */
	public static void selectValueFromDD(By locator, String text, String elementName)
	{
		try {
			WebElement dd=driver.findElement(locator);
			Select s = new Select(dd);
			s.selectByVisibleText(text);
			logger.log(LogStatus.PASS, "Able to Select " +text+" From DD  : "+elementName );
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable  to Select " +text+"from DD : "+elementName + logger.addScreenCapture(screenshot(driver)));
		}
		
	}
	/**
	 * Mouse hover on element
	 * @param locator
	 * @param elementName
	 */
	public static void mouseHover(By locator,String elementName)
	{
		try {
			Actions a = new Actions(driver);
			WebElement we=driver.findElement(locator);
			a.moveToElement(we).perform();
			logger.log(LogStatus.PASS, "Able to MouseHover on: "+elementName );
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Able to MouseHover on: " +elementName + logger.addScreenCapture(screenshot(driver)));
		}
		
	}

	public static String screenshot(WebDriver driver)
	{
		String src_path="/SShot/";
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(src_path+uuid+".jpeg"));
			// TODO: handle exception
		}
		catch(Exception e)
		{
			System.out.println("Unable tp capture screenshot");
		}
		return src_path+uuid+".jpeg";
	}
}
