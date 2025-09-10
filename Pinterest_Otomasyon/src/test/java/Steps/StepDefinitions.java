package Steps;

import Pages.*;
import Util.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(StepDefinitions.class);
    WebDriver driver = DriverFactory.getDriver();
    DiscoverPage discoverPage = new DiscoverPage(driver);
    LandingPage landingPage = new LandingPage(driver);
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);
    PicturePage picturePage = new PicturePage(driver);



    @Given("User is on Pinterest homepage")
    public void goToTheWebsiteOfPinterest() {
        landingPage.goToPinterest();
    }


    @Given("User clicks on the Login button")
    public void goToLoginPage() {
        landingPage.goToLoginPage();
    }

    @Given("User clicks on the Sign Up button")
    public void goToSignUpPage() {
        landingPage.goToSignUpPage();
    }

    @Then("Homepage should be displayed")
    public void homepageShouldBeDisplayed() {
        landingPage.controlPage();
    }

    @Then("Login page should be displayed")
    public void loginPageShouldBeDisplayed() {
        loginPage.controlPage();
    }

    @Then("Sign Up page should be displayed")
    public void signUpPageShouldBeDisplayed() {
        signUpPage.controlPage();
    }


    @When("User clicks on the Discover button from header")
    public void userClicksOnTheDiscoverButtonFromHeader() {
        landingPage.clickButtonFromHeader();
    }

    @Then("Discover page should be displayed")
    public void discoverPageShouldBeDisplayed() {
        discoverPage.controlPage();
    }


    @Then("User should be registered successfully")
    public void checkIfYouLogin() {
        homePage.checkPage();
    }

    @Then("User clicks on the email textfield")
    public void userClicksOnTheEmailTextfield() {
        loginPage.clickEmail();
    }

    @Then("User clicks on the password textfield")
    public void userClicksOnThePasswordTextfield() {
        loginPage.clickPassword();
    }

    @Then("Check the {string} message about email")
    public void checkTheMessage(String error) {
        loginPage.checkErrorAboutEmail(error);
    }

    @Then("Check the {string} message about password")
    public void checkTheMessageAboutPassword(String error) {
        loginPage.checkErrorAboutPassword(error);
    }

    @Then("Check the {string} message about wrong format of email")
    public void checkTheMessageAboutWrongFormatOfEmail(String error) {
       loginPage.checkErrorAboutEmail(error);
    }
 // hata kontrolü test edilemedi devam edilecek...
    @Then("Check the {string} message about email if dont have in database")
    public void checkTheMessageAboutEmailIfDontHaveInDatabase(String error) {
        loginPage.checkErrorAboutEmail(error);
    }

    @Then("Check the {string} message after three try")
    public void checkTheMessageAfterTry(String error) {

    }

    @Given("User is on the Login page")
    public void userIsOnTheLoginPage() {
        loginPage.loginPage();
    }

    @When("User tries to login without entering email")
    public void userTriesToLoginWithoutEnteringEmail() {
        loginPage.logWithoutEmail();
    }

    @When("User logs in with {string}")
    public void userLogsInWithEmail(String email) {
        loginPage.logWithWrongEmail(email);
    }

    @When("User logs in with {string} and {string}")
    public void userLogs(String email, String password) {
        loginPage.login(email, password);
    }


    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        homePage.checkPage();
    }

    @Given("User is on the Sign Up page")
    public void userIsOnTheSignUpPage() {
        signUpPage.signupPage();
    }

    @When("User signs up with {string}, {string}, {string}, {string}, gender, country")
    public void userSignsUpWithGenderCountry(String email, String password, String birthday, String name) {
        signUpPage.signUp(email, password,birthday,name);
    }

    @And("selects preferred categories and interests")
    public void selectsPreferredCategoriesAndInterests() {
        signUpPage.selectPreferredCatInt();
    }

    @Given("User is on the HomePage")
    public void userIsOnTheHomePage() {
        homePage.loginControl();
    }

    @When("the user clicks on a photo")
    public void theUserClicksOnAPhoto() {
        homePage.clickthePhoto();
    }

    @Then("the heart icon should be visible")
    public void theHeartIconShouldBeVisible() {
        picturePage.heartIcon();
    }

    @Then("the heart icon should be clicked")
    public void theHeartIconShouldBeClicked() {
        picturePage.liked();
    }

    @Then("user clicked share button and copy link")
    public void userClickedShareButtonAndCopyLink() {
        picturePage.share();
    }

    @Then("user clicked save button")
    public void userClickedSaveButton() {
        picturePage.saved();
    }

    @Then("user download the photo")
    public void userDownloadThePhoto() {
        picturePage.photoDownload();
    }

    @Then("user clicks comment icon and writes {string} about photo")
    public void userClicksCommentIconAndWritesAboutPhoto(String comment) {
        picturePage.commentIcon(comment);
    }
}

