package script;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Page.LoginPage;
import Page.Login_Page;
import generic.BaseTest;
import generic.XL;

public class LoginTest extends BaseTest{
	
	@Test(priority=1)
	//TEST ID: OH-1-To check the login with valid ESS user and valid password.
	//ToCheckLoginWithValidESSUserPassword
	public void TCOH01testValidLogin() throws InterruptedException
	{
		String un=generic.XL.getData(XL_PATH,"Login",1,0);
		String pw=generic.XL.getData(XL_PATH,"Login",1,1);
		String title=XL.getData(XL_PATH,"Login",1,2);
//		String un1=XL.getData(XL_PATH, "InvalidLogin", 1, 0);
//		String pw1=XL.getData(XL_PATH, "Invalid", 1, 1);
		
		//Setup-Step:1-Open the application URL: https://opensource-demo.orangehrmlive.com/"
		//Step:2. Enter valid ESS user name
		Login_Page lp=new Login_Page(driver,wait);
		
		
		
		//Step:3. Enter valid ESS password
	//	lp.verifyLoginPassword(pw);
		//Step: 4. Click on Login button
		lp.loginToN11(un, pw);
		
	
	
		//Expected Result: User can see "Personal Details/Welcome" page 
		//lp.verifyLogin(un);
		//lp.setChk();
		//lp.verifyerrMsg();
				

	}


}
