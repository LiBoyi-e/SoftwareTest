package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractStepDefs {

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        homePage.openPage();
    }

    @And("the Sign In link is clicked")
    public void theSignInLinkIsClicked() {
        homePage.clickSignInLink();
    }
}
