package com.gourav.seleniumDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Driver {

    @PostConstruct
    void postConstructor() {
        System.setProperty("webdriver.chrome.driver", "U:/chromedriver.exe");
    }

    @Bean
    public ChromeDriver driverBean() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }


}