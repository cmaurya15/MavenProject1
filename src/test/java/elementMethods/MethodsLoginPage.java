package elementMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elementDefinition.ElementsLoginPage;
import utilities.FileOperations;

public class MethodsLoginPage 
{
	WebDriver driver;
	ElementsLoginPage objElementsLoginPage;
	
	
	public MethodsLoginPage(WebDriver driver) 
	{
		this.driver = driver;
		objElementsLoginPage= PageFactory.initElements(driver, ElementsLoginPage.class);
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(objElementsLoginPage.Textbox_UserName));
		
	}
	
	public void Method_EnterUserName() throws Exception 
	{	FileOperations objFileOperations=new FileOperations();
		objElementsLoginPage.Textbox_UserName.sendKeys(objFileOperations.ReadPropertyFile("username"));
		
		//objElementsLoginPage.Textbox_UserName.sendKeys("Admin");
		
	}
	
	public void Method_EnterPassword() throws Exception 
	{	
		FileOperations objFileOperations=new FileOperations();
		objElementsLoginPage.Textbox_Password.sendKeys(objFileOperations.ReadPropertyFile("password"));
		
		//objElementsLoginPage.Textbox_Password.sendKeys("admin123");
		
	}
	public void Method_ClickLogin() 
	{	
		objElementsLoginPage.Button_Login.click();
		
	}
	
	public String Method_GetLoginName() 
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(objElementsLoginPage.Text_LoggedInUserName));
		
		String loginName= objElementsLoginPage.Text_LoggedInUserName.getText();
		return loginName;
		
	}

}
