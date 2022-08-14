package TestNg;

import org.testng.annotations.Test;

import pageextesions.RediffLogin_PF;
import pageextesions.RediffReg_PF;
import utility.WebBrowser;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RediffTestPOM {
	WebDriver driver;
	RediffLogin_PF login;
	RediffReg_PF reg;
	
  @Test(priority=0)
  public void validLogin() {
	  login.login("admin", "admin");
	  System.out.println("Login Successfully");
	  login.clearData();
  }
  
  @Test(priority=1)
  public void invalidLogin() {
	  login.login("guest", "guest");
	 String acterror = login.getError();
	 assertEquals(acterror,"div_login_error");
	
  }
  
  @Test(priority=2)
  public void navigateToReg() {
	  login.navigateToReg();
	 assertEquals(driver.getTitle(),"Rediffmail Free Unlimited Storage");
	
  }
  
  @Test(priority=3)
  public void register() {
	  reg.register("aaa", "aaa123", "f");
	  System.out.println("Registration successful");
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
	  login= new RediffLogin_PF(driver);
	  reg = new RediffReg_PF(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
