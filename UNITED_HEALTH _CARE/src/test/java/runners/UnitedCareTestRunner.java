package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features =
//                {"src/test/java/features/FindPharmacy.feature"},
//                {"src/test/java/features/Registation.feature"},
               {"src/test/java/features/SearchProduct.feature"},
 //                 {"src/test/java/features/InsurancePlan.feature"},

        glue = {"stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/index.html",
                "pretty:target/cucumber-reports/cucumber-pretty.txt", "usage:target/cucumber-reports/cucumber-usage.json",
                "junit:target/cucumber-reports/cucumber-results.xml"
        },
//        dryRun = true
         dryRun = false
)
public class UnitedCareTestRunner {
}
