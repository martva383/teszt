package org.example;

import io.cucumber.java.en.Given;

public class EverySteps extends StepDefinitions {


    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        driver.get("http://automationpractice.com/");
    }

}