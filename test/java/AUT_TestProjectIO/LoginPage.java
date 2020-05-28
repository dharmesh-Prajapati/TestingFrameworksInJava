package AUT_TestProjectIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
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
	
	@FindBy(how=How.XPATH, using="//div[@class='tp-logo dark']/img")
	WebElement logoTestProject;	
	
	
	/*
	 *  return true when 'Test Project' logo present 
	 */
	public boolean isLogoPresent() {
		return logoTestProject.isDisplayed();
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
	public void loginToAoolication(String userID, String password) {
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