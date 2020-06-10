package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//bigbacket.feature"
					,glue="steps",monochrome=true)
public class BigbasketRunnerFile extends AbstractTestNGCucumberTests {
	

}
