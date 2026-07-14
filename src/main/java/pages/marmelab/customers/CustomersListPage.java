package pages.marmelab.customers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.TableReader;

public class CustomersListPage extends BasePage {

    private final By header = By.cssSelector(".list-page.css-2d9zsf");
    private final By buttonCreate = By.cssSelector("a[aria-label='Create']");
    private final By inputSearch = By.cssSelector("input[placeholder='Search']");
    private final By emptyState = By.cssSelector("p[class='MuiTypography-root MuiTypography-body2 css-bxmwoh']");
    private final By tableHead = By.cssSelector(".MuiTableHead-root.RaDataTable-thead");
    private final By tableBody = By.cssSelector("tbody.MuiTableBody-root.RaDataTable-tbody");
    private final By buttonDelete = By.cssSelector("button[aria-label='Delete']");

    private final TableReader tableReader;

    public CustomersListPage(WebDriver driver) {
        super(driver);
        this.tableReader = new TableReader(driver);
    }

    public boolean isHeaderDisplayed() {
        return isElementVisible(header);
    }

    public By getByHeader() {
        return header;
    }

    public void clickCreateCustomer() {
        click(buttonCreate, "Botón Create Customer");
    }

    public void typeSearchFilter(String text) {
        type(inputSearch, text, "Filtro de búsqueda");
    }

    public boolean isEmptyStateDisplayed() {
        return isElementVisible(emptyState);
    }

    public By getByEmptyState() {
        return emptyState;
    }

    public String getTextFromTableHead(int column){
        return tableReader.getHeaderValue(tableHead, column);
    }

    public String getTextFromTableBody(int row, int column){
        return tableReader.getBodyCellValue(tableBody, row, column);
    }

    public void pressEnter(){
        pressKeyInElement(inputSearch, Keys.ENTER, "Press Enter in Search");
    }

    public void editCustomer(int index){
        tableReader.clickBodyCell(tableBody, index, 1);
    }

    public void selectCustomer(int index){
        tableReader.clickBodyCell(tableBody, index, 0);
    }

    public void clickDeleteCustomer(){
        click(buttonDelete, "Botón Delete Customer");
    }

}