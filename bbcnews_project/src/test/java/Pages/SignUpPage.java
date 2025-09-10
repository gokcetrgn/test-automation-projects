package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By emailTextfield = By.cssSelector("#username");
    By continueButton = By.cssSelector("#submit-button");

    By passwordTextfield = By.cssSelector("#password");

    By clickYes = By.cssSelector("#optIn");
    By clickNo = By.cssSelector("#optOut");

    By registerButton = By.cssSelector("#submit-button");

    By errorMsg = By.cssSelector("div[class='page page--chameleon'] span span:nth-child(1)");
    By errorMsgE = By.cssSelector("div[id='registration-email-first'] span span:nth-child(1)");
    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void goToSignUpPage() {
        driver.get("https://account.bbc.com/auth/identifier/signin?realm=%2F&clientId=Account&action=register&ptrt=https%3A%2F%2Fwww.bbc.com%2F&userOrigin=BBCS_BBC&purpose=free&isCasso=false&redirectUri=https%3A%2F%2Fsession.bbc.com%2Fsession%2Fcallback%3Frealm%3D%2F&service=IdRegisterService&nonce=VCwftfGy-dqK0BoRDibMKN57FR9ytogPMHsA");

    }

    public void clickAndWriteEmail(String email) {
        elementHelper.sendKey(emailTextfield,email);
    }

    public void clickContinue() {
        elementHelper.click(continueButton);
    }

    public void clickAndWritePassword(String password) {
        elementHelper.sendKey(passwordTextfield,password);
    }

    public void chooseYes() {
        elementHelper.click(clickYes);
    }

    public void clickRegister() {
        elementHelper.click(registerButton);
    }

    public void chooseNo() {
        elementHelper.click(clickNo);
    }

    public void checkTheMessage(String error) {
        elementHelper.checkMessage(errorMsg);
    }

    public void checkTheMessagePs(String error) {
        elementHelper.checkMessage(errorMsgE);
    }
}
