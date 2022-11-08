package uy.com.geocom.automation.geosaludServicios.resources.flat;
//Objetivo: Va a ejecutar los escenarios que queremos ejecutar, los features.file


import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"pretty", "html:build/cucumber", "json:test/reports/cucumber_reports.json"},
        features={"classpath:uy/com/geocom/automation/geosaludServicios/features/flat/Flat.feature"},
        glue={"uy/com/geocom/automation/geosaludServicios/resources/flat"},
        tags="@Flat"
)

public class FlatRunner {

}