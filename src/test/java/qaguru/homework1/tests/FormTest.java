package qaguru.homework1.tests;

import org.junit.jupiter.api.Test;

public class FormTest extends BaseTest {
    private final String
            FIRST_NAME = "Alex",
            LAST_NAME = "Khvastunov",
            FIRST_AND_LAST_NAME = FIRST_NAME + " " + LAST_NAME,
            EMAIL = "ahvastunov@bk.ru",
            GENDER = "Male",
            NUMBER = "9290088554",
            DAY = "26",
            MONTH = "May",
            YEAR = "1998",
            DATE_OF_BIRTH = DAY + " " + MONTH + "," + YEAR,
            SUBJECT = "English",
            HOBBIES = "Sports",
            NAME_PICTURE = "milaya-mordashka-kotika.jpg",
            CURRENT_ADDRESS = "ТАМБОВСКАЯ ОБЛАСТЬ УВАРОВСКИЙ Р-Н ГРИГОРЬЕВКА 2-Я",
            STATE = "NCR",
            CITY = "Delhi",
            STATE_AND_CITY = STATE + " " + CITY;

    @Test
    public void formTest(){
        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setGender(GENDER)
                .setMobileNumber(NUMBER)
                .setDateOfBirth(DAY, MONTH, YEAR)
                .setSubject(SUBJECT)
                .setHobbies(HOBBIES)
                .uploadPicture(NAME_PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .pressSubmit();

        registrationPage.resultsModal
                .verifyResultsModalAppears()
                .verifyResult("Student Name", FIRST_AND_LAST_NAME)
                .verifyResult("Student Email", EMAIL)
                .verifyResult("Gender", GENDER)
                .verifyResult("Mobile", NUMBER)
                .verifyResult("Date of Birth", DATE_OF_BIRTH)
                .verifyResult("Subjects", SUBJECT)
                .verifyResult("Hobbies", HOBBIES)
                .verifyResult("Picture", NAME_PICTURE)
                .verifyResult("Address", CURRENT_ADDRESS)
                .verifyResult("State and City", STATE_AND_CITY);

        System.out.println();
    }


}
