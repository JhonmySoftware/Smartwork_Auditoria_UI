package co.com.infotrack.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;



@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features"
        , snippets = SnippetType.CAMELCASE
        , tags = "@Requerimiento01"
        , glue = "co.com.infotrack.definitions")

public class RunnerTags {
    // gradle clean test aggregate -Dtags=@Requerimiento01
    // Gradle 7.2
}
