package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonPages {
    static WebDriver driver;

    static ElementHelper elementHelper;

    WebDriverWait webDriverWait;

    static By accept = By.id("sp-cc-accept");
    static By search = By.id("twotabsearchtextbox");
    static By searchButton = By.id("nav-search-submit-button");
    static By amazonIcon = By.xpath("//li[@id='p_98/21345978031']//i[@class='a-icon a-icon-checkbox']");
    static By appleIcon= By.xpath("//a[@aria-label='Sonuçları daraltmak için Apple filtresini uygulayın']//i[@class='a-icon a-icon-checkbox']");
    static By firstProduct = By.cssSelector("h2[aria-label='Apple AirPods 4.Nesil ANC Kablosuz Kulaklık, Bluetooth Kulaklık, Aktif Gürültü Engelleme, Adaptif Ses, Şeffaf Mod, Kişiselleştirilmiş Uzamsal Ses, USB-C Şarj Kutusu, Kablosuz Şarj, H2 Çip'] span");
    static By addToCardButton = By.id("add-to-cart-button");
    static By goToTheCard = By.cssSelector(".a-button-text[href='/cart?ref_=sw_gtc']");

    public AmazonPages(WebDriver driver){
    this.driver = driver;
    this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.elementHelper = new ElementHelper(driver);
    }

    public static void HomePage() {
    }

    public static void acceptCookies() {

        elementHelper.click(accept);
    }

    public static void clickSearchButton() {
        elementHelper.click(search);
        elementHelper.sendKey(search, "Airpods");
        elementHelper.click(searchButton);
    }

    public static void filterAmazon() {
        elementHelper.click(amazonIcon);
    }

    public static void filterApple() {
        elementHelper.click(appleIcon);
    }

    public static void firstProduct() {
        elementHelper.click(firstProduct);
    }

    public static void addToCard() {
        elementHelper.click(addToCardButton);
    }

    public static void checkTheCard() {
        elementHelper.click(goToTheCard);
    }
}
