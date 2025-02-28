package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {

    private final SelenideElement containModalDialog = $(".table-responsive");

    public void checkResult (String key, String value) {
        containModalDialog.$(byText(key)).parent().shouldHave(text(value));
    }
}
