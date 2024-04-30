import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty","html:target/cucumber-report/cucumber.html"
		}
		,features= {"src/main/java/Features"}
		,glue = {"stepDef"}
		,monochrome = true
		,tags = "@smokeTest"

		)
public class TestRunner {

}