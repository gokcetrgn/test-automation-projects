package Steps;

import Pages.LoginPage;
import Util.ConfigReader;
import Util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;

    @Before
    public void before(){
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initialize_Properties();

        if (DriverFactory.getDriver() == null) {
            driver = DriverFactory.initialize_Driver(browser);
        } else {
            driver = DriverFactory.getDriver();
        }

    }

    @Before("@SavePicture")
    public void beforeLoginTests() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");

        Properties props = ConfigReader.initialize_Properties();
        String url = props.getProperty("url");
        String email = props.getProperty("email");
        String password = props.getProperty("password");

        if (DriverFactory.getDriver() == null) {
            driver = DriverFactory.initialize_Driver(browser);
        } else {
            driver = DriverFactory.getDriver();
        }

        // Login işlemi
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @After
    public void after(){
      //  driver.quit();
    }
}
