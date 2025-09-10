package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static Properties properties;
    static WebDriver driver;

    public static WebDriver initialize_Driver(String browser){
        properties = ConfigReader.getProperties();
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else{
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        }
        String url = properties.getProperty("url");
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        driver.get(url);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
