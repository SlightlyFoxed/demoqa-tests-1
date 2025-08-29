package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.PracticeFormPage;

import java.util.Map;

public class RemoteTestBase {

    public PracticeFormPage practiceFormPage = new PracticeFormPage();
    static String selenoidUserLogin = System.getProperty("selenoidUserLogin");
    static String selenoidUserPassword = System.getProperty("selenoidUserPassword");
    static String selenoidRemoteServerUrl = System.getProperty(
            "selenoidRemoteServerUrl");
    static String browser = System.getProperty("browser");
    static String browserVersion = System.getProperty("browserVersion");
    static String browserSize = System.getProperty("browserResolution");

    public static void setupRemote() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://" +
                selenoidUserLogin + ":" + selenoidUserPassword +"@" + selenoidRemoteServerUrl + "/wd/hub";
    }


    @BeforeAll
    static void beforeAll() {
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        setupRemote();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
