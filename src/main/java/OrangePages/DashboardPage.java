package OrangePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeTestbase.TestBase;

public class DashboardPage extends TestBase {
	
	// @FindBy(xpath="//a[@class='oxd-main-menu-item active']")
	@FindBy(xpath="//span[text()='Admin']")
	WebElement AdminBtn;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement PinManagement;
	
	@FindBy(xpath="//span[text()='Leave']")
	WebElement LeaveManagement;
	
	@FindBy(xpath="//span[text()='Time']")
	WebElement TimeManagement;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminPanelPage AdminPanel() {
		AdminBtn.click();
		return new AdminPanelPage();
	}
	
	public ProductinfoManagement PinManagement() {
		PinManagement.click();
		return new ProductinfoManagement();
	}

	public TimeManagementPage TimeManagement() {
		TimeManagement.click();
		return new TimeManagementPage();		
	}
	
	
	
}
