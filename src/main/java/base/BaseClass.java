package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
	
	public RemoteWebDriver driver;
	public String excelFileName;
	
	@BeforeSuite
	public void startReport() {
		
	}
	
	@BeforeClass
	public void testcaseDetails() {
		
	}
	
	public void screenshotSetup() {
		
	}
	
	@DataProvider
	public String[][] alertMessages() throws IOException{
	
		return ReadExcel.getData(excelFileName);
	}
	
	@Parameters ({"browserName","URL"})
	@BeforeMethod
	public void browserSetup(String browserName, String url) {
		
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}else {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
		

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@AfterSuite
	public void stopReport() {
		
	}
	
	
	
	

}
