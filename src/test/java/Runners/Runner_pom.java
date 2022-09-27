package Runners;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/main/resources/Features/IniciarSesion.feature",
        glue={"IniciarSesionSteps"},
        format = {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},
        dryRun=false
)
public class Runner_pom {
}
