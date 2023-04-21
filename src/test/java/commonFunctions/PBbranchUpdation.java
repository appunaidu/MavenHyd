package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class PBbranchUpdation {
WebDriver driver;
public PBbranchUpdation(WebDriver driver)
{
	this.driver=driver;
	
}
@FindBy(xpath = "(//img)[10]")
WebElement ClickEdit;
@FindBy(xpath = "//input[@id='txtbnameU']")
WebElement EnterBranch;
@FindBy(xpath = "(//input[@id='txtadd1u'])[1]")
WebElement EnterAddress;
@FindBy(xpath = "//input[@id='txtareaU']")
WebElement EnterArea;
@FindBy(xpath = "//input[@id='txtzipu']")
WebElement EnterZip;
@FindBy(xpath = "//input[@id='btnupdate']")
WebElement ClickUpdate;
public boolean verify_UpdateBranch(String branch,String Address,String Area,String Zipcode) throws Throwable
{
	this.ClickEdit.click();
	this.EnterBranch.clear();
	this.EnterBranch.sendKeys(branch);
	this.EnterAddress.clear();
	this.EnterAddress.sendKeys(Address);
	this.EnterArea.clear();
	this.EnterArea.sendKeys(Area);
	this.EnterZip.clear();
	this.EnterZip.sendKeys(Zipcode);
	this.ClickUpdate.click();
	String ExpectedAlert = driver.switchTo().alert().getText();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	String Actualalert = "Branch Updated";
	if(ExpectedAlert.toLowerCase().contains(Actualalert.toLowerCase()))
	{
		Reporter.log(ExpectedAlert,true);
		return true;
		
	}
	else
	{
	Reporter.log("unable to Update Branch",true);
	return false;
	}
}
}
