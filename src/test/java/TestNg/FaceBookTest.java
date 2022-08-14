package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FaceBookTest {
	WebDriver driver;
	
 @Parameters({"uid","pass"})
  @Test
  public void login(String uid, String pass) {
	  driver.findElement(By.id("email")).sendKeys(uid);
	  driver.findElement(By.id("pass")).sendKeys(pass);
	  driver.findElement(By.name("login")).click();
	//  assertTrue(driver.getTitle().contains(uid),"Title does not match");
  }
	
	
  @BeforeClass
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.facebook.com/");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
