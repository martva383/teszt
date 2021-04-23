package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class NewsLetterSteps extends StepDefinitions {



    @Given("the {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        driver.findElement(By.id(field)).sendKeys(parameter);
    }

    @Given("user click news letter subscription button")
    public void clickSubscriptionButton() {
        driver.findElement(By.xpath("//*[@id=\"newsletter_block_left\"]/div/form/div/button")).click();
    }

    @Then("the {string} message is shown")
    public void theMessageIsShown(String message) {
        assertEquals(message, driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText());
    }

}