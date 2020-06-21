package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features= "src//test//java//features//CRMSystem.feature"
	,glue="steps",monochrome=true)
public class CRMSystemRunnerFile extends AbstractTestNGCucumberTests{

}
