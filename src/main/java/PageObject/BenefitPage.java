package PageObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenefitPage extends BasePage {
	
	@FindBy (xpath = "//*[@href=9308]")
	public WebElement benefit_9308;
	
	@FindBy (id = "invokeAcquire")
	public WebElement downloadBtn;
	
	/**
	 * c-tor benefit login page
	 * @param driver
	 */
	public BenefitPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * Click on benefit, open benefit page and download
	 * @param benefitName
	 */
	
	public void downloadBenefit (WebElement benefitName) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		benefitName.click();
		
		assertTrue(BasePage.isOnPageByTitle(driver, driver.getTitle()));
		
		wait.until(ExpectedConditions.visibilityOf(downloadBtn));
		
		downloadBtn.click();
		
	}
	
	
	
	
}
