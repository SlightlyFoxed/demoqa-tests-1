package testData;

import com.github.javafaker.Faker;

import java.util.Locale;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;

public class RandomData {
    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String number = faker.phoneNumber().subscriberNumber(10);
    public String userSex = getRandomGender();
    public String hobbySubject = getRandomSubjects();
    public String currentAdress = faker.address().city();
    public String userState = getRandomState();
    public String userCity = getRandomCity();
    public String userMonthOfBirth = getRandomMonth();
    public String userYearOfBirth = String.format("%s", faker.number().numberBetween(1980,2020));
    public String userDayOfBirth = String.format("%s",faker.number().numberBetween(1,28));



    public String getRandomGender()
    {
        userSex = faker.options().option("Male","Female","Other");
        return userSex;
    }

    public String getRandomSubjects()
    {
        hobbySubject =faker.options().option("English", "Computer Science","Biology");
        return hobbySubject;
    }
    public String getRandomState()
    {
        userState = faker.options().option("NCR","Uttar Pradesh","Haryana", "Rajasthan");
        return userState;
    }
    public String getRandomCity()
    {

        if (userState.equals( "NCR"))
        {
            userCity = faker.options().option("Delhi","Gurgaon","Noida");
        }
        if (userState.equals("Uttar Pradesh"))
        {
            userCity = faker.options().option("Agra","Lucknow","Merrut");
        }
        if (userState.equals("Haryana"))
        {
            userCity = faker.options().option("Karnal","Panipat");
        }
        if (userState.equals("Rajasthan"))
        {
            userCity = faker.options().option("Jaipur","Jaiselmer");
        }

        return userCity;
    }
    public String getRandomMonth () {
        userMonthOfBirth =faker.options().option("December","January","February","March","April","May","June","July","August","September","October","November");
        return userMonthOfBirth;
    }

}
