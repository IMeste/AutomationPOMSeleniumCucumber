package pages.marmelab.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DashboardPage extends BasePage {

    private final By dashboardLink = By.cssSelector("a[class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters RaMenuItemLink-root RaMenuItemLink-active css-u1lm3b'] p[class='MuiTypography-root MuiTypography-inherit MuiTypography-noWrap css-1pz6gt0']");

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboardLink);
    }

    public By getByDashboard() {
        return dashboardLink;
    }
}
