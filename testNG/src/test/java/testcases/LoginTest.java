package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPage;

public class LoginTest extends BaseClass{

    
    @Test
    public void LogiFailureTest() throws InterruptedException{

   	 test = report.startTest("LogiFailureTest");
   	 
   	 LoginPage login=new LoginPage();
   	 login.LoginFunction("test@gmail.com", "Raghu!299");
   	 test.log(LogStatus.PASS, "Entered Username and Password static data");
   	 WebElement ErrorMsg=driver.findElement(By.id("msg_box"));
   	 String ActualMsg=ErrorMsg.getText();
   	 System.out.println(ActualMsg);
   	 //Assert.assertEquals(ActualMsg, ExpMsg);
   	 test.log(LogStatus.PASS, "Login Failure Test executed");
   	 
   	 report.endTest(test);
   	 }

    


   	 @Test
   	 public void LoginSuccessTest() throws InterruptedException{
   		 test = report.startTest("LoginSuccessTest");
   		 LoginPage login1=new LoginPage();
   		 login1.LoginFunction("test@gmail.com", "Raghu1234");
   		 test.log(LogStatus.PASS, "Entered Username and Password static data");
   		 report.endTest(test);
   	 }
   	 
    
    
   	 @Test
   	 @Parameters({"UserVal","PassVal"})
   	 public void paramTest(String UserNameVal, String PasswordVal) throws InterruptedException {
   		 test = report.startTest("paramTest");
   		 LoginPage login1=new LoginPage();
   		 login1.LoginFunction(UserNameVal, PasswordVal);
   		 test.log(LogStatus.PASS, "Entered Username and Password from testng");
   		 //test.log(LogStatus.FAIL, "Data from TestNG FAILED");
   		 report.endTest(test);
   	 }
    
   	 
   	 
   	 @Test
   	 public void excelTestData() throws InterruptedException {
   		 test = report.startTest("excelTestData");
   		 String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
   		 String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
   		 LoginPage login1=new LoginPage();
   		 test.log(LogStatus.PASS, "Created object for LoginPage");
   		 login1.LoginFunction(UserNameVal, PasswordVal);
   		 test.log(LogStatus.PASS, "Entered Username and Password from Excel");
   		 report.endTest(test);
   	 }
   	 
}
