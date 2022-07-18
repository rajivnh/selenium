package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import com.selenium.annotation.LazyComponent;
import com.selenium.annotation.TakeScreenshot;

import lombok.SneakyThrows;

@LazyComponent
public class LoginPage extends BasePage {
    @Value("${base.url}")
    private String baseURL;
    
    @TakeScreenshot
    public LoginPage goToHomePage() {
        driver.get(baseURL);
        
        return this;
    }
    
    @SneakyThrows
    public LoginPage login(String emailId, String password) {
        writeText(By.name("emailId"), emailId);
        writeText(By.name("password"), password);
        
		Thread.sleep(2000);
                
        jsClick(By.linkText("SIGN IN"));
        
        return this;
    }
    
    public LoginPage verifyWithXPath(String expectedErrMsg) {
        String actualErrMsg = readText(By.xpath("//div[@class='infoDiv']//div"));
        
        assertThat(expectedErrMsg).isEqualTo(actualErrMsg);
        
        return this;
    }
}
