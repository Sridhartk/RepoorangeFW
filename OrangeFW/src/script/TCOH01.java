package script;

import org.testng.annotations.Test;

import generic.XL;

public class TCOH01 extends generic.BaseTest {

		@Test(priority=1)
		//TEST ID: OH-1-To check the login with valid ESS user and valid password.
		//ToCheckLoginWithValidESSUserPassword
		public void testValidLogin() throws InterruptedException
		{
			String un=generic.XL.getData(XL_PATH,"Login",1,0);
			String pw=generic.XL.getData(XL_PATH,"Login",1,1);
			String title=XL.getData(XL_PATH,"Login",1,2);
//			String un1=XL.getData(XL_PATH, "InvalidLogin", 1, 0);
//			String pw1=XL.getData(XL_PATH, "Invalid", 1, 1);
			
			//Setup-Step:1-Open the application URL: https://opensource-demo.orangehrmlive.com/"
			//Step:2. Enter valid ESS user name
			Page.LoginPage lp=new Page.LoginPage(driver);
			Thread.sleep(4000);
			lp.setUN(un);
			//Step:3. Enter valid ESS password
			Thread.sleep(4000);
			lp.setPWD(pw);
			//Step: 4. Click on Login button
			lp.Loginbtn();
			
		
		
			//Expected Result: User can see "Personal Details/Welcome" page 
			lp.setChk();
			
			Thread.sleep(4000);
			
	
		}

}
