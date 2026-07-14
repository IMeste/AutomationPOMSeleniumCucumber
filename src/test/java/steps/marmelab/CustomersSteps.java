package steps.marmelab;

import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.marmelab.customers.CustomerCreatePage;
import pages.marmelab.customers.CustomerEditPage;
import pages.marmelab.customers.CustomersListPage;
import support.CustomAssertions;
import utils.DateUtils;

public class CustomersSteps {

    private final CustomersListPage customersListPage;
    private final CustomerCreatePage customerCreatePage;
    private final CustomerEditPage customerEditPage;

    public CustomersSteps() {
        WebDriver driver = DriverFactory.getDriver();
        this.customersListPage = new CustomersListPage(driver);
        this.customerCreatePage = new CustomerCreatePage(driver);
        this.customerEditPage = new CustomerEditPage(driver);
    }

    @When("Agrego un customer")
    public void agrego_un_customer() {
        customersListPage.clickCreateCustomer();
    }

    @Then("Se visualiza la cabecera de creación de customers")
    public void se_visualiza_la_cabecera_de_creacion_de_customers() {
        CustomAssertions.assertElementVisible(
                customerCreatePage.isHeaderDisplayed(),
                customerCreatePage.getByHeader(),
                "Customer Create Header"
        );
    }

    @When("Ingreso first name {string}")
    public void ingreso_first_name(String firstName) {
        customerCreatePage.typeFirstName(firstName);
    }

    @When("Ingreso last name {string}")
    public void ingreso_last_name(String lastName) {
        customerCreatePage.typeLastName(lastName);
    }

    @When("Ingreso email {string}")
    public void ingreso_email(String email) {
        customerCreatePage.typeEmail(email);
    }

    @When("Ingreso birthday {string}")
    public void ingreso_birthday(String birthday) {
        customerCreatePage.typeBirthday(birthday);
    }

    @When("Ingreso address {string}")
    public void ingreso_address(String address) {
        customerCreatePage.typeAddress(address);
    }

    @When("Ingreso city {string}")
    public void ingreso_city(String city) {
        customerCreatePage.typeCity(city);
    }

    @When("Ingreso state {string}")
    public void ingreso_state(String state) {
        customerCreatePage.typeState(state);
    }

    @When("Ingreso zipcode {string}")
    public void ingreso_zipcode(String zipcode) {
        customerCreatePage.typeZipcode(zipcode);
    }

    @When("Ingreso password customer {string}")
    public void ingreso_password_customer(String password) {
        customerCreatePage.typePassword(password);
    }

    @When("Ingreso confirm password customer {string}")
    public void ingreso_confirm_password_customer(String confirmPassword) {
        customerCreatePage.typeConfirmPassword(confirmPassword);
    }

    @When("Click en el botón SAVE customer")
    public void click_en_el_boton_save_customer() {
        CustomAssertions.assertElementVisible(
                customerCreatePage.isButtonSaveDisplayed(),
                customerCreatePage.getButtonSave(),
                "Create Customer Button Save"
        );
        customerCreatePage.clickSave();
    }

    @Then("Se visualiza el historial del customer recien creado")
    public void se_visualiza_el_historial_del_customer_recien_creado() {
        CustomAssertions.assertElementVisible(
                customerCreatePage.isLabelFirstSeenDisplayed(),
                customerCreatePage.getByLabelFirstSeen(),
                "First Seen Label");
        CustomAssertions.assertEqualsText(
                DateUtils.getCurrentDate("dd-MM-yyyy"),
                customerCreatePage.getByLabelFirstSeen(),
                customerCreatePage.getTextLabelFirstSeen(),
                "First Seen Date");
        CustomAssertions.assertElementVisible(
                customerCreatePage.isLabelLastSeenDisplayed(),
                customerCreatePage.getByLabelLastSeen(),
                "Last Seen Label");
        CustomAssertions.assertEqualsText(
                DateUtils.getCurrentDate("dd-MM-yyyy"),
                customerCreatePage.getByLabelLastSeen(),
                customerCreatePage.getTextLabelLastSeen(),
                "Last Seen Date");
    }

    @And("Se realiza una busqueda del customer {string}")
    public void se_realiza_una_busqueda_del_customer(String customerName) {
        customersListPage.typeSearchFilter(customerName);
        customersListPage.pressEnter();
    }

    @Then("Se validan las columnas de la tabla de resultados")
    public void se_validan_las_columnas_de_la_tabla() {
        CustomAssertions.assertEqualsText("Name", customersListPage.getTextFromTableHead(1), "Column Name");
        CustomAssertions.assertEqualsText("Last seen", customersListPage.getTextFromTableHead(2), "Column Last seen");
        CustomAssertions.assertEqualsText("Orders", customersListPage.getTextFromTableHead(3), "Column Orders");
        CustomAssertions.assertEqualsText("Total spent", customersListPage.getTextFromTableHead(4), "Column Total spent");
        CustomAssertions.assertEqualsText("Latest purchase", customersListPage.getTextFromTableHead(5), "Column Latest purchase");
        CustomAssertions.assertEqualsText("News.", customersListPage.getTextFromTableHead(6), "Column News");
        CustomAssertions.assertEqualsText("Segments", customersListPage.getTextFromTableHead(7), "Column Segments");
    }

    @Then("Se valida el customer recien creado")
    public void se_valida_el_customer_recien_creado() {
        CustomAssertions.assertEqualsText("Q\nQA Automation", customersListPage.getTextFromTableBody(0, 1), "Value Name");
        CustomAssertions.assertEqualsText(DateUtils.getCurrentDate("dd-MM-yyyy"), customersListPage.getTextFromTableBody(0, 2), "Value Last Seen");
        CustomAssertions.assertEqualsText("0", customersListPage.getTextFromTableBody(0, 3), "Value Orders");
        CustomAssertions.assertEqualsText("US$0,00", customersListPage.getTextFromTableBody(0, 4), "Value Total spent");
        CustomAssertions.assertContainsText(DateUtils.getCurrentDate("dd-MM-yyyy"), customersListPage.getTextFromTableBody(0, 5), "Value Latest purchase");
        CustomAssertions.assertEqualsText("No", customersListPage.getTextFromTableBody(0, 6), "Value News");
        CustomAssertions.assertEqualsText("", customersListPage.getTextFromTableBody(0, 7), "Value Segments");
    }

    @When("Se presiona el nombre del usuario del registro {int}")
    public void se_presiona_el_nombre_del_usuario_del_registro(int index) {
        customersListPage.editCustomer(index);
        CustomAssertions.assertElementVisible(
                customerEditPage.isHeaderDisplayed(),
                customerEditPage.getByHeader(),
                "Customer Edit Header"
        );
        CustomAssertions.assertElementVisible(
                customerEditPage.isLabelFirstSeenDisplayed(),
                customerEditPage.getByLabelFirstSeen(),
                "First Seen Label Edit");
        CustomAssertions.assertEqualsText(
                DateUtils.getCurrentDate("dd-MM-yyyy"),
                customerEditPage.getByLabelFirstSeen(),
                customerEditPage.getTextLabelFirstSeen(),
                "First Seen Date Edit");
        CustomAssertions.assertElementVisible(
                customerEditPage.isLabelLastSeenDisplayed(),
                customerEditPage.getByLabelLastSeen(),
                "Last Seen Label Edit");
        CustomAssertions.assertEqualsText(
                DateUtils.getCurrentDate("dd-MM-yyyy"),
                customerEditPage.getByLabelLastSeen(),
                customerEditPage.getTextLabelLastSeen(),
                "Last Seen Date Edit");
    }


    @When("Ingreso first name modificado {string}")
    public void ingreso_first_name_modificado(String firstName) {
        customerEditPage.typeFirstName(firstName);
    }

    @When("Ingreso last name modificado {string}")
    public void ingreso_last_name_modificado(String lastName) {
        customerEditPage.typeLastName(lastName);
    }

    @When("Selecciono segment {string}")
    public void selecciono_segment(String segment) {
        customerEditPage.selectSegment(segment);
    }

    @When("Ingreso email modificado {string}")
    public void ingreso_email_modificado(String email) {
        customerEditPage.typeEmail(email);
    }

    @When("Selecciono has newsletter {string}")
    public void selecciono_has_newsletter(String hasNewsletter) {
        customerEditPage.setHasNewsletter(hasNewsletter);
    }

    @When("Ingreso birthday modificado {string}")
    public void ingreso_birthday_modificado(String birthday) {
        customerEditPage.typeBirthday(birthday);
    }

    @When("Ingreso address modificado {string}")
    public void ingreso_address_modificado(String address) {
        customerEditPage.typeAddress(address);
    }

    @When("Ingreso city modificado {string}")
    public void ingreso_city_modificado(String city) {
        customerEditPage.typeCity(city);
    }

    @When("Ingreso state modificado {string}")
    public void ingreso_state_modificado(String state) {
        customerEditPage.typeState(state);
    }

    @When("Ingreso zipcode modificado {string}")
    public void ingreso_zipcode_modificado(String zipcode) {
        customerEditPage.typeZipcode(zipcode);
    }

    @When("Ingreso password customer modificado {string}")
    public void ingreso_password_customer_modificado(String password) {
        customerEditPage.typePassword(password);
    }

    @When("Ingreso confirm password customer modificado {string}")
    public void ingreso_confirm_password_customer_modificado(String confirmPassword) {
        customerEditPage.typeConfirmPassword(confirmPassword);
    }

    @When("Click en el botón SAVE edit customer")
    public void click_en_el_boton_save_edit_customer() {
        CustomAssertions.assertElementVisible(
                customerEditPage.isButtonSaveDisplayed(),
                customerEditPage.getButtonSave(),
                "Edit Customer Button Save"
        );
        customerEditPage.clickSave();
    }

    @Then("Se valida el customer recien modificado")
    public void se_valida_el_customer_recien_modificado() {
        CustomAssertions.assertEqualsText("Q\nQA Edit Automation Edit", customersListPage.getTextFromTableBody(0, 1), "Value Name");
        CustomAssertions.assertEqualsText(DateUtils.getCurrentDate("dd-MM-yyyy"), customersListPage.getTextFromTableBody(0, 2), "Value Last Seen");
        CustomAssertions.assertEqualsText("0", customersListPage.getTextFromTableBody(0, 3), "Value Orders");
        CustomAssertions.assertEqualsText("US$0,00", customersListPage.getTextFromTableBody(0, 4), "Value Total spent");
        CustomAssertions.assertContainsText(DateUtils.getCurrentDate("dd-MM-yyyy"), customersListPage.getTextFromTableBody(0, 5), "Value Latest purchase");
        CustomAssertions.assertEqualsText("Yes", customersListPage.getTextFromTableBody(0, 6), "Value News");
        CustomAssertions.assertEqualsText("Regular", customersListPage.getTextFromTableBody(0, 7), "Value Segments");
    }

    @When("Se selecciona el Customer {int}")
    public void se_selecciona_el_customer(int index){
        customersListPage.selectCustomer(index);
    }

    @And("Se presiona el botón DELETE")
    public void se_presiona_el_boton_delete(){
        customersListPage.clickDeleteCustomer();
    }

    @Then("Se visualiza un mensaje informando que no se encontro el customer")
    public void se_visualiza_un_mensaje_informando_que_no_se_encontro_el_customer(){
        CustomAssertions.assertElementVisible(
                customersListPage.isEmptyStateDisplayed(),
                customersListPage.getByEmptyState(),
                "No Customers found using the current filters."
        );
    }
}