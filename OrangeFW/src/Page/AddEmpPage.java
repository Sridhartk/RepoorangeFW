package Page;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmpPage {
	@FindBy(xpath=".//b[text()='PIM']")
	private WebElement pim;
	
	@FindBy(xpath=".//a[text()='Add Employee']")
	private WebElement addemp;
	
	@FindBy(id="firstName")
	private WebElement FNtxt;
	
	@FindBy(id="lastName")
	private WebElement LNtxt;
	
	@FindBy(id="employeeId")
	private WebElement empid;
	
	@FindBy(id="chkLogin")
	private WebElement chkBOX;
	
	@FindBy(id="user_name")
	private WebElement UNtxt;
	
	@FindBy(id="user_password")
	private WebElement PWtxt;
	
	@FindBy(id="re_password")
	private WebElement CPWtxt;
	
	@FindBy(id="btnSave")
	private WebElement saveBTN;
public Actions a;
public Robot r;
	public AddEmpPage(WebDriver driver) throws AWTException {
		PageFactory.initElements(driver, this);
		a=new Actions(driver);
		  r=new Robot();
	}
	
	public void clickPIM()
	{
		pim.click();
//		 a.moveToElement(pim).build().perform();
//		 a.moveToElement(pim, 110, 0).build().perform();
//		 r.mouseMove(110, 0);
	}
	
	public void clickaddemp()
	{
		addemp.click();
	}
	public void setFN(String fn)
	{
		FNtxt.sendKeys(fn);
	}
	
	public void setLN(String ln)
	{
		LNtxt.sendKeys(ln);
	}
	
	public void setid(String id)
	{
		empid.clear();
		empid.sendKeys(id);
	}
	
	public void ClickchkBOX()
	{
	    chkBOX.click();
	}
	
	public void setUn(String un)
	{
		UNtxt.sendKeys(un);
	}
	
	public void setpw(String pwd)
	{
		PWtxt.sendKeys(pwd);
	}
	
	public void setcpw(String cpw)
	{
		CPWtxt.sendKeys(cpw);
	}
	
	public void Clicksave()
	{
	    saveBTN.click();
	}
}
