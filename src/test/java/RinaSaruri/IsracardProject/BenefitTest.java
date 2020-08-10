package RinaSaruri.IsracardProject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.BasePage;
import PageObject.BenefitLoginPage;
import PageObject.BenefitPage;
import PageObject.LoginPage;

public class BenefitTest {
	/**
	 * Test class of Benefits site
	 * 
	 * @author Rina Saruri
	 *
	 */
	
	public static WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	@BeforeAll
	public static void OpenWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/temp/chromedriver.exe");
		driver  = new ChromeDriver();
		
	}
		
	@BeforeEach
	public void OpenisracardWeb() {
		//Goto page
		driver.get("https://benefits.isracard.co.il");
		driver.manage().window().maximize();
	}
	
	@Test
	public void downloadBenefit () { 
		
		BenefitPage benefit = new BenefitPage(driver);
		BenefitLoginPage BenefitLogin = new BenefitLoginPage (driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scroll the page until the element is found		
        js.executeScript("arguments[0].scrollIntoView();",benefit.benefit_9308);	
        
		benefit.downloadBenefit(benefit.benefit_9308);
		
		wait.until(ExpectedConditions.visibilityOf(BenefitLogin.benefitIdInput));
		
		BenefitLogin.withId("201380003").withLastDigits("115742").submit();
		
	}
}
