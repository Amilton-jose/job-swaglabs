package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        //(Features) Referência a pasta com as featuresa serem testadas
        features = {"src/test/java/features/swaglabs/"},
        glue = {"gherkin"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-report.json"},
        dryRun = false
// Execute o Runner para iniciar os testes
// O (dryRun) deve estar false para os testes serem executados corretamente.
)
public class Runner {

}
