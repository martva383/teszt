
package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RegisterSteps extends StepDefinitions {



    @Given("the sign in link is clicked")
    public void theSignInLinkIsClicked() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
    }

    @Given("the create account button is clicked")
    public void theCreateAccountBoxIsClicked() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @Then("no email message is shown")
    public void noEmailMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/ol"));
        assertNotEquals(0, elements.size());
        assertEquals("Invalid email address.", elements.get(0).getText());
    }



    @Given("the email field is populated with {string}")
    public void theEmailFieldIsPopulatedWithValue(String value) {
        driver.findElement(By.id("email_create")).sendKeys(value);
    }

    @Then("invalid email message is shown")
    public void invalidEmailMessageIsShown() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"create_account_error\"]/ol"));
        assertNotEquals(0, elements.size());
        assertEquals("Invalid email address.", elements.get(0).getText());
    }

    @Given("the email field is populated")
    public void theEmailFieldIsPopulated() {
        driver.findElement(By.id("email_create")).sendKeys("va4242li32323d@email.com");
    }


    @Then("register form is opened")
    public void registerFormIsOpened() {
        boolean exist = driver.findElements(By.id("account-creation_form")).size() != 0;
        assertTrue("Check whether the form is presented", exist);
    }

}