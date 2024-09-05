import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormText(){
        open("/text-box");


        $x("//input[@id = 'userName']").setValue("Alex Egorov");//id можно заменить #,class можно заменить точкой (.)
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("some address");
        $("#permanentAddress").setValue("another address2");
        $("#submit").click();

        $("#output").shouldHave(text("Alex Egorov"),text("alex@egorov.com"),
                text("some address"),text("another address2"));

    }
}
