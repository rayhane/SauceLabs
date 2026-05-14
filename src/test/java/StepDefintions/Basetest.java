

package StepDefintions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * BaseTest — shared WebDriver setup for your SauceLabs Cucumber project.
 *
 * Your StepDefinitions classes (login.java, Addtoproduct.java, etc.)
 * should extend this class to get access to the shared 'driver' instance.
 *
 * Example:
 *   public class login extends BaseTest { ... }
 *   public class Addtoproduct extends BaseTest { ... }
 */
public class Basetest {

    // Static driver — shared across all step definition classes in one scenario
    public static WebDriver driver;

    /**
     * Call this once before your Cucumber scenarios start.
     * In Cucumber, put @Before in a Hooks class, not here directly.
     */
    public static void initDriver() {
        if (driver == null) {
            // Auto-downloads the correct ChromeDriver — no manual install needed
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");               // No screen needed in CI
            options.addArguments("--no-sandbox");             // Required in GitHub Actions
            options.addArguments("--disable-dev-shm-usage"); // Prevents memory crash in CI
            options.addArguments("--window-size=1920,1080"); // Consistent viewport

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(
                    java.time.Duration.ofSeconds(10)
            );
        }
    }

    /**
     * Call this after all scenarios finish to close the browser.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}