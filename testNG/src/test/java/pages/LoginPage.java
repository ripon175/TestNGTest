package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
    WebDriver driver= BaseClass.driver;
    
    ExtentTest test = BaseClass.test;

    @FindBy(linkText="Log in")
    WebElement LoginLink;
    
    @FindBy(name="user_login")
    WebElement UserName;
    
    @FindBy(id="password")
    WebElement Password;
    
    @FindBy(className="rememberMe")
    WebElement RememberMe;
    
    @FindBy(name="btn_login")
    WebElement LoginBtn;
    
    public LoginPage() {
   	 PageFactory.initElements(driver, this);
    }
    
    public void LoginFunction(String UserNameVal, String PasswordVal) throws InterruptedException{

    Thread.sleep(5000);
    
    LoginLink.click();
    test.log(LogStatus.PASS, "Login Link clicked");
    UserName.sendKeys(UserNameVal);
    test.log(LogStatus.PASS, "User name entered");    
    Password.sendKeys(PasswordVal);
    test.log(LogStatus.PASS, "Password entered");
    RememberMe.click();
    test.log(LogStatus.PASS, "Selected Remember Me");
    LoginBtn.click();
    test.log(LogStatus.PASS, "Clicked on Sign In button");
    
    
    }
    
    //public void loginCheck() {
   	 //WebElement UserName=driver.findElement(By.name("user_login"));
   	 //Assert.assertTrue(UserName.isDisplayed());
    //}
    
    //WebElement LoginLink = driver.findElement(By.linkText("Log in"));
    //WebElement UserName= driver.findElement(By.name("user_login"));
   	 //WebElement Password= driver.findElement(By.id("password"));
   	 //WebElement RememberMe = driver.findElement(By.className("rememberMe"));
   	 //WebElement LoginBtn = driver.findElement(By.name("btn_login"));
}
