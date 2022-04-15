package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public void checkStatus(String status) {
        $(status).shouldBe(Condition.visible);
    }
}
