package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

public class WebStepDefinitions {

    /**
     * Note: You must have installed chromedriver in your system
     *       https://chromedriver.chromium.org/downloads
     *       The version must match with the version of your Chrome browser
     */

    private static WebDriver driver;
    private Scenario scenario;

    @BeforeAll
    public static void setUp() {
        // This property is optional.
        // If not specified, WebDriver searches the path for chromedriver in your environment variables
        // Example path for Linux or Mac:
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("I go to the home page")
    public void iGoToTheHomePage() {
        driver.get("https://the-internet.herokuapp.com");
    }

    @Given("I go to the Add Remove Elements section page")
    public void iGoToAddRemoveElementsSectionPage(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Given("I go to the Checkboxes section page")
    public void iGoToTheCheckboxesSectionPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Given("I go to the Dropdown section page")
    public void iGoToTheDropdownSectionPage() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Given("I go to the Inputs section page")
    public void iGoToTheInputsSectionPage() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    @Given("I go to the login page")
    public void iGoToTheLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Given("I go to the js alerts page")
    public void iGoToTheJSAlertsPage() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Then("I should see a {string} button")
    public void iShouldSeeAButton(String text) {
        By byXPath = By.xpath("//*[contains(text(),'" + text + "')]");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
    }

    @Then("I should see {int} Buttons")
    public void iShouldSeeAnAmountOfButtons(int expected_count){
        int count = driver.findElements(By.tagName("button")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("I should see {int} linkTexts")
    public void iShouldSeeAnAmountOfLinkText(int expected_count){
        int count = driver.findElements(By.tagName("a")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("I should see {int} list elements")
    public void iShouldSeeAnAmountOfListElements(int expected_count){
        int count = driver.findElements(By.tagName("li")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("I should see {int} checkboxes")
    public void iShouldSeeAnAmountOfCheckboxes(int expected_count){
        int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("I should see {int} dropdowns")
    public void iShouldSeeDropdowns(int expected_count) {
        int count = driver.findElements(By.xpath("//*[@id='dropdown']")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("I should see {int} number inputs")
    public void iShouldSeeNumberInputs(int expected_count) {
        int count = driver.findElements(By.xpath("//*[@id='content']/div/div/div/input")).size();
        Assertions.assertEquals(expected_count, count);
    }

    @Then("Input value is empty")
    public void inputValueIsEmpty() {
        String value = driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).getAttribute("value");
        Assertions.assertEquals("", value);
    }

    @Then("Input value is {string}")
    public void inputValueIsSomething(String expected_value) {
        String value = driver.findElement(By.xpath("//*[@id='content']/div/div/div/input")).getAttribute("value");
        Assertions.assertEquals(expected_value, value);
    }

    @Then("I should see a {string} linkText")
    public void iShouldSeeALinkText(String text) {
        boolean present = driver.findElements(By.linkText(text)).size() > 0;
        Assertions.assertTrue(present);
    }

    @When("I click on {string} linkText")
    public void iClickOnLinkText(String link_text){
        driver.findElement(By.linkText(link_text)).click();
    }

    @Then("I'm in the Add Remove Elements section")
    public void iMInTheTheAddRemoveElementsSection(){
        Assertions.assertEquals("https://the-internet.herokuapp.com/add_remove_elements/", driver.getCurrentUrl());
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button_text) {
        By byXPath = By.xpath("//*[contains(text(),'" + button_text + "')]");
        driver.findElement(byXPath).click();
    }

    @And("I take a screenshot with filename {string}")
    public void iTakeAScreenshotWithFilename(String filename) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "filename");
    }

    @AfterAll()
    public static void tearDown() {
        driver.quit();
    }

    @Then("{string} checkbox IS NOT checked")
    public void checkboxISNOTChecked(String text) {
        boolean isChecked = false;
        if(Objects.equals(text, "checkbox 1")){
            isChecked = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).isSelected();
        }
        if(Objects.equals(text, "checkbox 2")){
            isChecked = driver.findElements(By.xpath("//input[@type='checkbox']")).get(1).isSelected();
        }
        Assertions.assertFalse(isChecked);
    }

    @Then("{string} checkbox IS checked")
    public void checkboxISChecked(String text) {
        boolean isChecked = false;
        if(Objects.equals(text, "checkbox 1")){
            isChecked = driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).isSelected();
        }
        if(Objects.equals(text, "checkbox 2")){
            isChecked = driver.findElements(By.xpath("//input[@type='checkbox']")).get(1).isSelected();
        }
        Assertions.assertTrue(isChecked);
    }

    @When("I click {string} checkbox")
    public void iClickCheckbox(String text) {
        if(Objects.equals(text, "checkbox 1")){
            driver.findElements(By.xpath("//input[@type='checkbox']")).get(0).click();
        }
        if(Objects.equals(text, "checkbox 2")){
            driver.findElements(By.xpath("//input[@type='checkbox']")).get(1).click();
        }
    }

    @And("Dropdown has the disabled value option selected")
    public void dropdownHasTheDisabledValueOptionSelected() {
        Select s = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
    }

    @Then("Dropdown has {int} available options")
    public void dropdownHasAvailableOptions(int expected_count) {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdown);
        Assertions.assertEquals(expected_count,select.getOptions().size());
    }

    @When("I select {int} option of the dropdown")
    public void iSelectOptionOfTheDropdown(int option){
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdown);
        if(option == 1){
            select.selectByVisibleText("Option 1");
        }
        if(option == 2){
            select.selectByVisibleText("Option 2");
        }
    }

    @Then("{int} option of the dropdown is selected")
    public void optionOfTheDropdownIsSelected(int option) {
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select select = new Select(dropdown);
        boolean correct = false;
        if(option == 1){
            if(Objects.equals(select.getFirstSelectedOption().getText(), "Option 1")){
                correct = true;
            }
        }
        if(option == 2){
            if(Objects.equals(select.getFirstSelectedOption().getText(), "Option 2")){
                correct = true;
            }
        }
        Assertions.assertTrue(correct);
    }

    @When("I click the increment arrow")
    public void iClickTheIncrementArrow() {
        //*[@id="content"]/div/div/div/input//div/div[2]
        driver.findElement(By.xpath("//*[@id='content']/div/div/div/input//div/div[1]")).click();
    }

    @When("I add {string} as user")
    public void iAddAsUser(String user) {
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys(user);
    }

    @When("I add {string} as pass")
    public void iAddAsPass(String pass) {
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pass);
    }

    @Then("I see error message User")
    public void iSeeErrorMessageUser(){
        boolean expectedMessage = driver.findElement(By.xpath("/html/body/div[1]/div")).getText().contains("Your username is invalid!");
        Assertions.assertTrue(expectedMessage);
    }

    @Then("I see error message Password")
    public void iSeeErrorMessagePassword(){
        boolean expectedMessage = driver.findElement(By.xpath("/html/body/div[1]/div")).getText().contains("Your password is invalid!");
        Assertions.assertTrue(expectedMessage);
    }

    @Then("I see success message")
    public void iSeeSuccessMessage(){
        boolean expectedMessage = driver.findElement(By.xpath("/html/body/div[1]/div")).getText().contains("You logged into a secure area!");
        Assertions.assertTrue(expectedMessage);
    }

    @Then("I see success logout message")
    public void iSeeSuccessLogoutMessage(){
        boolean expectedMessage = driver.findElement(By.xpath("/html/body/div[1]/div")).getText().contains("You logged out of the secure area!");
        Assertions.assertTrue(expectedMessage);
    }

    @When("I click on Login button")
    public void iClickOnLoginButton() {
        driver.findElement(By.xpath("//*[@id='login']/button")).click();
    }

    @When("I click on Logout button")
    public void iClickOnLogoutButton() {
        driver.findElement(By.xpath("//*[@id='content']/div/a")).click();
    }

    @When("I wait {int} milliseconds")
    public void iWaitSomeMilliseconds(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    @When("I close the JS Alert")
    public void iCloseTheJSAlert() {
        driver.switchTo().alert().dismiss();
    }

    @When("I accept the JS Alert")
    public void iAcceptTheJSAlert() {
        driver.switchTo().alert().accept();
    }

    @Then("I have {string} as result message")
    public void iHaveAsResultMessage(String message) {
        Assertions.assertEquals(message, driver.findElement(By.xpath("//*[@id='result']")).getText());
    }

    @And("I enter {string} to the JS Alert")
    public void iEnterToTheJSAlert(String string) {
        driver.switchTo().alert().sendKeys(string);
    }
}
