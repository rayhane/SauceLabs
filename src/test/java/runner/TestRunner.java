package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
        glue ={"StepDefinition"},
        plugin = {"pretty", "html:target\\cucumber\\report.html"},
        tags = ("@SuppressionDuPanier"),
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {


}
