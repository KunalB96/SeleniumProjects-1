package pageextesions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffReg_PF {
	WebDriver driver;
	@FindBy(css="input[name^='name']")
	WebElement txtfullname;
	@FindBy(css="input[name^='login']")
	WebElement txtemail;
	@FindBy(css="input[name^='gender']")
	List<WebElement> rbgender;
	
	public RediffReg_PF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register(String name, String email, String gender)
	{
		txtfullname.sendKeys(name);
		txtemail.sendKeys(email);
		for(WebElement rb : rbgender)
		{
			if(rb.getAttribute("value").equals(gender))
			{
				rb.click();
				break;
				
			}
					
		}
		
		
	}
  
}
