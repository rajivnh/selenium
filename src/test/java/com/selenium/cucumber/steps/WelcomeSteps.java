package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.LoginPage;
import com.selenium.pages.WelcomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WelcomeSteps {
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	WelcomePage welcomePage;
    
    @When("I try to login with {string} and {string}")
    public void iTryToLoginWithAnd(String username, String password) {
    	loginPage.login(username, password);
    }
    
    @Then("I verify ADD DOCUMENT menu is selected")
    public void iVerifyAddDocumentMenuSelected() {
    	welcomePage.verifyWithXPath("ADD DOCUMENT");
    }
}
