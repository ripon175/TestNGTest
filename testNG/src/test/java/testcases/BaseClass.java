package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    XSSFWorkbook wbook;
    XSSFSheet sheet;
    
    public static ExtentReports report;
    public static ExtentTest test;
    
    
    @BeforeMethod
    public void SetUp(){
    //launch application
   	 //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
   	 //driver=new FirefoxDriver();
   	 
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
   	 
   	 driver.get("https://www.simplilearn.com/");
   	 driver.manage().window().maximize();
   	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void QuitBrowser(){
    driver.quit();
    }

    

    
    @BeforeTest
    public void testData() throws IOException{
    FileInputStream fis=new FileInputStream("TestData.xlsx");
    wbook = new XSSFWorkbook(fis);
    sheet = wbook.getSheet("Sheet1");
    
    report = new ExtentReports("ExtentReport.html");
    
    }

    @AfterTest
    public void dataclose() throws IOException{
    wbook.close();
    report.flush();
    report.close();
    }
    }
