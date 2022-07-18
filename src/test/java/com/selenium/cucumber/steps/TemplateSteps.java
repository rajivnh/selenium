package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.TemplatePage;

import io.cucumber.java.en.Then;

public class TemplateSteps {
	@LazyAutowired
	TemplatePage templatePage;
    
	@Then("I verify {string} text displayed on Template page")
    public void iVerifyTextDisplayed(String expectedText) {
    	templatePage.verifyWithXPathIfTableHeaderExists(expectedText);
    }
}
