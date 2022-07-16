package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.annotation.LazyComponent;

@LazyComponent
public class WelcomePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//a[@class='adddoctab tab tabhighlight']")
    public WebElement menuItem;
    
    public WelcomePage verifyWithXPath(String expectedText) {                
        String actualText = readText(menuItem);
        
        assertThat(expectedText).isEqualTo(actualText);
        
        return this;
    }
    
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.menuItem.isDisplayed());
	}
}
