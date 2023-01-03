package OrangeTestsPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OrangePages.DashboardPage;
import OrangePages.LoginPage;
import OrangePages.ProductinfoManagement;
import OrangeTestbase.TestBase;
import OrangeUtilities.Testutil;

public class ProductInfoManagementTest extends TestBase {
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	ProductinfoManagement pimpage;
	
	public ProductInfoManagementTest() {
		super();
	}
	
	@BeforeMethod
	public void initiateDashBoardPageTest() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		dashboardpage = new DashboardPage();
		pimpage = new ProductinfoManagement();
		Thread.sleep(3000);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		Thread.sleep(3000);
		pimpage.pimTab.click();
		
	}

	@Test(priority=1)
	public void AddEmployeeTest() throws InterruptedException {
		pimpage.CreateNewEmployee(prop.getProperty("FnTest123"), prop.getProperty("LnTest123"), prop.getProperty("EmployIdTest123"));
	}
	
	//@Test(priority=2, dataProvider="getOrangeCrmTestData")
	public void CreatedEmployeeRecordVerified() {
		boolean RecordisDisplayed = pimpage.recordFound(prop.getProperty("EmployIdTest123"));
		Assert.assertTrue(RecordisDisplayed);
	}

	//@Test(priority=3, dataProvider="getOrangeCrmTestData")
	public void DeleteRecordTest() throws InterruptedException {
			boolean RecordisDeleted = pimpage.deleteRecord(prop.getProperty("EmployIdTest123"));
			Assert.assertTrue(RecordisDeleted);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
