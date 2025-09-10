package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DiscoverPage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;


    public DiscoverPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void controlPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://tr.pinterest.com/ideas",
                "Beklenen anasayfa açılmadı! Şu anki URL: " + currentUrl);
    }
}
