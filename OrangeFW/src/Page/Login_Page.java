package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login_Page extends BasePage{

	public Login_Page(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	
	 By usernameBy = By.id("txtUsername");
	    By passwordBy = By.id("txtPassword");
	    By loginButtonBy = By.id("btnLogin");
	   // By errorMessageUsernameBy = By.cssSelector("#loginForm .error:nth-of-type(1) .errorMessage");
	    //By errorMessagePasswordBy = By.cssSelector("#loginForm .error:nth-of-type(2) .errorText");
	    By errMsg=By.xpath(".//span[@id='spanMessage']");
	    By errMsg1=By.id("welcome");
	    //*********Page Methods*********
	    public void loginToN11 (String username, String password){
	        //Enter Username(Email)
	        writeText(usernameBy,username);
	        //Enter Password
	        writeText(passwordBy, password);
	        //Click Login Button
	        click(usernameBy); //In order to click right, this line needed. Site related.
	        click(loginButtonBy);
	    }

//	    //Verify Username Condition
//	    public void verifyLogin(String expectedText) {
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
//	        Assert.assertEquals(readText(errMsg), expectedText);
//	    }
//
//	    //Verify Password Condition
//	    public void verifyWelcome(String expectedText) {
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg1));
//	        Assert.assertEquals(readText(errMsg1), expectedText);
//	    }
	    public void setChk()
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg1));
	    	//System.out.println(((WebElement) errMsg1).getText());
	    	Assert.assertEquals(errMsg1, "Welcome");
	       	//Assert.assertTrue(wel.isDisplayed());
	    }

	    public void verifyerrMsg()
	    {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(errMsg));
	    	Assert.assertTrue(((WebElement) errMsg).isDisplayed(), "invalid Login");
	    }


}
