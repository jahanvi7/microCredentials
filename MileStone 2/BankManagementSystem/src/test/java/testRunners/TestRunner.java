package testRunners;

import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "feature" }
		, glue = "steps"
		,plugin = {"pretty", "html:Report1"}
//		,tags = { "@P51 or @P52" }
				)
public class TestRunner {

}
