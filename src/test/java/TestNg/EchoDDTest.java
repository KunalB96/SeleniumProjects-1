package TestNg;

import org.testng.annotations.Test;

import utility.WebBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class EchoDDTest {
	WebDriver driver;
	
  @Test(dataProvider = "getData")
  public void login(String uid, String pass) {
	  driver.findElement(By.id("txtCustomerID")).sendKeys(uid);
	  driver.findElement(By.id("txtPassword")).sendKeys(pass);
	  driver.findElement(By.id("Butsub")).click();
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.id("txtCustomerID")).clear();
	  driver.findElement(By.id("txtPassword")).clear();
  }


  @DataProvider
  public String[][] getData() {
   //1st 
	//  2nd
	  String [][] data = new String[3][2];
	  data[0][0] = "user001";
	  data[0][1] = "user001";
	  data[1][0] = "user002";
	  data[1][1] = "user002";
	  data[2][0] = "user003";
	  data[2][1] = "user003";
	  return data;
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
