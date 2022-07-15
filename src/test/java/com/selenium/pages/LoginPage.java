package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.annotation.LazyComponent;

import lombok.SneakyThrows;

@LazyComponent
public class LoginPage extends BasePage {
    @FindBy(how = How.NAME, using = "emailId")
    public WebElement userName;

    @FindBy(how = How.NAME, using = "password")
    public WebElement password;
    
    @SneakyThrows
    public LoginPage login(String userName, String password) {
        writeText(this.userName, userName);
        writeText(this.password, password);
        
		Thread.sleep(2000);
                
        jsClick(By.linkText("SIGN IN"));

		Thread.sleep(2000);
        
        return this;
    }
    
    public LoginPage verifyWithXPath(String expectedErrMsg) {                
        String actualErrMsg = readText(By.xpath("//div[@class='infoDiv']//div[1]"));
        
        assertThat(expectedErrMsg).isNotEqualTo(actualErrMsg);
        
        return this;
    }
    
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.userName.isDisplayed());
	}
}
