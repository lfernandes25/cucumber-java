package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = "steps",
        plugin = {"pretty", "html:target/report-html.html"},
        tags = "@Filme and not @ignore" ,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false // valida se os cenarios foram construidos corretamente, sem executar os testes
)
public class Runner {
}
