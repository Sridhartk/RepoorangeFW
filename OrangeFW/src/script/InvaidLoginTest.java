package script;

import org.testng.annotations.Test;

import Page.LoginPage;
import generic.BaseTest;
import generic.XL;

public class InvaidLoginTest extends BaseTest {

	@Test
	//TEST ID: OH-1-To check the login with invalid ESS user and invalid password.
	public void invalidtest() throws InterruptedException {
		//Setup-Step:1-Open the application URL: https://opensource-demo.orangehrmlive.com/"
		String un=XL.getData(XL_PATH, "InvalidLogin", 1, 0);
		String pw=XL.getData(XL_PATH, "InvalidLogin", 1, 1);
	
	LoginPage lp=new LoginPage(driver);
	Thread.sleep(3000);
	//Step:2. Enter invalid ESS user name
	lp.setUN(un);
	Thread.sleep(3000);
	//Step:3. Enter invalid ESS password
	lp.setPWD(pw);
	//Step: 4. Click on Login button
	lp.Loginbtn();
	Thread.sleep(3000);
	//Expected Result: User can see "Invalid" Message should be displayed
	lp.verifyerrMsg();
	}
}