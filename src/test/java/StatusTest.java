import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.DashboardsPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.switchTo;

@Feature("Dashboards")
public class StatusTest extends BaseTest {

    @Description("Set status and check it on the dashboard")
    @Test
    public void setStatus() {
        openMainPage(BASE_URL);
        new AuthPage().login(EMAIL, PASSWORD);
        DashboardsPage dashboardsPage = new DashboardsPage();
        dashboardsPage.setStatus("Online");
        String dashboardName = dashboardsPage.getDashboardName().toLowerCase();
        dashboardsPage.goToDashboard();
        switchTo().window(1);
        new MainPage().checkStatus(".Online");
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertTrue(url.contains(dashboardName), "Dashboard doesn't open");
    }
}
