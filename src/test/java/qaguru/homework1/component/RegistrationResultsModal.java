package qaguru.homework1.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private final String title = "Thanks for submitting the form";

    public RegistrationResultsModal verifyResultsModalAppears(){
        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text(title));

        return this;
    }

    public RegistrationResultsModal verifyResult(String key, String value){
        $($(".table-responsive"))
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}
