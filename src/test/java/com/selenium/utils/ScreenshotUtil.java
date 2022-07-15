package com.selenium.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.selenium.annotation.LazyComponent;

@LazyComponent
public class ScreenshotUtil {
    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private String path;

    public void takeScreenShot(String testName) throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        
        FileCopyUtils.copy(sourceFile, new File(path + testName + ".png"));
    }

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
