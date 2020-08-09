package PageObject;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebDriver driver;
	
	/**
	 * c-tor with WebDriver
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public static void waitFor(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * Checks whether the driver is set to the page by url of page
	 * @param driver
	 * @param Url of page
	 * @return true if the driver is located on the page
	 * false - otherwise
	 */
	public static boolean isOnPageByUrl(WebDriver driver, String url) {
		return driver.getCurrentUrl().contentEquals(url);
	}
	
	
	/**
	 * Checks whether the driver is set to the page by name of link
	 * @param linkTitle (name of link)
	 * @param title (title of page)
	 * @return true if the driver is located on the page
	 * false - otherwise
	 */
	public static boolean isOnPageByTitleAndLink(WebDriver driver ,String linkTitle, String title) {
		return driver.getTitle().contentEquals(title);
	}
	
	
	/**
	 * Checks whether the driver is set to the page by title
	 * @param driver 
	 * @param title (title of page)
	 * @return true if the driver is located on the page
	 * false - otherwise
	 */
	public static boolean isOnPageByTitle(WebDriver driver, String title) {
		return driver.getTitle().contentEquals(title);
	}
	
}
