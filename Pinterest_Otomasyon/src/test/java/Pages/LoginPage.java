package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By login = By.cssSelector(".B1n.tg7.fxm.wm0");
    By emailTextfield = By.cssSelector("#email");
    By passwordTextfield = By.cssSelector("#password");
    By oturumAcButton= By.cssSelector("[data-test-id=\"registerFormSubmitButton\"]");
    By emailError = By.cssSelector(".email-error");
    By passwordError = By.cssSelector(".sOY.zDA.IZT.eSP.dyH.LTB.bB3.t5G");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void loginPage(){
        driver.get("https://tr.pinterest.com/");
    }

    public void login(String email, String password){
        elementHelper.click(login);

        elementHelper.click(emailTextfield);
        elementHelper.sendKey(emailTextfield, email);

        elementHelper.click(passwordTextfield);
        elementHelper.sendKey(passwordTextfield, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(oturumAcButton));
        elementHelper.click(oturumAcButton);


    }

    public void controlPage() {
        boolean isEmailFormVisible = elementHelper.findElement(emailTextfield).isDisplayed();
        Assert.assertTrue(isEmailFormVisible, "Login formu görünmüyor!");
    }


    public void clickEmail() {
        elementHelper.click(emailTextfield);
    }

    public void clickPassword() {

        elementHelper.click(passwordTextfield);

    }

    public void checkErrorAboutEmail(String error) {

        elementHelper.checkMessage(emailError);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.controlMessage(emailError, error);
    }
    public void checkErrorAboutPassword(String error){
        elementHelper.checkMessage(passwordError);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        elementHelper.controlMessage(passwordError, error);
    }


    public void logWithWrongEmail(String email) {
        elementHelper.click(emailTextfield);
        elementHelper.sendKey(emailTextfield, email);
        elementHelper.click(oturumAcButton);
    }

    public void logWithoutEmail() {
        elementHelper.click(oturumAcButton);
    }


}
