package automationcraft.delivery.runners.lineal;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/automationcraft/testcreation/jetsmartG2/features"},
        glue = {"automationcraft.testcreation.jetsmartG2.steps","automationcraft.engine.bdd"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread"},
        tags = "@G2"
)
public class jetSmartG2 {
}