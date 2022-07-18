package com.selenium.cucumber.steps;

import java.util.Map;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.WelcomePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	HomePage homePage;
	
	@LazyAutowired
	WelcomePage welcomePage;
	
    @Given("I launch the Login page")
    public void iAmOnTheLoginPage() {
    	homePage.goToHomePage();
    }
   
    @When("I enters invalid credentials to login")
    public void iTryToLoginWithAnd(DataTable dataTable) {
    	for(Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
    		loginPage.login(data.get("emailId"), data.get("password"));
    	}
    }
    
    @Then("I verify {string} text displayed")
    public void iVerifyInvalidLoginMessage(String expectedText) {
    	loginPage.verifyWithXPath(expectedText);
    }
    
    @When("I enter valid {string} and {string}")
    public void iTryToLoginWithAnd(String username, String password) {
    	loginPage.login(username, password);
    }
    
    @Then("I should see Welcome page")
    public void iVerifyAddDocumentMenuSelected() {
    	welcomePage.verifyWelcomePageWithXPath("ADD DOCUMENT");
    }
}
