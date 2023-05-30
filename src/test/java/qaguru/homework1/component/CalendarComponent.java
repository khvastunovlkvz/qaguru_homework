package qaguru.homework1.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public CalendarComponent setMonth(String month){
        $(".react-datepicker__month-select")
                .selectOption(month);

        return this;
    }

    public CalendarComponent setYear(String year){
        $(".react-datepicker__year-select")
                .selectOption(year);

        return this;
    }

    public void setDay(String day){
                $(".react-datepicker__day--0"
                + day +
                ":not(.react-datepicker__day--outside-month)")
                .click();
    }


}
