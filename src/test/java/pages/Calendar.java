package pages;
import static com.codeborne.selenide.Selenide.$;
import static pages.PracticeFormPage.*;

public class Calendar {



    public void setDateofBirth(String year, String month, String day)
    {
        String dday;
        int i = 1;
        if (day.length() == i){
            dday = "0" + day;
        } else {
            dday = day;
        }
        selectDateOfBirth.click();
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dday)).click();
    }
}
