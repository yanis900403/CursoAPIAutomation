package uy.com.geocom.automation.geosaludServicios.resources.encounter;


import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:build/cucumber", "json:test/reports/cucumber_reports.json"},
        features={"classpath:uy/com/geocom/automation/geosaludServicios/features/encounter/Encounter.feature"},
        glue={"uy/com/geocom/automation/geosaludServicios/resources/encounter"},
        tags="@Encounter"
)

public class EncounterRunner {

}