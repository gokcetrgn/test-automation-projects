package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PicturePage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By heart = By.cssSelector("div[class='SPw AAn uPZ jEe'] svg");
    By share = By.cssSelector("div[class='SPw AAn U7n jEe'] svg");
    By copyLink = By.cssSelector("div[class='SPw AAn Wqj jEe'] svg");
    By save = By.cssSelector(".B1n.tg7.fxm.wm0");
    By photoMenuItem = By.cssSelector(".gUZ.U9O.AR6");
    By downloadButton =By.cssSelector("button[id='pin-action-dropdown-item-0'] span[class='X8m zDA IZT fxm wm0']");
    By hideButton = By.cssSelector("button[id='pin-action-dropdown-item-1'] div[class='KS5 hs0 un8 C9i TB_']");
    By commentIcon =By.cssSelector("div[class='SPw AAn uPZ jEe'] svg");
    By commentField = By.cssSelector(".public-DraftStyleDefault-block.public-DraftStyleDefault-ltr");
    public PicturePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void heartIcon() {
        boolean isHeartFormVisible = elementHelper.findElement(heart).isDisplayed();
        Assert.assertTrue(isHeartFormVisible, "Resim görüntülenemedi!");
    }

    public void liked() {
        elementHelper.click(heart);
    }

    public void share(){
        elementHelper.click(share);
        elementHelper.click(copyLink);
    }

    public void saved(){
        elementHelper.click(save);
    }
    public void photoDownload(){
        elementHelper.click(photoMenuItem);
        elementHelper.click(downloadButton);
    }

    public void hideThePhoto(){
        elementHelper.click(hideButton);
    }
    public void commentIcon(String comment){
        elementHelper.click(commentIcon);

        elementHelper.click(commentField);
        elementHelper.sendKey(commentField, comment);
    }
}
