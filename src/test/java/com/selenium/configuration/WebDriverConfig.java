package com.selenium.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.selenium.annotation.LazyComponent;

@LazyComponent
public class WebDriverConfig {
	@Value("${driver.path}")
	private String driverPath;
	
	@Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

	@Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
    	System.setProperty("webdriver.edge.driver", driverPath);
    	
        return new EdgeDriver();
    }

	@Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", "c:/aws/screen/chromedriver.exe");

        return new ChromeDriver();
    }
}
