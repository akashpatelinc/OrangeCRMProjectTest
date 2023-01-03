package OrangeTestsPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import OrangePages.DashboardPage;
import OrangePages.LoginPage;
import OrangeTestbase.TestBase;

public class MainLoginPageTest extends TestBase {
	
	//title = OrangeHRM
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	
	
	public MainLoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void intializeLoginPageTest() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title = loginpage.LoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");	
	}
	
	@Test(priority=2)
	public void LoginPageLogoTest() {
		boolean LogoActual = loginpage.LoginPageLogo();
		Assert.assertTrue(LogoActual);
	}
	
	@Test(priority=3)
	public void UserloginTest() {
		dashboardpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

}

