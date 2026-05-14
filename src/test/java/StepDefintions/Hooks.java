package StepDefinitions;

import StepDefintions.Basetest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Hooks — Cucumber lifecycle hooks for your SauceLabs project.
 *
 * @Before  → runs before every scenario  → starts the browser
 * @After   → runs after  every scenario  → takes screenshot on fail, closes browser
 */
public class Hooks extends Basetest {

    @Before
    public void beforeScenario() {
        initDriver();  // starts Chrome (headless in CI, normal locally)
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Take a screenshot automatically when a scenario fails
        if (scenario.isFailed() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure screenshot");
        }
        quitDriver();  // always close the browser
    }
}