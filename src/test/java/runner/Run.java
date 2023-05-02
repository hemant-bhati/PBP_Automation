package runner;

import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(dryRun = false, features = "features", glue = "stepDef",
        tags = "@PartnerDashboard", format = {"pretty", "html:target/cucumber"}

)
public class Run {
}
