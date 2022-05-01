package com.gourav.interviewBitScraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gourav")
@SpringBootApplication
public class InterviewBitScraperApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterviewBitScraperApplication.class, args);
    }
}
