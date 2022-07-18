package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import com.selenium.annotation.LazyComponent;

@LazyComponent
public class TemplatePage extends BasePage {
  
    public TemplatePage verifyWithXPathIfTableHeaderExists(String expectedText) {                
        String actualText = readText(By.xpath("//tbody//tr//th[2]"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        return this;
    }
}
