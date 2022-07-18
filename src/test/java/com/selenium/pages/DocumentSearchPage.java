package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import com.selenium.annotation.LazyComponent;

import lombok.SneakyThrows;

@LazyComponent
public class DocumentSearchPage extends BasePage {
    @SneakyThrows
    public DocumentSearchPage clickTemplateMenu(String linkText) {
		Thread.sleep(2000);
                
        jsClick(By.linkText(linkText));
        
        Thread.sleep(2000);
        
        return this;
    }
    
    @SneakyThrows
    public DocumentSearchPage verifyWithXPathIfTableHeaderExists(String expectedText) {                
        String actualText = readText(By.xpath("//tbody//tr//th[2]"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        Thread.sleep(2000);
        
        return this;
    }
}
