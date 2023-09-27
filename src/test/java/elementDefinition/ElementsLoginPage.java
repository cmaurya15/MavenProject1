package elementDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElementsLoginPage 
{
	
	@FindBy(how = How.NAME, using="username" )
	public WebElement Textbox_UserName;
	
	@FindBy(how = How.NAME, using = "password" )
	public WebElement Textbox_Password;
	
	@FindBy(how =How.CSS, using = ".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")
	public WebElement Button_Login;
	
	@FindBy(how=How.CLASS_NAME,using="oxd-userdropdown-name")
	public WebElement Text_LoggedInUserName;

}
