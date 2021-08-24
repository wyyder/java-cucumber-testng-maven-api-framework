package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api-crud-test.feature",
        glue = {"steps"},
        dryRun = false,
        monochrome = true,
//		tags = "@SmokeTest",
        plugin = {"pretty", "html:results/test-reports.html",
                "json:results/test-report.json",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        }

)

public class TestRunner extends AbstractTestNGCucumberTests {

// # For parallel Test execution
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }


}
