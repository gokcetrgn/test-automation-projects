package Pages;

import Util.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Forms {
    WebDriver driver;
    ElementHelper elementHelper;
    WebDriverWait wait;

    By formsButton = By.cssSelector("div[class='home-body'] div:nth-child(2) div:nth-child(1) div:nth-child(3)");
    By practiceForm = By.cssSelector("div[class='element-list collapse show'] span[class='text']");
    By nameTxt = By.cssSelector("#firstName");
    By surnameTxt = By.cssSelector("#lastName");
    By emailTxt = By.cssSelector("#userEmail");
    By mobile = By.cssSelector("#userNumber");
    By addressTxt = By.cssSelector("#currentAddress");
    By birth = By.cssSelector("#dateOfBirthInput");
    By subjectTxt = By.cssSelector(".subjects-auto-complete__value-container.subjects-auto-complete__value-container--is-multi.css-1hwfws3");
    By cityForm = By.cssSelector("div[class=' css-1wa3eu0-placeholder']");
    By stateForm = By.cssSelector(".css-1uccc91-singleValue");
    By uploadPhoto = By.cssSelector("#uploadPicture");
    JavascriptExecutor js;


    public Forms(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.js = (JavascriptExecutor) driver;
    }

    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void goToForms(String url) {
        driver.get(url);
        scrollToElement(formsButton);
        elementHelper.click(formsButton);

        scrollToElement(practiceForm);
        elementHelper.click(practiceForm);
    }

    public void personalInfo(String name, String surname, String email, String mobilenumber, String address) {
        scrollToElement(nameTxt);
        elementHelper.sendKey(nameTxt, name);

        scrollToElement(surnameTxt);
        elementHelper.sendKey(surnameTxt, surname);

        scrollToElement(emailTxt);
        elementHelper.sendKey(emailTxt, email);

        scrollToElement(mobile);
        elementHelper.sendKey(mobile, mobilenumber);

        scrollToElement(addressTxt);
        elementHelper.sendKey(addressTxt, address);
    }

    public void chooseGenderBirthday(String birthday) {
        By genderClick = By.cssSelector("label[for='gender-radio-2']");
        scrollToElement(genderClick);
        elementHelper.click(genderClick);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Önce gender alanını seç
        scrollToElement(genderClick);
        wait.until(ExpectedConditions.elementToBeClickable(genderClick)).click();

        // Doğum günü alanı DOM’a gelene kadar bekle
        scrollToElement(birth);
        WebElement birthInput = wait.until(ExpectedConditions.presenceOfElementLocated(birth));

        // Alan görünür ve tıklanabilir olana kadar bekle
        wait.until(ExpectedConditions.elementToBeClickable(birthInput));

        // Mevcut tarihi temizle ve yenisini yaz
        birthInput.click();
        birthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        birthInput.sendKeys(Keys.DELETE);
        birthInput.sendKeys(birthday);
        birthInput.sendKeys(Keys.ENTER);

    }

    public void selectPhoto(String photo) {
        scrollToElement(uploadPhoto);
        elementHelper.sendKey(uploadPhoto, photo);
    }

    public void selectSubject(String subject) {
        scrollToElement(subjectTxt);
        elementHelper.sendKey(subjectTxt, subject);
    }

    public void selectHobbies(String hobby) {
        By hobbyLocator = By.xpath("//label[text()='" + hobby + "']");
        scrollToElement(hobbyLocator);
        WebElement hobbyElement = driver.findElement(hobbyLocator);
        if (!hobbyElement.isSelected()) {
            hobbyElement.click();
        }
    }

    public void selectStateCity(String state, String city) {
        scrollToElement(stateForm);
        WebElement stateInput = driver.findElement(stateForm);
        stateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        stateInput.sendKeys(Keys.DELETE);
        elementHelper.sendKey(stateForm, state);
        stateInput.sendKeys(Keys.ENTER);

        scrollToElement(cityForm);
        WebElement cityInput = driver.findElement(cityForm);
        cityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        cityInput.sendKeys(Keys.DELETE);
        elementHelper.sendKey(cityForm, city);
        cityInput.sendKeys(Keys.ENTER);
    }
}
