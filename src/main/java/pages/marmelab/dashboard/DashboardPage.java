package pages.marmelab.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class DashboardPage extends BasePage {

    private final By dashboardLink = By.cssSelector("a[class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters RaMenuItemLink-root RaMenuItemLink-active css-u1lm3b'] p[class='MuiTypography-root MuiTypography-inherit MuiTypography-noWrap css-1pz6gt0']");
    private final By menuCustomers = By.xpath("//p[@class='MuiTypography-root MuiTypography-inherit MuiTypography-noWrap css-1pz6gt0'][normalize-space()='Customers']");

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public boolean isDashboardDisplayed() {
        return isElementVisible(dashboardLink);
    }

    public By getByDashboard() {
        return dashboardLink;
    }

    public void clickMenuCustomers() {
        click(menuCustomers, "Menu Customers");
    }
}
