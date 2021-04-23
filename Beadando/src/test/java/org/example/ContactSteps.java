package org.example;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class ContactSteps extends StepDefinitions {

    @Given("user clicks on the contact us button")
    public void userClicksOnTheContactUsButton() {
        driver.findElement(By.id("contact-link")).click();
    }

    @Given("user enters valid email address")
    public void userEntersValidEmailAddress() {
        driver.findElement(By.id("email")).sendKeys("valid@email.com");
    }

    @And("user clicks on the send button")
    public void userClicksOnTheSendButton() {
        driver.findElement(By.id("submitMessage")).click();
    }

    @Then("the message cannot be blank error message is shown")
    public void theMessageCannotBeBlankErrorMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        assertNotEquals(0, elements.size());
        assertEquals("The message cannot be blank.", elements.get(0).getText());
    }

    @Given("user enters invalid email address")
    public void userEntersInvalidEmailAddress() {
        driver.findElement(By.id("email")).sendKeys("invalid.email.com");
    }

    @Then("invalid email address error message is shown")
    public void invalidEmailAddressErrorMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div/ol/li"));
        assertNotEquals(0, elements.size());
        assertEquals("Invalid email address.", elements.get(0).getText());
    }

    @And("user enters message")
    public void userEntersMessage() {
        driver.findElement(By.id("message")).sendKeys("Test message");
    }

    @And("user selects a subject")
    public void userSelectsASubject() {
        Select subjectDropdown = new Select(driver.findElement(By.id("id_contact")));
        subjectDropdown.selectByIndex(2);
    }

    @Then("your message has been successfully sent to our team message is shown")
    public void yourMessageHasBeenSuccessfullySentToOurTeamMessageIsShown() {
        assertEquals("Your message has been successfully sent to our team.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
    }
}