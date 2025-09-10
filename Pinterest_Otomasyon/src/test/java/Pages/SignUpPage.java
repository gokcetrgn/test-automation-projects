package Pages;

import Util.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignUpPage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By birthDate = By.cssSelector("#birthdate");
    By signupButton = By.cssSelector("[data-test-id=\"simple-signup-button\"]");
    By emailTextfield = By.cssSelector("[data-test-id=\"emailInputField\"]");
    By passwordTextfield = By.cssSelector("[data-test-id=\"passwordInputField\"]");
    By devamEtInNamePage = By.cssSelector("[data-test-id=\"nux-welcome-next-btn\"]\n");
    By devamEtButton = By.xpath("//div[@class='B1n tg7 fxm xl9 stq']");
    By name = By.cssSelector("#nux-name-textfield");
    By womanGender = By.cssSelector(".X8m.tg7.IZT.fxm.wm0");
    By selectOneCategory = By.cssSelector(".MIw.QLY.Rym.ho-.ojN.p6V.zI7");
    By selectDevam = By.cssSelector("[data-test-id=\"skip-or-continue-button\"]\n");
    By buttonInCountry = By.cssSelector(".RCK.BG7.S9z.Il7.F10.gn8.CCY");


    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public void controlPage() {
        //String currentUrl = driver.getCurrentUrl();
        // Assert.assertTrue(currentUrl.contains("uye-ol"),
           //     "Beklenen üye ol sayfası açılmadı. Şu anki URL: " + currentUrl);

       // bir element ile kontrol
        boolean isBirthDateFormVisible = elementHelper.findElement(birthDate).isDisplayed();
        Assert.assertTrue(isBirthDateFormVisible, "Sign Up formu görünmüyor!");
    }

    public void signUp(String email, String password, String birthday,String nameTxt){
        elementHelper.click(emailTextfield);
        elementHelper.sendKey(emailTextfield, email);

        elementHelper.click(passwordTextfield);
        elementHelper.sendKey(passwordTextfield, password);

        WebElement devamEtBtn = driver.findElement(devamEtButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", devamEtBtn);
        elementHelper.click(devamEtButton);

        elementHelper.click(birthDate);
        elementHelper.sendKey(birthDate, birthday);

        WebElement nameTextfield = elementHelper.findElement(name);
        nameTextfield.sendKeys(Keys.CONTROL + "a");  // tümünü seç
        nameTextfield.sendKeys(Keys.DELETE);         // sil
        nameTextfield.sendKeys(nameTxt);

        elementHelper.click(devamEtInNamePage);

        elementHelper.click(womanGender);

        elementHelper.click(buttonInCountry);
    }


    public void selectPreferredCatInt() {


        int select = 3;
        for (int i = 1; i <= select; i++) {
            WebElement pin = driver.findElement(By.xpath("(//div[@class='MIw QLY Rym ojN p6V sLG zI7'])["+ i + "]"));
            pin.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        elementHelper.click(selectDevam);

        elementHelper.click(selectOneCategory);
        elementHelper.click(selectDevam);


    }


    public void signupPage() {
        driver.get("https://tr.pinterest.com/");
        elementHelper.click(signupButton);
    }
}
