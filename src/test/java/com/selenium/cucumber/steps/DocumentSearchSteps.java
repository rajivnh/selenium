package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.DocumentSearchPage;

import io.cucumber.java.en.Then;

public class DocumentSearchSteps {
	@LazyAutowired
	DocumentSearchPage documentSearchPage;
    
	@Then("I verify {string} text displayed on Document Search page")
    public void iVerifyTextDisplayed(String expectedText) {
		documentSearchPage.verifyWithXPathIfTableHeaderExists(expectedText);
    }
}
