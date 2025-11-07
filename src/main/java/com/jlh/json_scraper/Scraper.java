package com.jlh.json_scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Scraper {
    private final WebDriver driver;

    private volatile boolean busy = false;

    public Scraper() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }

    public synchronized String getJSON(String url) {
        busy = true;
        driver.get(url);

        //click on raw data tab
        driver.findElement(By.id("rawdata-tab")).click();
        
        String rtn = driver.findElement(By.className("data")).getText();
        busy = false;
        return rtn;
    }

    public boolean isBusy() {
        return busy;
    }

    public void close() {
        driver.close();
    }
}
