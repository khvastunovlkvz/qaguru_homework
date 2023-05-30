package qaguru.homework1.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class FormTest extends BaseTest {
    private final String
            NAME_PICTURE = "milaya-mordashka-kotika.jpg",
            CURRENT_ADDRESS = "ТАМБОВСКАЯ ОБЛАСТЬ УВАРОВСКИЙ Р-Н ГРИГОРЬЕВКА 2-Я";

    @CsvFileSource(resources = "/testData.csv")
    @ParameterizedTest(name = "Заполнение формы разными данными")
    public void formTest(
       String firstName,
       String lastName,
       String email,
       String gender,
       String number,
       String day,
       String month,
       String year,
       String subject,
       String hobbies,
       String state,
       String city
    )
    {
        String FIRST_AND_LAST_NAME = firstName + " " + lastName;
        String DATE_OF_BIRTH = day + " " + month + "," + year;
        String STATE_AND_CITY = state + " " + city;

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobileNumber(number)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture(NAME_PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.resultsModal
                .verifyResultsModalAppears()
                .verifyResult("Student Name", FIRST_AND_LAST_NAME)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", DATE_OF_BIRTH)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", NAME_PICTURE)
                .verifyResult("Address", CURRENT_ADDRESS)
                .verifyResult("State and City", STATE_AND_CITY);
    }
}
