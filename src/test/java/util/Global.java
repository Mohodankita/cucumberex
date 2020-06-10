			package util;
		
		import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
		
		public class Global {
		
		private WebDriver driver;
		private Properties Prop;
		
		// driver method ah nd tych return type WebDriver
		public WebDriver driver()
		{
		Properties property = readPropertyFile();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-web-security");
		options.addArguments("--no-proxy-server");
		HashMap<String,Object>hash=new HashMap<String,Object>();
		//object ah ek cls ah
		hash.put("Credentials-enable-service", false);
		
		hash.put("profile.password-manager-enabled", false);
		//window fls keli rember.
		options.getExperimentalOption("prefs,hash");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		System.setProperty("webdriver.chrome.driver","chromedriver1.exe");
		driver = new ChromeDriver();
		driver.get(property.getProperty("URL"));
		//get method means 
		driver.manage().window().maximize();
		//
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		//
		return driver;
		}
		
		public Properties readPropertyFile() {
		try {
		File file = new File("declaration.properties");
		FileInputStream obj = new FileInputStream(file);
		//memory madhe alyashiv complier run nai krt
		// read krla
		Prop = new Properties();
		// obj crt kel
		Prop.load(obj);
		} catch (FileNotFoundException e) {
		e.printStackTrace(); 
		} catch (IOException e) {
		e.printStackTrace();
		}
		return Prop;
		}
		}