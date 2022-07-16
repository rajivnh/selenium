package com.selenium.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.selenium.annotation.LazyComponent;

import lombok.SneakyThrows;

@LazyComponent
public class TemplatePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//tbody//tr//th[2]")
    public WebElement menuItem;
    
    @SneakyThrows
    public TemplatePage clickTemplateMenu() {
		Thread.sleep(2000);
                
        jsClick(By.linkText("MANAGE TEMPLATE"));
        
        Thread.sleep(2000);
        
        return this;
    }
    
    public TemplatePage verifyWithXPathIfTableHeaderExists(String expectedText) {                
        String actualText = readText(By.xpath("//tbody//tr//th[2]"));
        
        assertThat(expectedText).isEqualTo(actualText);
        
        return this;
    }
    
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.menuItem.isDisplayed());
	}
}
