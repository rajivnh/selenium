package com.selenium.pages;

import org.springframework.beans.factory.annotation.Value;

import com.selenium.annotation.LazyComponent;
import com.selenium.annotation.TakeScreenshot;

@LazyComponent
public class HomePage extends BasePage {
    @Value("${base.url}")
    private String baseURL;
    
    @TakeScreenshot
    public HomePage goToHomePage() {
        driver.get(baseURL);
        
        return this;
    }
}
