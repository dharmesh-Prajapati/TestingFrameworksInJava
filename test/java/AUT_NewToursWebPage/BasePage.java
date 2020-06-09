package AUT_NewToursWebPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	
	public void selectFromDropDown( WebElement element, String text) {
		
		Select sldpdn = new Select(element);
		sldpdn.selectByVisibleText(text);
	}
}
