package OrangeTestsPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrangePages.AdminPanelPage;
import OrangePages.DashboardPage;
import OrangePages.LoginPage;
import OrangePages.ProductinfoManagement;
import OrangePages.TimeManagementPage;
import OrangeTestbase.TestBase;

public class DashboardPageTest extends TestBase {

	LoginPage loginpage;
	DashboardPage dashboardpage;
	AdminPanelPage adminpanel;
	ProductinfoManagement pinmanagement;
	TimeManagementPage Timemanagepage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void initiateDashBoardPageTest() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		adminpanel = new AdminPanelPage();
		pinmanagement = new ProductinfoManagement();
		Timemanagepage = new TimeManagementPage();
		Thread.sleep(2000);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void AdminPanelPagelinkTest() {
		adminpanel = dashboardpage.AdminPanel();
	}
	
	// @Test
	public void PinManagementPagelinkTest() {
		pinmanagement = dashboardpage.PinManagement();
	}
	
	// @Test
	public void TimeManagementPageLinkTest() {
		Timemanagepage = dashboardpage.TimeManagement();
	}
	
	
}
