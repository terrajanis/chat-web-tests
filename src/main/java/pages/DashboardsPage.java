package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DashboardsPage {

    private SelenideElement statusDropDown = $("svg.MuiSvgIcon-root.MuiSvgIcon-fontSizeInherit");
    private SelenideElement dashboard = $(".jss15");

    public void setStatus(String statusText) {
        statusDropDown.click();
        $(byText(statusText)).click();
    }

    public String getDashboardName() {
        return dashboard.getText();
    }

    public void goToDashboard() {
        dashboard.click();
    }
}
