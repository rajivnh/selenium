package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.PluginPage;

import io.cucumber.java.en.Then;

public class PluginSteps {	
	@LazyAutowired
	PluginPage pluginPage;
    
	@Then("I verify {string} text displayed on Plugin page")
    public void iVerifyTextDisplayed(String expectedText) {
		pluginPage.verifyWithXPathIfTableHeaderExists(expectedText);
    }
}
