package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//Honda.feature"
			,glue="steps",monochrome=true)
public class HondaRunnerFile extends AbstractTestNGCucumberTests{

}
