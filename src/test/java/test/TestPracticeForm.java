package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulFillTest() {
        String firstName = "Julia";
        String lastName = "Madam";
        String userEmail = "Madam@example.com";
        String userNumber = "1234567890";
        String gender = "Female";
        String birthDay = "13";
        String birthMonth = "August";
        String birthYear = "1985";
        String birthCheck ="13 August,1985";
        String subjects = "Biology";
        String hobby = "Music";
        String picture = "1.jpg";
        String address = "SPB";
        String state = "Haryana";
        String city = "Karnal";



        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(String.format("[aria-label='Choose Tuesday, %s %sth, %s']", birthMonth, birthDay, birthYear)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("./src/test/java/../resources/"+ picture));
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(byText(firstName + " " + lastName)).shouldBe(visible);
        $(".modal-body").$(byText(gender)).shouldHave(text(gender));
        $(byText(userNumber)).shouldBe(visible);
        $(byText(userEmail)).shouldBe(visible);
        $(byText(birthCheck)).shouldBe(visible);
        $(byText(subjects)).shouldBe(visible);
        $(byText(hobby)).shouldBe(visible);
        $(byText(picture)).shouldBe(visible);
        $(byText(address)).shouldBe(visible);
        $(byText(state+" "+city)).shouldBe(visible);

    }


}
