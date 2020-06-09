package AUT_NewToursWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void registerTab() {
		registerTab.click();
	}

	@FindBy(how=How.XPATH,using="//a[contains(text(),'REGISTER')]")
	WebElement registerTab;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Flights')]")
	WebElement flightOption;

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Destinations')]")
	WebElement destinationOption;

}
