package pageextesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YelpHomePage_PF {
	WebDriver driver;
	//Variable declaration
	@FindBy(id="find_desc")
	WebElement searchname;
	@FindBy(xpath="//*[@id=\"header-search-submit\"]")
	WebElement btnsearch;
	@FindBy(linkText="Sign Up")
	WebElement lnkcreateacc;
	
	
	
	
	//Variable initialization
	public YelpHomePage_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	        //method implementation
			public void search(String product)
			{
				searchname.sendKeys(product);
				btnsearch.click();
			}
			
			public void navigateToSignup()
			{
				lnkcreateacc.click();
			}
			
}
