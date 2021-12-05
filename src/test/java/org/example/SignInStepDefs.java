package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SignInStepDefs extends AbstractStepDefs {

    @Given("the Sign In {string} is filled with {string}")
    public void theFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Sign In button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.clickSignInButton();
    }

    @Then("the Sign In {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getLoginError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Then("the Sign In {string} info is shown")
    public void theMyAccountTitleIsShown(String msg) {
        Optional<String> message = homePage.getMyAccountMessage();
        if (message.isPresent()) {
            Assert.assertEquals(msg, message.get());
        } else {
            fail();
        }
        homePage.logout();
    }
}
