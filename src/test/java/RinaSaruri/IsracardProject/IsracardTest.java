package RinaSaruri.IsracardProject;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import PageObject.BasePage;
import PageObject.FooterPage;
import PageObject.LoginPage;
import PageObject.TransactionPage;
import PageObject.UpdatePasswordPage;
import junit.framework.Assert;

public class IsracardTest {
		
	/**
	 * Test class of Isracard site
	 * 
	 * @author Rina Saruri
	 *
	 */
	
	public static WebDriver driver;
	
	
	@BeforeAll
	public static void OpenWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");
		driver  = new ChromeDriver();
		
	}
		
	@BeforeEach
	public void OpenisracardWeb() {
		//Goto page
		driver.get("https://digital.isracard.co.il/");
		driver.manage().window().maximize();
	}
	
	
	
	@Test
	public void footerLink() {
		
		FooterPage footer = new FooterPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scroll the page until the element is found		
        js.executeScript("arguments[0].scrollIntoView();", footer.BenefitsLink);	
		
		//Wait until the benefit link is displayed
		BasePage.waitFor(footer.BenefitsLink);
		
		//Click on category link of benefits
		footer.clickOnCategoryFromBenefits();		
	}
	
	
	@Test
	public void OpenTrnsactionListAndUpdatePassword() throws InterruptedException  {
		LoginPage login = new LoginPage (driver);
		//BasePage button = new BasePage(driver);
		TransactionPage transaction = new TransactionPage(driver);
		UpdatePasswordPage updatePass = new UpdatePasswordPage(driver);
		
		//click on transaction button from isracard web
		transaction.transactionlistBtn.click();
		
		//Verify the url of page
		assertTrue(BasePage.isOnPageByUrl(driver, "https://digital.isracard.co.il/personalarea/Login/?returnUrl=http://digital.isracard.co.il/personalarea/transaction-list/"));
		
		//Wait until ID field is displayed
		BasePage.waitFor(login.idInput);
		
		//Login to isracard web by id and password
		 transaction = login.withId("201380003").withLastDigits("878390").withPassword("q1111111").submit();
		
		//Wait until drop down billing date is displayed
		BasePage.waitFor(transaction.BillingDateSelect);
		 
		//Verify the url of page
		assertTrue(BasePage.isOnPageByUrl(driver, "https://digital.isracard.co.il/personalarea/transaction-list/"));
		
		//Go to the method that choose a billing date
		transaction.SelectBilingDate();
		
		//Move to element MyAccount button from the header page
		new Actions(driver).moveToElement(updatePass.accountBtn).perform();
		
		//Wait until update password button is displayed
		BasePage.waitFor(updatePass.updatePassBtn);
		
		//Move to element update password button
		new Actions(driver).moveToElement(updatePass.updatePassBtn).click().perform();
		
		//Verify the url of page
		assertTrue(BasePage.isOnPageByUrl(driver,"https://digital.isracard.co.il/personalarea/renewpassword/"));
		
		//Wait until OldPassword field is displayed on the new page: "Update Password"
		BasePage.waitFor(updatePass.oldPassInput);
		
		//update password by 3 parameters
		updatePass.withOldPass("q1111111").withNewPass("a1111111").withRepeatNewPass("a1111111").submitBtn.click();
		
		//Checks if he got the success page
		BasePage.waitFor(updatePass.successForm);
		assertEquals(true, updatePass.successForm.isDisplayed());
		System.out.println("Password changed successfully");
	}

	
	@After
	public static void AfterAll() {
		driver.quit();
	}
}

