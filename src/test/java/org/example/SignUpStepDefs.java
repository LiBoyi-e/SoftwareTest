package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SignUpStepDefs extends AbstractStepDefs {

    @Given("the Sign Up {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Create an account button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.clickCreateAccountButton();
    }

    @Then("the Sign Up {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getRegisterError();
        if (errorMessage.isPresent()) {
            System.out.println(errorMessage.get());
            System.out.println(msg);
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Then("the Sign Up {string} Button is shown")
    public void theMyAccountTitleIsShown(String msg) {
        Optional<String> message = homePage.getCreateAccountMessage();
        if (message.isPresent()) {
            Assert.assertEquals(msg, message.get());
        } else {
            fail();
        }
    }
}
