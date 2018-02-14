package test.java.dockerRemoteProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class test {
		private static String OSNAMES = System.getProperty("os.name").toLowerCase();
	    private static final String FIREFOX = "MFF";
	    private static final String CHROME = "GC";
	    
	    private static void setPropertyForBrowserFF(String OS) {
	        
	        if (OS.equalsIgnoreCase("windows")){
	           System.setProperty("webdriver.firefox.driver", 
	        		   System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "geckodriver.exe");
	        }
	        else if (OS.equalsIgnoreCase("linux")){
	        	System.setProperty("webdriver.chrome.driver",
	        			System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "geckodriverLinux");
	        }
	        else if (OS.equalsIgnoreCase("mac")){
	        	System.setProperty("webdriver.chrome.driver",
	        			System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "geckodrivermac");
	        }    
	    }
	    
	    private static void setPropertyForBrowserGC(String OS) {
	        if (OS.equalsIgnoreCase("windows")) {
	            System.setProperty("webdriver.chrome.driver",
	            		System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedriver.exe");
	        }
	        else if (OS.equalsIgnoreCase("linux")){
	        	System.setProperty("webdriver.chrome.driver",
	        			System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedriverlinux");
	        }
	        else if (OS.equalsIgnoreCase("mac")){
	        	System.setProperty("webdriver.chrome.driver",
	        			System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedrivermac");
	        }        
	    }
	    public static WebDriver getDriver(String browserType)
	    {
	        String OS = OSNAMES.split(" ")[0];
	        WebDriver driver=null;

	        if(browserType.equalsIgnoreCase(FIREFOX))
	        {
	            setPropertyForBrowserFF(OS);
	            try {
	    	        DesiredCapabilities cap = DesiredCapabilities.firefox();
	    	        cap.setCapability("version", "");
	    	        cap.setCapability("platform", "LINUX");
					driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        else if(browserType.equalsIgnoreCase(CHROME))
	        {
	            setPropertyForBrowserGC(OS);
	            try {
	    	        DesiredCapabilities cap = DesiredCapabilities.chrome();
	    	        cap.setCapability("version", "");
	    	        cap.setCapability("platform", "LINUX");
					driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
			return driver;
	        }

	    
	    
		@Test
	    void mytest() throws InterruptedException {
/*		System.setProperty("webdriver.chrome.driver","D:\\Workspace\\concepts\\src\\libs\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
		WebDriver driver = test.getDriver("GC");
	    driver.get("http://demo.guru99.com/selenium/newtours/register.php");
	    
	    WebElement mydropdown = driver.findElement(By.xpath("//select[@name='country']"));
	  //  mydropdown.click();
	    
	    Thread.sleep(5000);
	    
	    Select select = new Select(mydropdown);
	 //   select.

	    int cc=select.getOptions().size();  // total number of values/options present


	    //how to select and extact text using select class
	    select.selectByIndex(4);
	    WebElement first_value=select.getFirstSelectedOption();
	    String value=first_value.getText();
	    System.out.println("Size ="+cc);
	    System.out.println("FirstValue ="+value);
	    
	    //how to get the last value
	    int last_value=select.getOptions().size()-1;
	    select.selectByIndex(last_value);
	    WebElement lasvalue=select.getFirstSelectedOption();
	    System.out.println("lastvalue="+lasvalue.getText());
	 //   select.selectByValue("ANDORRA");
	    
	    select.getAllSelectedOptions();
	  //  select.deselectAll();
	    System.out.println("guru99 testcase executed");
	    System.out.println("Regression 1");
	    driver.quit();
	    
	}
		
		@Test
	    void mytest2() throws InterruptedException {
/*		System.setProperty("webdriver.chrome.driver","D:\\Workspace\\concepts\\src\\libs\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);*/
			WebDriver driver = test.getDriver("MFF");
	    driver.get("https://www.google.co.in/");
	    driver.findElement(By.name("q")).sendKeys("Shubham Jain Stackoverflow");
	    driver.findElement(By.name("btnK")).click();
	    
	    System.out.println("Google testcase executed");
	    driver.quit();
	    
	}
}
