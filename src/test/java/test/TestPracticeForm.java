package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterAll;
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

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("Madam@example.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1985");
        $("[aria-label='Choose Tuesday, August 13th, 1985']").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("SPB");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(byText(firstName + " " + lastName)).shouldBe(visible);
        $(".modal-content").shouldHave(text("Madam@example.com"),
                text("Female"),
                text("1234567890"),
                text("13 August,1985"),
                text("Biology, Physics"),
                text("Sports, Reading, Music"),
                text("1.jpg"),
                text("SPB"),
                text("Haryana"),
                text("Karnal"));
        $("#closeLargeModal").click();
    }


}
