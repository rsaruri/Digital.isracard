package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy (id = "otpLoginId_ID")
	public WebElement idInput;
	
	@FindBy (name="otpLoginLastDigits_ID")
	public WebElement digitsInput;
	
	@FindBy (id="otpLoginPwd")
	public WebElement passInput;
	
	@FindBy (xpath = "//*[@ng-bind='vm.epiData.LoginButtonText']")
	public WebElement submitBtn;
	
	/**
	 * c-tor login page
	 * @param driver
	 */
	public LoginPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Enter ID number to id field
	 * @param id
	 * @return
	 */
	public LoginPage withId (String id) {
		idInput.sendKeys(id);
		return this;
	}
	
	/**
	 * Enter last 6 digits of credit card to last digits field 
	 * @param digits
	 * @return
	 */
	public LoginPage withLastDigits (String digits) {
		digitsInput.sendKeys(digits);
		return this;
	}

	/**
	 * Enter password to password field  
	 * @param pass
	 * @return
	 */
	public LoginPage withPassword (String pass) {
		passInput.sendKeys(pass);
		return this;
	}
	
	
	/**
	 * submit - go to transaction page
	 */
	public TransactionPage submit() {
		submitBtn.click();
		return new TransactionPage(driver);
	}
	
	
}
