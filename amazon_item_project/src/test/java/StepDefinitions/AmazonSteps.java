package StepDefinitions;

import Pages.AmazonPages;
import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class AmazonSteps {
    WebDriver driver = DriverFactory.getDriver();
    AmazonPages pages = new AmazonPages(driver);

    @Given("Amazon.com açılır")
    public void amazonComAcilir() {
        pages.HomePage();
    }

    @When("Cookie kabul edilir")
    public void cookieKabulEdilir() {
        pages.acceptCookies();
    }
    @When("Aramaya urun yazılır ve aranır")
    public void aramayaUrunYazilirVeAranir() {
        pages.clickSearchButton();
    }

    @When("Ürün sadece Amazon Tarafından gönderilir.")
    public void urunSadeceAmazonTarafindanGonderilir() {
        pages.filterAmazon();
    }

    @When("Marka Apple seçilir")
    public void markaAppleSecilir() {
        pages.filterApple();
    }

    @When("İlk ürün seçilir")
    public void ilkUrunSecilir() {
        pages.firstProduct();
    }

    @When("Sepete eklenir")
    public void sepeteEklenir() {
        pages.addToCard();
    }

    @Then("Ürünün sepete geldiği kontrol edilir")
    public void urununSepeteGeldigiKontrolEdilir() {
        pages.checkTheCard();
    }


}
