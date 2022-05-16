package tests;

//import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;


public class TestBase extends AbstractTestNGCucumberTests{
	public static WebDriver driver;
	
	
	@BeforeSuite
	@Parameters({"browser"})//gai mn <parameter name="browser" value="chrome"></parameter> fe testng.xml
	public void startDriver(@Optional("chrome") String browserName) {//@optional 3lshan lw h3ml Run mn hna msh mnl testng.xml yshof el broswername msh ydrb error
		if (browserName.equalsIgnoreCase("chrome")) {//equalsIgnoreCase-->msh hikon case sensetive 3lshan fe testng.xml lw 7d d5lha CHrome msln ysht8l 3ady
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Drivers/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/Drivers/msedgedriver.exe");
			driver= new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome-headless")){
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@AfterSuite
	public void stopDriver() {
	driver.quit();	
	}
	
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failure");
			System.out.println("Taking screenshot......");
			Helper.captureScreenshot(driver, result.getName());
		}		
	}
}
