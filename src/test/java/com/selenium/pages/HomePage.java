package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

import com.selenium.annotation.LazyComponent;
import com.selenium.annotation.TakeScreenshot;

@LazyComponent
public class HomePage extends BasePage {
    @FindBy(how = How.NAME, using = "emailId")
    public WebElement userName;

    @Value("${base.url}")
    private String baseURL;
    
    @TakeScreenshot
    public HomePage goToHomePage() {
        driver.get(baseURL);
        
        return this;
    }
	
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.userName.isDisplayed());
	}
}
