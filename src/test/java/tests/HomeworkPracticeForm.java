package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.Calendar;
import pages.PracticeFormPage;
import testData.RandomData;

import java.util.Locale;

public class HomeworkPracticeForm extends TestBase {

    RandomData random = new RandomData();


    @Test
    void fillFormText() {

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
