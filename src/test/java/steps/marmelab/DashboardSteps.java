package steps.marmelab;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.marmelab.customers.CustomersListPage;
import pages.marmelab.dashboard.DashboardPage;
import support.ActionsCommon;
import support.CustomAssertions;

public class DashboardSteps {

    CustomersListPage customersListPage;
    DashboardPage dashboardPage;

    public DashboardSteps () {
        WebDriver driver = DriverFactory.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        this.customersListPage = new CustomersListPage(driver);
    }

    @When("Click sobre el menú de customers")
    public void click_sobre_el_menu_de_customers() {
        dashboardPage.clickMenuCustomers();
        CustomAssertions.assertElementVisible(
                customersListPage.isHeaderDisplayed(),
                customersListPage.getByHeader(),
                "Customers List Header"
        );
    }
}
