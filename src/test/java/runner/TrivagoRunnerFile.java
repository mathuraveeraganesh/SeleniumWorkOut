package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//trivago.feature"
				,glue ="steps",monochrome=true)
public class TrivagoRunnerFile extends AbstractTestNGCucumberTests{

}
