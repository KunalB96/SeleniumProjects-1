package pageextesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YelpSignUp_PF {
	WebDriver driver;
	@FindBy(id="first_name")
	WebElement txtfirstname;
	@FindBy(id="last_name")
	WebElement txtlastname;
	@FindBy(id="email")
	WebElement txtemail;
	@FindBy(id="password")
	WebElement txtpassword;
	@FindBy(id="zip")
	WebElement txtzip;
	@FindBy(name="birthdate_m")
	WebElement selectmonth;
	@FindBy(name="birthdate_d")
	WebElement selectday;
	@FindBy(name="birthdate_y")
	WebElement selectyear;
	
	public YelpSignUp_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void signup(String fname, String lname, String email, 
			String password, String zip, String month , String day, String year )
	{
		txtfirstname.sendKeys(fname);
		txtlastname.sendKeys(lname);
		txtemail.sendKeys(email);
		txtpassword.sendKeys(password);
		txtzip.sendKeys(zip);
		selectmonth.sendKeys(month);
		selectday.sendKeys(day);
		selectyear.sendKeys(year);
		
	}
	
}
