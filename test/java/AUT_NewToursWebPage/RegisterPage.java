package AUT_NewToursWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void firstName(String firstName) {
		userFirstName.sendKeys(firstName);
	}
	public void lastName(String lastName) {
		userLastName.sendKeys(lastName);
	}
	public void phoneNum(String phoneNum) {
		userPhoneNum.sendKeys(phoneNum);
	}
	public void emailId(String emailId) {
		userEmailId.sendKeys(emailId);
	}
	public void addressLine1(String address1) {
		userAddressLine1.sendKeys(address1);
	}
	public void addressLine2(String address2) {
		userAddressLine1.sendKeys(address2);
	}
	public void cityName(String city) {
		usercity.sendKeys(city);
	}
	public void postalCode(String postalCode) {
		userPostalCode.sendKeys(postalCode);
	}
	public void userName(String userName) {
		userUserName.sendKeys(userName);
	}
	public void password(String password) {
		userPassword.sendKeys(password);
	}

	public void confirmPassword(String password) {
		userConfirmPassword.sendKeys(password);
	}
	
	public void submitInfo() {
		submitUserInfo.click();
	}
	
	@FindBy(how=How.NAME,using="firstName")
	WebElement userFirstName;

	@FindBy(how=How.NAME,using="lastName")
	WebElement userLastName;

	@FindBy(how=How.NAME,using="phone")
	WebElement userPhoneNum;

	@FindBy(how=How.ID,using="userName")
	WebElement userEmailId;

	@FindBy(how=How.NAME,using="address1")
	WebElement userAddressLine1;

	@FindBy(how=How.NAME,using="address2")
	WebElement userAddressLine2;

	@FindBy(how=How.NAME,using="city")
	WebElement usercity;

	@FindBy(how=How.NAME,using="postalCode")
	WebElement userPostalCode;

	@FindBy(how=How.NAME,using="country")
	WebElement userCountry;

	@FindBy(how=How.ID,using="email")
	WebElement userUserName;

	@FindBy(how=How.NAME,using="password")
	WebElement userPassword;

	@FindBy(how=How.NAME,using="confirmPassword")
	WebElement userConfirmPassword;

	@FindBy(how=How.NAME,using="register")
	WebElement submitUserInfo;

}
