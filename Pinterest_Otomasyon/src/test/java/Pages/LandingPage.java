package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By loginPageButton = By.cssSelector("div[class='SBF'] div[class='B1n tg7 fxm wm0']");
    By signUpPage = By.cssSelector(".X8m.tg7.fxm.wm0");
    By discoverPage = By.cssSelector(".X8m.tg7.eSP.dyH.llN.Kv8");

    public LandingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void goToPinterest() {
        driver.get("https://tr.pinterest.com/");
    }

    public void goToLoginPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.click(loginPageButton);
    }

    public void goToSignUpPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.click(signUpPage);
    }


    public void controlPage() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://tr.pinterest.com/",
                "Beklenen anasayfa açılmadı! Şu anki URL: " + currentUrl);
    }

    public void clickButtonFromHeader() {
        elementHelper.click(discoverPage);
    }


}
