package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class PBBranchCreation {
WebDriver driver;
public PBBranchCreation(WebDriver driver)
{
	this.driver = driver;
}
@FindBy(xpath="//input[@id='BtnNewBR']")
WebElement ClicknewBranch;
@FindBy(xpath="//input[@id='txtbName']")
WebElement EnterBranch;
@FindBy(xpath="(//input[@type='text'])[2]")
WebElement EnterAddress1;
@FindBy(xpath="(//input[@type='text'])[3]")
WebElement EnterAddress2 ;
@FindBy(xpath="(//input[@type='text'])[4]")
WebElement EnterAddress3;
@FindBy(xpath="//input[@name='txtArea']")
WebElement EnterArea;
@FindBy(xpath="//input[@name='txtZip']")
WebElement EnterZipcode;
@FindBy(xpath="//select[@id='lst_counrtyU']")
WebElement SelectCountry ;
@FindBy(xpath="//select[@id='lst_stateI']")
WebElement SelectState;
@FindBy(xpath="//select[@id='lst_cityI']")
WebElement SelectCity;
@FindBy(xpath="//input[@id='btn_insert']")
WebElement ClickSubmit;
public boolean verify_Branchcreate(String branchname,String Address1,String Address2,String Address3,String Area,String Zipcode,String Country,String State,String City) throws Throwable      
{
	this.ClicknewBranch.click();
	this.EnterBranch.sendKeys(branchname);
	this.EnterAddress1.sendKeys(Address1);
	this.EnterAddress1.sendKeys(Address2);
	this.EnterAddress1.sendKeys(Address3);
    this.EnterArea.sendKeys(Area);
    this.EnterZipcode.sendKeys(Zipcode);
    new Select(this.SelectCountry).selectByVisibleText(Country);
    new Select(this.SelectState).selectByVisibleText(State);
    new Select(this.SelectCity).selectByVisibleText(City);
    this.ClickSubmit.click();
    Thread.sleep(3000);
    String ExpectedAlert = driver.switchTo().alert().getText();
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    String ActualAlert = "New Branch with id";
    if (ExpectedAlert.toLowerCase().contains(ActualAlert.toLowerCase())) 
    {
    	Reporter.log(ExpectedAlert,true);
    	return true;
    }
    {
    	Reporter.log("Unable to create new Branch ",true);
	    return false;
	}
}
}

