package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import testData.RandomData;

import java.net.URISyntaxException;

@DisplayName("Проверка функционала заполнения полей и отправки формы 'Practice Form'")
public class HomeworkPracticeForm extends RemoteTestBase {

    RandomData random = new RandomData();


    @Test
    @Tag("demoqa")
    @DisplayName("Проверка отправки формы с заполнением всех полей")
    void fillFormText() throws URISyntaxException {

        practiceFormPage
                .openPracticeForm()
                .checkUrl()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .chooseRandomSex(random.userSex)
                .setNumber(random.number)
                .setRandomDateOfBirth(random.userYearOfBirth,random.userMonthOfBirth, random.userDayOfBirth)
                .setSubject(random.hobbySubject)
                .setImage()
                .setCurrentAdress(random.currentAdress)
                .setRandomAdress(random.userState,random.userCity)
                .submit()
                .assertsModalWindow("Student Name", random.firstName + " " + random.lastName)
                .assertsModalWindow("Student Email", random.email)
                .assertsModalWindow("Gender", random.userSex)
                .assertsModalWindow("Mobile", random.number)
                .assertsModalWindow("Date of Birth", String.format("%s %s,%s", random.userDayOfBirth,random.userMonthOfBirth,random.userYearOfBirth))
                .assertsModalWindow("Subjects", random.hobbySubject)
                .assertsModalWindow("Address", random.currentAdress)
                .assertsModalWindow("State and City", random.userState + " " + random.userCity);

    }
    @Test
    @Tag("demoqa")
    @DisplayName("Проверка отправки формы без заполненных обязательных полей")
    void withoutRequiredFields (){
        practiceFormPage
                .openPracticeForm()
                .checkUrl()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .submit()
                .assertsModalWindowNotExist();
    }
    @Test
    @Tag("demoqa")
    @DisplayName("Проверка отправки формы с заполнением только обязательных полей")
    void onlyRequiredFields (){
        practiceFormPage
                .openPracticeForm()
                .checkUrl()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .chooseRandomSex(random.userSex)
                .setNumber(random.number)
                .submit()
                .assertsModalWindow("Student Name", random.firstName + " " + random.lastName)
                .assertsModalWindow("Gender", random.userSex)
                .assertsModalWindow("Mobile", random.number);
    }
}
