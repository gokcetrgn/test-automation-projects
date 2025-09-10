package StepDefinitions;

import Pages.Forms;
import Util.DriverFactory;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FormsSteps {
    WebDriver driver = DriverFactory.getDriver();
    Forms forms = new Forms(driver);

    @Step("User is in Demoqa forms page <url>")
    public void formsPage(String url) {
        forms.goToForms(url);
    }

    @Step("User writes <name>, <surname>, <email>, <mobilenumber>, <address> in form")
    public void personalInformations(String name, String surname, String email, String mobilenumber, String address) {
        forms.personalInfo(name, surname, email, mobilenumber, address);
    }

    @Step("User chooses gender and <birthday> in form")
    public void chooseGenderBirthday(String birthday) {
        forms.chooseGenderBirthday(birthday);
    }

    @Step("User writes <subject> in subject form")
    public void selectSubject(String subject) {
        forms.selectSubject(subject);
    }

    @Step("User selects a <photo> from his computer")
    public void selectsPhoto(String photo) {
        forms.selectPhoto(photo);
    }


    @Step("User selects hobby <table>")
    public void selectHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            forms.selectHobbies(hobby); // Yukarıdaki metodu tekrar kullanıyor
        }
    }

    @Step("User selects <state> and <city> in page")
    public void selectStateCity(String state, String city) {
        forms.selectStateCity(state,city);
    }


}
