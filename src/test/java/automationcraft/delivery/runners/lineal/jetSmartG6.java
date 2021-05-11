package automationcraft.delivery.runners.lineal;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/G6/features"},
        glue = {"automationcraft.testcreation.G6.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread"},
        tags = "@G6 and @caso4"

)

public class jetSmartG6 {
}
