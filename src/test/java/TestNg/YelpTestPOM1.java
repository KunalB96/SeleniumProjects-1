package TestNg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageextesions.YelpHomePage_PF;
import pageextesions.YelpSignUp1_PF;

import utility.WebBrowser;

public class YelpTestPOM1 {
	WebDriver driver;
	YelpHomePage_PF search;
	YelpSignUp1_PF sign;
	
	
  @Test(priority=0)
  public void search() {
	  search.search("Restaurants");
	  driver.navigate().back();
  }
  
  @Test(priority=1)
  public void navigateToSignup() {
	  search.navigateToSignup();
	 assertEquals(driver.getTitle(),"Sign Up - Yelp");
	}
  
  
  @Test(priority=2)
  public void signup() {
	  sign.signup("Kunal", "Bhavsar", "kunalbhavsar96", "KB123", "411062", "May", "19", "1996");
	  System.out.println("Signup successful");
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.yelp.com/");
	  search= new YelpHomePage_PF(driver);
	  sign = new YelpSignUp1_PF(driver);
  }

  @AfterClass
  public void afterClass() {
//	  driver.close();
  }
}
