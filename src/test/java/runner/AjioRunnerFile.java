package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= "src//test//java//features//ajio.feature"
	,glue="steps",monochrome=true)
public class AjioRunnerFile extends AbstractTestNGCucumberTests{

}
