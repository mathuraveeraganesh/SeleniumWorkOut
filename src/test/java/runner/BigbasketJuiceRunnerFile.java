package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//bigbasketjuice.feature"
					,glue="steps",monochrome=true)
public class BigbasketJuiceRunnerFile extends AbstractTestNGCucumberTests {
	

}
