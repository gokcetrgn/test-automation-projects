package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By searchButton = By.cssSelector("input[placeholder='Ara']");
    By profile = By.cssSelector("[data-test-id=\"gestalt-avatar-svg\"]");


    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public void checkPage() {
        boolean isSearchFormVisible = elementHelper.findElement(searchButton).isDisplayed();
        Assert.assertTrue(isSearchFormVisible, "Anasayfaya yönlendirilemedi!");
    }


    public void clickthePhoto() {
        WebElement pin = driver.findElement(By.xpath("(//*[@class=\"PinCard__imageWrapper\"])[6]"));
        pin.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void loginControl(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean isProfileFormVisible = elementHelper.findElement(profile).isDisplayed();
        Assert.assertTrue(isProfileFormVisible, "Giriş yapılamadı!");
    }
}
