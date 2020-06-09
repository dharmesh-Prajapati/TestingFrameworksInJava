package AUT_TestProjectIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(how=How.ID, using="username")
	WebElement username;
	
	@FindBy(how=How.ID, using="password")
	WebElement user_password;
	
	@FindBy(how=How.NAME, using="login")
	WebElement loginButton;
	
	@FindBy(how=How.ID, using="tp-signup-link")
	WebElement signUpForFree;
	
	@FindBy(how=How.XPATH, using="//div[@id='tp-forgot-password']/span/a")
	WebElement forgotPassword;	
	
	@FindBy(how=How.XPATH, using="//span[@id='tp-message-error']")
	WebElement loginErrorMessage;	
	
	
	public boolean errorMessage() {
		return loginErrorMessage.isDisplayed();
	}
	
	
	/*
	 * Enters userid
	 */
	public void enterUserId(String userId) {
		username.sendKeys(userId);
	}
	
	
	/*
	 * Enters password
	 */
	public void enterpassword(String password) {
		user_password.sendKeys(password);
	}
	
	/*
	 * Enters password
	 */
	public void loginButton() {
		loginButton.click();
	}
	
	/*
	 * click on Forgot password Link
	 */
	public void forgotPasswordLink() {
		forgotPassword.click();
	}
	
	/*
	 * accepts userid and password to login to application
	 */
	public void loginToApplication(String userID, String password) {
		username.sendKeys(userID);
		user_password.sendKeys(password);
		
		loginButton.submit();
	}
	
	/*
	 * Sign Up Link 
	 */
	public void signUpLink() {
		signUpForFree.click();
	}
	
}