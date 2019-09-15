package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage  {
@FindBy(id="txtUsername")
private WebElement UN;

@FindBy(id="txtPassword")
private WebElement PWD;

@FindBy(id="welcome")
//@FindBy()
private WebElement wel;


@FindBy(id="btnLogin")
private WebElement LoginBTN;

@FindBy(xpath="//span[contains(text(),'invalid')]")
private WebElement errMsg;

public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
public void setUN(String un)
{
	UN.sendKeys(un);
}

public void setPWD(String pw)
{
	PWD.sendKeys(pw);
}

public void setChk()
{
	System.out.println(wel.getText());
	Assert.assertEquals(wel.getText(), "Welcome Ram");
   	//Assert.assertTrue(wel.isDisplayed());
}

public void verifyerrMsg()
{
	Assert.assertTrue(errMsg.isDisplayed(), "invalid Login");
}

public void Loginbtn()
{
	LoginBTN.click();
}


}
