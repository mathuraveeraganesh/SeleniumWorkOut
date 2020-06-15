package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//shein.feature"
				,glue ="steps",monochrome=true)
public class SheinRunnerFile extends AbstractTestNGCucumberTests{

}
