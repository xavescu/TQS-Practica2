package io.cucumber.skeleton;

import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Then("I should see a {string} button")
    public void iShouldSeeAButton(String text) {
        By byXPath = By.xpath("//*[contains(text(),'" + text + "')]");
        boolean present = driver.findElements(byXPath).size() > 0;
        Assertions.assertTrue(present);
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

    @Then("I should see a {string} linkText")
    public void iShouldSeeALinkText(String text) {
        boolean present = driver.findElements(By.linkText(text)).size() > 0;
        Assertions.assertTrue(present);
    }

    @When("I click on {string} linkText")
    public void iClickOnLinkText(String link_text){
        driver.findElement(By.linkText(link_text)).click();
    }

    @Then("I go to the Add Remove Elements section")
    public void iGoToTheAddRemoveElementsSection(){
        Assertions.assertEquals("https://the-internet.herokuapp.com/add_remove_elements/", driver.getCurrentUrl());
    }

    @When("I click on {string} button")
    public void iClickOnButton(String button_text) {
        driver.findElement(By.linkText(button_text)).click();
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
}
