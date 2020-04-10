package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	public FileInputStream file;
	public Config config;
	
	

	public WebDriver browserInit() throws IOException {
		/*String hubUrl="http://10.0.0.2:4444/wd/hub";
		DesiredCapabilities cp=new DesiredCapabilities();
		cp.setBrowserName("firefox");
		cp.setPlatform(Platform.WINDOWS);	
			
		driver=new RemoteWebDriver(new URL(hubUrl),cp);
		
		*/
		prop = new Properties();
		config = new Config();
		file = new FileInputStream(config.getConfigDir());
		prop.load(file);

		if (prop.get("browser").equals("chrome")) {
			System.setProperty(prop.getProperty("chromeDriver"), prop.getProperty("chromeDriverDir"));
			driver = new ChromeDriver();
		} else if (prop.get("browser").equals("firefox")) {
			System.setProperty(prop.getProperty("geckoDriver"), prop.getProperty("geckoDriverDir"));
			driver = new FirefoxDriver();
		}
		else if (prop.get("browser").equals("ie")) {
			System.setProperty(prop.getProperty("ieDriver"), prop.getProperty("ieDriverDir"));
			driver = new InternetExplorerDriver();
		}	
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS);
		
		return driver;

	}
	public void launchApp() {
		
		driver.get(prop.getProperty("url"));
		
	}
}
