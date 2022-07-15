package com.selenium.cucumber.steps;

import java.util.Map;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	HomePage homePage;
	
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    	homePage.goToHomePage();
    }
   
    @When("I enters Credentials to LogIn")
    public void iTryToLoginWithAnd(DataTable dataTable) {
    	for(Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
    		loginPage.login(data.get("username"), data.get("password"));
    	}
    }
    
    @Then("I verify invalid login message")
    public void iVerifyInvalidLoginMessage() {
    	loginPage.verifyWithXPath(" Invalid Email Id or Password. Please try again!");
    }
}
