package Pages;


import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By sportCategory = By.cssSelector(".sc-5eaafc6a-4.eeXkpK[href='/sport']");
    By sportNews = By.cssSelector("ul[class='ssrcss-uy86gw-Grid e12imr580'] li[class='ssrcss-1dr5icq-ListItem e1gp961v0'] a[class='ssrcss-mnw9yn-PromoLink exn3ah94']");

    By search = By.cssSelector("svg[width='50']");
    By searchTf = By.cssSelector("input[placeholder='Search news, topics and more']");
    By searchIcon = By.cssSelector("span[class='sc-28fdc07f-0 iqjqhc'] svg");

    By searchAP = By.cssSelector(".ssrcss-1rstd29-SearchText.eki2hvo13");
    By searchTfAP = By.cssSelector("input[class='sc-9e01a804-1 dLVhbr']");
    By searchAPIcon = By.cssSelector("div[class='sc-9e01a804-0 fvTpHb'] button[aria-label='Search'] span[class='sc-28fdc07f-0 iqjqhc'] svg");


    By menuCategory = By.cssSelector("[data-testid=\"level0NavButton-/culture\"]\n");
    By menuSubCat = By.cssSelector("[data-testid=\"level1NavButton-/culture/music\"]\n");
    By menuNews = By.cssSelector("div[class='sc-666b6d83-0 sc-9bf184ca-0 eucOUq hMmwyp'] div:nth-child(2) div:nth-child(1) a:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) h2:nth-child(1)");

    By selectedNews = By.cssSelector("h2[data-testid=\"card-headline\"]\n");
    By saveIcon = By.cssSelector("div[class='sc-801dd632-3 gXqOYA'] button[aria-label='Save'] span[class='sc-28fdc07f-0 iAIwa-D'] svg");

    By account = By.cssSelector(".sc-ac7f3982-1.cqxMID");
    By saved = By.cssSelector(".sc-82101eeb-3.hSFqAV[href='https://www.bbc.com/saved']");

    By signout = By.cssSelector(".sc-82101eeb-3.hSFqAV[href='https://session.bbc.com/session/signout?switchTld=true&ptrt=https%3A%2F%2Faccount.bbc.com%2Fsignout&userOrigin=BBCS_BBC']");
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void goToWebsite(){
        driver.get("https://www.bbc.com/");
    }

    public void clickOneCategory() {
        elementHelper.click(sportCategory);

    }

    public void clickOneNews() {
        elementHelper.click(sportNews);
    }


    public void clickSearch() {
        elementHelper.click(search);
    }

    public void clickSearchTf() {
        elementHelper.click(searchTf);
    }

    public void writeYourSearch() {
        elementHelper.sendKey(searchTf,"Computer");
    }

    public void clickTheSearchIcon() {
        elementHelper.click(searchIcon);
    }

    public void userAtAnotherPage() {
        driver.get("https://www.bbc.com/sport");
    }

    public void clickTheSearchAP() {
        elementHelper.click(searchAP);
    }

    public void clickTheSearchTFAP() {
        elementHelper.click(searchTfAP);
    }

    public void writeYourSearchAP() {
        elementHelper.sendKey(searchTfAP, "Hospital");
    }

    public void clickTheSearchIconAP() {
        elementHelper.click(searchAPIcon);
    }

    public void clickTheCategoryofMenu() {
        elementHelper.click(menuCategory);
    }

    public void clickTheSubcategory() {
        elementHelper.click(menuSubCat);
    }

    public void clickTheNews() {
        elementHelper.click(menuNews);
    }

    public void clickOnePage() {

        elementHelper.click(selectedNews);
    }

    public void clickSaveButton() {
        elementHelper.click(saveIcon);
    }

    public void clickYourAccountPage() {
        elementHelper.click(account);
    }

    public void clickSaved() {
        elementHelper.click(saved);
    }

    public void clickSignOut() {
        elementHelper.click(signout);
    }
}
