package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {"src/test/java/features/AccountList.feature"},
//        features = {"src/test/java/features/AddressBar.feature"},
          features = {"src/test/java/features/HomePageButton.feature"},
//        features = {"src/test/java/features/RegistrationPage.feature"},
//        features = {"src/test/java/features/SearchBox.feature"},
//        features = {"src/test/java/features/SignInPage.feature"},
//        features = {"src/test/java/features/ProductDropDown.feature"},

        glue = {"stepDefinitions"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/index.html",
                "pretty:target/cucumber-reports/cucumber-pretty.txt", "usage:target/cucumber-reports/cucumber-usage.json",
                "junit:target/cucumber-reports/cucumber-results.xml"
        },
//             dryRun = true
           dryRun = false,
        //tags use here for HomePage Button
        tags = "(@SmokeTest or @RegressionTest or @IntegrationTest) and (not @pending)"
)
public class AmazonTestRunner {
}
