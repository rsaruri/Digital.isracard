package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdatePasswordPage extends BasePage{
	
	//Element of my account button 
	@FindBy (xpath = "//*[@title='החשבון שלי']")
	public WebElement accountBtn;
	
	//Element of update password button
	@FindBy (linkText = "עדכון סיסמא")
	public WebElement updatePassBtn;
	
	//Element of input text - old password
	@FindBy (name="oldPassword")
	public WebElement oldPassInput;
	
	//Element of input text - new password
	@FindBy (name="newPassword")
	public WebElement newPassInput;
	
	//Element of input text - new password again
	@FindBy (name="repeatNewPassword")
	public WebElement repeatNewPassInput;
	
	//Element of submit button
	@FindBy (css="button[type='submit']")
	public WebElement submitBtn;
	
	//Element of form that shown after success
	@FindBy (css="form[name='successPasswordForm']")
	public WebElement successForm;
	
	/**
	 * c-tor UpdatePasswordPage
	 * @param driver
	 */
	public UpdatePasswordPage (WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Enter old password to old password field
	 * @param oldPass
	 */
	public UpdatePasswordPage withOldPass (String oldPass) {
		oldPassInput.sendKeys(oldPass);
		return this;  
	}
	
	/**
	 * Enter new password to new password 1 field
	 * @param newPass
	 */
	public UpdatePasswordPage withNewPass (String newPass) {
		newPassInput.sendKeys(newPass);
		return this;
	}
	
	/**
	 * Enter new password again to new password 2 field
	 * @param newPass
	 */
	public UpdatePasswordPage withRepeatNewPass (String repeatNewPass) {
		repeatNewPassInput.sendKeys(repeatNewPass);
		return this;
	}
	
	
}
