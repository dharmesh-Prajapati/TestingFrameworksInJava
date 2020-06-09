package AUT_TestProjectIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='logo-and-links']/a[1]//*[local-name()='svg']")
	WebElement testProjectLogo;

	@FindBy(how=How.ID, using="")
	WebElement x;

	
	/*
	 *  return true when 'Test Project' logo present 
	 */
	public boolean isLogoPresent() {
		return testProjectLogo.isDisplayed();
	}
}
