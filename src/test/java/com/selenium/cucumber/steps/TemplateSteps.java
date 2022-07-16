package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.LoginPage;
import com.selenium.pages.TemplatePage;
import com.selenium.pages.WelcomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TemplateSteps {
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	WelcomePage welcomePage;
	
	@LazyAutowired
	TemplatePage templatePage;
    
    @When("I click on Manage Template on the menu item")
    public void iTrytoClickTemplateMenu() {
    	templatePage.clickTemplateMenu();
    }
    
    @Then("I verify if Template page is displayed")
    public void iVerifyTemplatePageDisplayed() {
    	templatePage.verifyWithXPathIfTableHeaderExists("TEMPLATE ID");
    }
}
