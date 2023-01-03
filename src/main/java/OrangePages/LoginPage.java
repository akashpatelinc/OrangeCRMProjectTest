package OrangePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeTestbase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//div[@class='orangehrm-login-logo']")
	WebElement OrangeLogo;
	
	@FindBy(name="username")
	WebElement User;
	
	@FindBy(name="password")
	WebElement Pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement LoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage login (String username, String password){
		User.sendKeys(username);
		Pass.sendKeys(password);
		LoginBtn.click();
		return new DashboardPage();
	}
	
	public String LoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean LoginPageLogo() {
		return OrangeLogo.isDisplayed();
	}

	
}
