package Pages;

import Util.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    ElementHelper elementHelper;

    WebDriverWait wait;

    By signInButton = By.cssSelector("button[id='submit-button'] span");
    By errorMsg = By.cssSelector("div[class='page page--chameleon'] span span:nth-child(1)");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public void goToLoginPage() {
        driver.get("https://account.bbc.com/auth/identifier/signin?realm=%2F&clientId=Account&ptrt=https%3A%2F%2Fwww.bbc.com%2F&userOrigin=BBCS_BBC&purpose=free&isCasso=false&action=sign-in&redirectUri=https%3A%2F%2Fsession.bbc.com%2Fsession%2Fcallback%3Frealm%3D%2F&service=IdSignInService&nonce=Bc6N5HDa-qcpTZoiIddV-3y6ygyAqyCaP1zI");
    }

    public void clickSignIn() {
        elementHelper.click(signInButton);
    }


    public void wrongPasswordMsg(String error) {
        elementHelper.checkMessage(errorMsg);
    }
}
