package PageObject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;

public class FooterPage extends BasePage{

	String categoryName=null;
	
	//Element of benefits link - exist in footer
	@FindBy(xpath = "//*[@id='Digital_Footer']/footer/nav/div/div/ul/li[5]/h3")
	public WebElement BenefitsLink;
	
	//Element of container - exist in every category page
	@FindBy (xpath="//*[@class='category-banner-strip container']")
	private WebElement container ;
	
	
	public FooterPage (WebDriver driver) {
		super(driver);
	}

	
	
	public  void clickOnCategoryFromBenefits () {
			
		String originalHandle = driver.getWindowHandle();
		int i=1;
		
		do {
			try {
				WebElement category = driver.findElement(By.xpath("//*[@class='site-footer__nav-item col-sm-4'][5]//*[@class='site-footer__nav-list-second-level']/li["+i+"]/a"));
				categoryName = category.getText().toString();
				category.click(); //click on category
				BasePage.waitFor(container); //wait until the category page will appear 
			
				i++; //index for each category
				
				//save the handle of each category
				for (String handle : driver.getWindowHandles()) {
					if (!handle.equals(originalHandle)) {
						driver.switchTo().window(handle);  //switch to category page
					}
				}
				
				try {
					assertTrue(BasePage.isOnPageByTitleAndLink(driver,categoryName, driver.getTitle() ));
					System.out.println("The link "+ categoryName + " move to the page: "+ driver.getTitle().toString());
					
				} finally {	driver.navigate().back(); }
				
			} finally { driver.switchTo().window(originalHandle); }  
				
		} while (i!=0 && i<11);
			
	} 	
}




