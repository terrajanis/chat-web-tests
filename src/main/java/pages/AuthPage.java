package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    private SelenideElement emailInput = $("input[name=\"email\"]");
    private SelenideElement passwordInput = $("input[name=\"password\"]");
    private SelenideElement submitButton = $("button[type=\"submit\"]");

    public void login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        submitButton.click();
    }
}
