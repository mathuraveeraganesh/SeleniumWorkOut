package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src//test//java//features//shopclues.feature"
				,glue="steps",monochrome=true)
public class ShopcluesRunnerFile extends AbstractTestNGCucumberTests{

}
