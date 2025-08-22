package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormPage {


    public static SelenideElement firstNameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");
    public static SelenideElement emailInput = $("#userEmail");
    public static SelenideElement maleCheckbox = $(byText("Male"));
    public static SelenideElement sexCheckbox = $("#genterWrapper");
    public static SelenideElement phoneNumber = $("#userNumber");
    public static SelenideElement selectDateOfBirth = $("#dateOfBirthInput");
    public static SelenideElement monthSelect = $(".react-datepicker__month-select");
    public static SelenideElement yearSelect = $(".react-datepicker__year-select");
    //public static SelenideElement daySelect = $(".react-datepicker__day--026");
    public static SelenideElement subjectForm = $("#subjectsContainer");
    public static SelenideElement subjectSelect = $("#subjectsInput");
    public static SelenideElement hobbySportSelect = $(byText("Sports"));
    public static SelenideElement hobbyReadingSelect = $(byText("Reading"));
    public static SelenideElement hobbyMusicSelect = $(byText("Music"));
    public static SelenideElement imageUpload = $("#uploadPicture");
    public static SelenideElement adressField = $("#currentAddress");
    public static SelenideElement openStateSelect = $("#state");
    public static SelenideElement openCitySelect = $("#city");
    public static SelenideElement stateCitySelect = $("#stateCity-wrapper");
    public static SelenideElement submitButton = $("#submit");
    public static SelenideElement modalDialog = $(".modal-dialog");
    public static SelenideElement adsWindow = $("img#close_button_svg");
    public static SelenideElement adWindow = $("#fixedban");
    public static SelenideElement titleModalDialog = $("#example-modal-sizes-title-lg");
    //public static SelenideElement containModalDialog = $(".table-responsive");
    ModalWindow modalWindow = new ModalWindow();
    Calendar dateOfBirth = new Calendar();

    @Step("Ввести имя")
    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        checkAdsWindowAndCloseIfExist();
        return this;
    }

    @Step("Ввести фамилию")
    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Ввести почту")
    public PracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        checkAdsWindowAndCloseIfExist();
        return this;
    }

    public PracticeFormPage chooseMaleSex() {
        maleCheckbox.click();
        return this;
    }

    @Step("Выбрать пол")
    public PracticeFormPage chooseRandomSex(String gender) {
        {
            sexCheckbox.$(byText(gender)).click();
            return this;
        }
    }

    @Step("Ввести номер телефона")
    public PracticeFormPage setNumber(String number) {
        phoneNumber.setValue(number);
        checkAdsWindowAndCloseIfExist();
        return this;
    }

/*    public PracticeFormPage setDateOfBirth(String month, String year) {
        selectDateOfBirth.click();
        monthSelect.selectOption(month);//"June"
        yearSelect.selectOption(year);//"1994"
        daySelect.click();
        return this;
    }*/

    @Step("Ввести дату рождения")
    public PracticeFormPage setRandomDateOfBirth(String year, String month, String day)
{
    dateOfBirth.setDateofBirth(year,month,day);
    return this;
}

    public PracticeFormPage setHobby() {
        subjectSelect.setValue("English").pressEnter();
        hobbySportSelect.click();
        hobbyReadingSelect.click();
        hobbyMusicSelect.click();
        return this;
    }
    @Step("Ввести предмет")
    public PracticeFormPage setSubject(String subject)
    {
        subjectForm.click();
        subjectSelect.setValue(subject).pressEnter();
        return this;
    }

    @Step("Загрузить фото")
    public PracticeFormPage setImage() {
        imageUpload.uploadFromClasspath("img/1.png");
        checkAdsWindowAndCloseIfExist();
        return this;
    }

    @Step("Ввести адрес")
    public PracticeFormPage setCurrentAdress(String currentAdress) {
        adressField.setValue(currentAdress);
        return this;
    }


    public PracticeFormPage setAdress() {
        openStateSelect.click();
        stateCitySelect.$(byText("Haryana")).click();
        openCitySelect.click();
        stateCitySelect.$(byText("Karnal")).click();
        return this;
    }

    @Step("Выбрать штат и город")
    public PracticeFormPage setRandomAdress(String state, String city) {
        openStateSelect.click();
        stateCitySelect.$(byText(state)).click();
        openCitySelect.click();
        stateCitySelect.$(byText(city)).click();
        return this;
    }

    @Step("Нажать на кнопку подтвердить")
    public PracticeFormPage submit() {
        checkAdsWindowAndCloseIfExist();
        submitButton.click();
        return this;
    }

    @Step("Проверка отображения введенного на форме поля в модальном окне")
    public PracticeFormPage assertsModalWindow(String key, String value) {
        modalDialog.should(appear);
        titleModalDialog.shouldHave(text("Thanks for submitting the form"));
        modalWindow.checkResult(key,value);
        return this;
    }
    @Step("Проверка отсутствия модального окна")
    public PracticeFormPage assertsModalWindowNotExist() {
        modalDialog.shouldNot(appear);
//        titleModalDialog.shouldNotHave(text("Thanks for submitting the form"));
        return this;
    }
    @Step("Открыть страницу 'Practice Form'")
    public PracticeFormPage openPracticeForm() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#adplus-anchor').remove()");
        return this;
    }
    @Step("Проверка наличия рекламного баннера и закрытия его")
    public PracticeFormPage checkAdsWindowAndCloseIfExist() {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#adplus-anchor').remove()");;
        return this;
    }
    @Step("Проверка нахождения на нужной странице")
    public PracticeFormPage checkUrl (){
        String currentUrl = WebDriverRunner.url();
        assertEquals("https://demoqa.com/automation-practice-form", currentUrl);
        return this;
    }

}
