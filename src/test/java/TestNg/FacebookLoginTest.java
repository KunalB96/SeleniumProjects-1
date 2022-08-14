package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class FacebookLoginTest {
	WebDriver driver;

	
  @Test(dataProvider = "getData")
  public void login(String uid, String pass) {
	  driver.findElement(By.id("email")).sendKeys(uid);
	  driver.findElement(By.id("pass")).sendKeys(pass);
	  driver.findElement(By.name("login")).click();
  }
  
  @AfterMethod
  public void afterMethod() {
//	  driver.findElement(By.id("email")).clear();
//	  driver.findElement(By.id("pass")).clear();
	  driver.navigate().back();
	  
  }


  @DataProvider
  public String[][] getData() {
	  String [][] data = new String[1][2];
	  data[0][0] = "kunalbhavsar96@gmail.com";
	  data[0][1] = "user001";
	  return data;
   
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
