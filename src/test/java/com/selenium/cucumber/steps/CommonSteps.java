package com.selenium.cucumber.steps;

import com.selenium.annotation.LazyAutowired;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.pages.WelcomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonSteps {
	@LazyAutowired
	HomePage homePage;
	
	@LazyAutowired
	LoginPage loginPage;
	
	@LazyAutowired
	WelcomePage welcomePage;
	
	@Given("I login using valid {string} and {string}")
	public void navigateToWelcomePage(String username, String password) {
		homePage.goToHomePage();		
		
		loginPage.login(username, password);
	}
	
	@When("I click {string} menu on welcome page")
    public void iTrytoClickMenu(String linkText) {    	
		welcomePage.clickMenu(linkText);
    }
}
