package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;
import Util.DriverFactory;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepdefs {

    WebDriver driver = DriverFactory.getDriver();

    HomePage homePage = new HomePage(driver);

    LoginPage loginPage = new LoginPage(driver);
    SignUpPage signUpPage = new SignUpPage(driver);

    @Given("Go to the website of BBC News")
    public void goToTheWebsiteOfBBCNews() {
        homePage.goToWebsite();
    }

    @When("Click one categori")
    public void clickOneCategoriBBC() {
        homePage.clickOneCategory();
    }

    @Then("Click one news")
    public void clickOneNews() {
        homePage.clickOneNews();
    }


    @When("Click the search button")
    public void clickTheSearchButton() {
        homePage.clickSearch();
    }

    @When("Click the search textfield")
    public void clickTheSearchTextfield() {
        homePage.clickSearchTf();
    }

    @When("Write your search")
    public void writeYourSearch() {
        homePage.writeYourSearch();
    }

    @Then("Click the search icon")
    public void clickTheSearchIcon() {
        homePage.clickTheSearchIcon();
    }

    @Given("User at another page")
    public void userAtAnotherPage() {
        homePage.userAtAnotherPage();
    }

    @When("Click the search button at another page")
    public void clickTheSearchButtonAtAnotherPage() {
        homePage.clickTheSearchAP();
    }


    @When("Write your search at another page")
    public void writeYourSearchAtAnotherPage() {
        homePage.writeYourSearchAP();
    }

    @Then("Click the search icon at another page")
    public void clickTheSearchIconAtAnotherPage() {
        homePage.clickTheSearchIconAP();
    }

    @When("Click the category of menu")
    public void clickTheCategoryOfMenu() {
        homePage.clickTheCategoryofMenu();
    }

    @When("Click the subcategory of menu")
    public void clickTheSubcategoryOfMenu() {
        homePage.clickTheSubcategory();
    }

    @Given("Click the news")
    public void clickTheNews() {
        homePage.clickTheNews();
    }

    @When("Click the search textfield at another page")
    public void clickTheSearchTextfieldAtAnotherPage() {
        homePage.clickTheSearchTFAP();
    }

    @Given("Go to the sign up page")
    public void goToTheSignUpPage() {
        signUpPage.goToSignUpPage();
    }

    @When("Click {string} textfield and write email")
    public void clickTextfieldAndWrite(String email) {
        signUpPage.clickAndWriteEmail(email);
    }

    @When("Click continue")
    public void clickContinue() {
        signUpPage.clickContinue();
    }

    @When("Choose Yes, I want Emails")
    public void chooseYesIWantEmails() {
        signUpPage.chooseYes();
    }

    @Then("Click Register")
    public void clickRegister() {
        signUpPage.clickRegister();
    }

    @When("Click {string} textfield and write password")
    public void clickTextfieldAndWritePassword(String password) {
        signUpPage.clickAndWritePassword(password);
    }

    @When("Choose No Thanks")
    public void chooseNoThanks() {
        signUpPage.chooseNo();
    }

    @Then("Check {string} message about password format")
    public void checkMessageAboutFormat(String msg) {
        signUpPage.checkTheMessage(msg);
    }

    @Then("Check {string} message about email format")
    public void checkMessageAboutEmailFormat(String error) {
        signUpPage.checkTheMessage(error);
    }

    @Then("Click Sign In")
    public void clickSignIn() {
        loginPage.clickSignIn();
    }

    @Given("Go to the login page")
    public void goToTheLoginPage() {
        loginPage.goToLoginPage();
    }

    @Then("Check {string} message about wrong password")
    public void checkMessageAboutWrongPassword(String error) {
        loginPage.wrongPasswordMsg(error);
    }

    @When("Click the news in homepage")
    public void clickTheNewsInHomepage() {
        homePage.clickOnePage();
    }

    @Then("Click Save")
    public void clickSave() {
        homePage.clickSaveButton();
    }

    @When("Click Your Account Page")
    public void clickYourAccountPage() {
        homePage.clickYourAccountPage();
    }

    @Then("Click Saved")
    public void clickSaved() {
        homePage.clickSaved();
    }

    @Then("Click Sign Out")
    public void clickSignOut() {
        homePage.clickSignOut();
    }
}

