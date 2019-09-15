package generic;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//base class
public abstract class BaseTest implements IAutoConst{
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(IE_KEY, IE_VALUE);
	}
	public WebDriver driver;
	public String ch=null;
	public WebDriverWait wait;
	@BeforeMethod
	public void OpenApp()
	{
		System.out.println("Select broswer: \n 1.Chrome \n 2.Firefox \n 3. InternetEdge");
		System.out.println("Enter your choice");
		Scanner sc=new Scanner(System.in);
		if(sc.hasNextLine()) {
			ch=sc.nextLine();
		}
		switch(ch.toLowerCase())
		{
		case "gc": driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,20);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(APP_URL);
		break;
		case "ff": driver=new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,15);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(APP_URL);
		break;
		
		/*case "ie": driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(APP_URL);
		break;*/
		default :
			driver=new ChromeDriver();
			wait = new WebDriverWait(driver,15);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
			driver.get(APP_URL);
		//	System.exit(0);
		}
		
		sc.close();
		
		
	}
	

	
	@AfterMethod
	public void closeApp(ITestResult iTestResult) {
		int status=iTestResult.getStatus();
		String name=iTestResult.getName();
		if(status==1) {
			Reporter.log("Test "+name+" is PASS",true);
		}
		else {
			Reporter.log("Test "+name+" is FAIL/SKIP",true);
			AutoLib.getPhoto(driver,IMG_PATH+name+".png");			
		}
		
		
		driver.close();
	}
	
	
	/*@BeforeMethod(dependsOnMethods="OpenApp()")
	public void OpenApp1()
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.get(APP_URL);
	}
	
	@AfterMethod(dependsOnMethods="closeApp()")
	public void CloseApp() {
		driver.close();
	}
*/	
}
