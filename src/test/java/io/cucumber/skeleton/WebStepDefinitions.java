package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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
}
