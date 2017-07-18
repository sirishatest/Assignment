package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import util.ConfiguratorSupport;
import util.Xls_Reader;

public class StartBrowser {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Xls_Reader reader;
	public static WebDriverWait wait;

	public static ConfiguratorSupport config = new ConfiguratorSupport("config.properties");
	@BeforeTest
	public void report()
	{
		report = new ExtentReports("Reports/ExtentReport.html");
	}
	@BeforeClass
	public void beforeClass() throws Throwable {
		//if(config.getProperty("browser").equalsIgnoreCase("chrome"))
		
		//If we run from Jenkins it will execute this condition other wise see below else block
		if(System.getProperty("BROWSER") != null)
		{
			switch (System.getProperty("BROWSER").toLowerCase()) {

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Jars\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Jars\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("No browser selected");
				break;
			}

		}
		//These details read from config.properties file
		else
		{
			switch (config.getProperty("BROWSER").toLowerCase()) {

			case "chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Jars\\chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "C:\\Jars\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("No browser selected");
				break;
			}

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		reader = new Xls_Reader("TestData/Data.xlsx");
		wait = new WebDriverWait(driver, 10);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
