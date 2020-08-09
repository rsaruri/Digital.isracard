package PageObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionPage extends BasePage{
	
	//Element of trasaction list button
	@FindBy (xpath = "//*[@href='/personalarea/transaction-list/']")
	public WebElement transactionlistBtn;
	
	//Element of select billing date
	@FindBy (xpath = "//*[@ng-show='dc.ShowBillingTypes']")
	public WebElement BillingDateSelect;
	
	//Element of calander button 
	@FindBy (xpath = "//*[@ng-show='dc.ShowBillingCalander']")
	public WebElement BillingCalanderBtn;
	
	//Element of last billing date
	@FindBy (id = "ui-select-choices-row-3-1")
	public WebElement MoedKodemBtn;
	
	//Element of select month
	@FindBy (id = "ui-select-choices-row-3-2")
	public WebElement MonthBtn;
	
	//*[@id="datepicker-815-4145-0"]/button/span
	
	//אלמנט הלוח שנה
	 //*[@ng-model="date"]/li/div/table/tbody/tr[4]/td[3]/button/span
	
	/**
	 * c-tor transaction page
	 * @param driver
	 */
	public TransactionPage (WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Select a billing date by going over the drop down
	 * @throws InterruptedException 
	 */
	public void SelectBilingDate() throws InterruptedException {
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		BillingDateSelect.click();//click on that drop down
		
		MoedKodemBtn.click(); //click on last billing date  
		 
		assertTrue(BasePage.isOnPageByTitle(driver, driver.getTitle()));
		
		BillingDateSelect.click();//click on that drop down
		
		MonthBtn.click(); //click on select month 
		
		assertTrue(BasePage.isOnPageByTitle(driver, driver.getTitle()));
		
		BasePage.waitFor(BillingCalanderBtn);
		
		BillingCalanderBtn.click(); //click on calander 
		
		
		/*for (int i=0; i<12; i++) {
			//System.out.println("//*[@id=\"datepicker-1543-6961-"+i+"\"]");
			WebElement dateElement = driver.findElement(By.xpath("//*[@id='datepicker-815-4145-0']/button/span"));
			Thread.sleep(1000);
		}*/
		
	/*	WebElement dateElement = null;
		
		int i=0,j=0;
		for (i=1; i<=4; i++) {
			for (j=1; j<=3; j++) {
				System.out.println("xpath=//*[@ng-model=\"date\"][1]/li/div/table/tbody/tr["+i+"]/td["+j+"]");
				//WebElement dateElement = driver.findElement(By.xpath("//*[@ng-model=\"date\"][1]/li/div/table/tbody/tr["+i+"]/td["+j+"]"));
				dateElement= driver.findElement(By.xpath(" //*[@ng-model=\"date\"]/li/div/table/tbody/tr[4]/td[3]/button/span"));
				dateElement.click();
			}	
		}*/

	}
			
	
}
