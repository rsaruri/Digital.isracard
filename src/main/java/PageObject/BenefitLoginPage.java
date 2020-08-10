package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BenefitLoginPage extends BasePage {
	
	@FindBy (id = "IdNumber")
	public WebElement benefitIdInput;
	
	@FindBy (id="CardNumberSuffix")
	public WebElement benefitDigitsInput;
	
	@FindBy (id = "loginFormBtn")
	public WebElement benefitSubmitBtn;
	
	/**
	 * c-tor benefit login page
	 * @param driver
	 */
	public BenefitLoginPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Enter ID number to id field
	 * @param id
	 * @return
	 */
	public BenefitLoginPage withId (String id) {
		benefitIdInput.sendKeys(id);
		return this;
	}
	
	/**
	 * Enter last 6 digits of credit card to last digits field 
	 * @param digits
	 * @return
	 */
	public BenefitLoginPage withLastDigits (String digits) {
		benefitDigitsInput.sendKeys(digits);
		return this;
	}

	
	
	/**
	 * submit - go to benefitDashboard
	 */
	public BenefitPage submit() {
		benefitSubmitBtn.click();
		return new BenefitPage(driver);
	}
	
	
}

