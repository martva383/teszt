package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

public class SearchSteps extends StepDefinitions {

    @Given("the search button is clicked")
    public void theSearchButtonIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button")).click();
    }


    @Then("please enter search keyword message is shown")
    public void pleaseEnterASearchKeywordMessageIsShown() {
        assertEquals("Please enter a search keyword",driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }


    @Given("user entered {string} in {string}")
    public void userEnteredValueInField( String value, String field) {
        driver.findElement(By.id(field)).sendKeys(value);
    }

    @Then("the {string} is shown")
    public void theMessageIsShown(String message) {
        assertEquals(message, driver.findElement(By.className("heading-counter")).getText());
    }
}