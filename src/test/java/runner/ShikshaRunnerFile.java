package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//shiksha.feature"
			,glue="steps",monochrome=true)
public class ShikshaRunnerFile extends AbstractTestNGCucumberTests{

}
