package com.orangehrmlive.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", //-----content root path for features directory
        glue = "com/orangehrmlive/demo/steps", //-----source root path for steps package
        plugin = {"html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/cucumber.json"},
        tags = "@current",
        dryRun = false
)

public class RunCukeCurrentTest extends AbstractTestNGCucumberTests {
}
