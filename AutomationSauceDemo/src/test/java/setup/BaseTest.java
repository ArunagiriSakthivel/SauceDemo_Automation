package setup;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static WebDriver driver;
    public static Properties prop;

    //Configure Properties file set up 
  	protected  BaseTest() {  		
  		try {
  			prop = new Properties();
  			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
  			prop.load(ip);
  		} catch (FileNotFoundException e) {
  			e.printStackTrace();
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	}  	
  	
  	//Browser setup and password manager
  	@BeforeTest
  	public static void initialize() {
  		String browserName = prop.getProperty("browser");  
  		final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false); 
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
  		if(browserName.equals("chrome")) {		 
  			driver = new ChromeDriver(chromeOptions);  	       
  		}else if (browserName.equals("firefox")){
  			driver = new FirefoxDriver();
  		}  		
  		driver.manage().window().maximize();
  		driver.manage().deleteAllCookies();
  		driver.get(prop.getProperty("url"));  		
  	}
  	
  	//Tear down process  	
  	@AfterTest
  	public void teardoen() {
  		
  		 if (driver != null) {
             driver.quit(); // Quit all browser windows and end the WebDriver session.
             driver = null; // Set driver to null to indicate that the WebDriver session has ended.
         }
  	}
   
  	//Open Extent report automatically after execution completed
    @AfterSuite
    public void OpenExtentReport() {
		
    	try {
    		File htmlFile = new File("target/ExtentReport/extent-report.html");
    		if (htmlFile.exists()) {
    			Desktop.getDesktop().browse(htmlFile.toURI());
    		}else {
    			System.out.println("Report File not found"+htmlFile.getAbsolutePath());
    			
    		}
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}