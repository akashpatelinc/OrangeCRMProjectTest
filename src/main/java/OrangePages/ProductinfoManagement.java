package OrangePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import OrangeTestbase.TestBase;

public class ProductinfoManagement extends TestBase {
	
	@FindBy(linkText="PIM")
	public
	WebElement pimTab;
	
	@FindBy(xpath="//a[contains(text(),'Add Employee')]")
	WebElement AddAnEmployee;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
	WebElement EmployFirstName;
	
	@FindBy(xpath="//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
	WebElement EmployLastName;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement NewEmployId;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveBtn;
	
	@FindBy(xpath="//a[contains(text(),'Employee List')]")
	WebElement EmployList;
	
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement SearchById;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SearchRecordBtn;
	
	@FindBy(xpath="//span[text()='No Records Found']")
	WebElement NoRecordFound;
	
	@FindBy(xpath="//span[text()='(1) Record Found']")
	WebElement RecordFound;
	
	// //div[@class='oxd-table-card-cell-checkbox']//div[@class='oxd-checkbox-wrapper']//label//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']
	
	@FindBy(xpath="//div[contains(text(),'0255')]")
	WebElement EmployIdRecordFound;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-trash']")
	WebElement DeleteRecord;
	
	public ProductinfoManagement() {
		PageFactory.initElements(driver, this);
	}
	
	public void CreateNewEmployee(String FirstName, String LastName, String EmployId) throws InterruptedException {
		AddAnEmployee.click();
		Thread.sleep(2000);
		EmployFirstName.sendKeys(FirstName);
		EmployLastName.sendKeys(LastName);
		NewEmployId.sendKeys(EmployId);
		SaveBtn.click();		
	}
	
	public void verifyCreatedEmployeeRecord(String ID) {
		EmployList.click();
		SearchById.sendKeys(ID);
		SearchRecordBtn.click();
	}
	
	public boolean recordFound(String EmployId) {
		 EmployList.click();
		 SearchById.sendKeys(EmployId);
		 return driver.findElement(By.xpath("//div[contains(text(),'"+EmployId+"')]")).isDisplayed();
	}
	
	public boolean deleteRecord(String EmplID) throws InterruptedException {
		EmployList.click();
		SearchById.sendKeys(EmplID);
		SearchRecordBtn.click();
		DeleteRecord.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-overlay oxd-overlay--flex oxd-overlay--flex-centered']/div[@class='oxd-dialog-container-default']/div[@class='oxd-dialog-container-default--inner']/div[@class='oxd-sheet oxd-sheet--rounded oxd-sheet--white oxd-dialog-sheet oxd-dialog-sheet--shadow oxd-dialog-sheet--gutters orangehrm-dialog-popup']/div[@class='orangehrm-modal-footer']/button[2]")).click();
		Thread.sleep(2000);
		SearchById.sendKeys(EmplID);
		SearchRecordBtn.click();
		return driver.findElement(By.xpath("//span[text()='No Records Found']")).isDisplayed();
	}
	
	

}
