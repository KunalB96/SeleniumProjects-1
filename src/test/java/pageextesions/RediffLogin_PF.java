package pageextesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLogin_PF {
		WebDriver driver;
		//Variable declaration
		@FindBy(id="login1")
		WebElement txtUsername;
		@FindBy(id="password")
		WebElement txtpassword;
		@FindBy(name="proceed")
		WebElement btnsigin;
		@FindBy(id="div_login_error")
		WebElement lblerror;
		@FindBy(linkText="Create a new account")
		WebElement lnkcreateacc;
		@FindBy(linkText="Forgot Password?")
		WebElement lnkforgotpassword;
		//Variable initialization
		public RediffLogin_PF(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//method implementation
		public void login(String username, String password)
		{
			txtUsername.sendKeys(username);
			txtpassword.sendKeys(password);
			btnsigin.click();
		}
		
		public String getError()
		{
			return lblerror.getText();
		}
		public void clearData()
		{
			txtUsername.clear();
			txtpassword.clear();
		}
		
		public void navigateToReg()
		{
			lnkcreateacc.click();
		}
		
		public void resetPassword()
		{
			lnkforgotpassword.click();
		}
		
}
