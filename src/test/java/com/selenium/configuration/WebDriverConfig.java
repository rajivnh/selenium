package com.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;

import com.selenium.annotation.LazyComponent;
import com.selenium.annotation.WebdriverScopeBean;

@LazyComponent
public class WebDriverConfig {
	@Value("${edge.driver.path}")
	private String edgeDriverPath;
	
	@Value("${chrome.driver.path}")
	private String chromeDriverPath;
	
	@WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

	@WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
    	System.setProperty("webdriver.edge.driver", edgeDriverPath);
    	
        return new EdgeDriver();
    }

	@WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
        return new ChromeDriver();
    }
}
