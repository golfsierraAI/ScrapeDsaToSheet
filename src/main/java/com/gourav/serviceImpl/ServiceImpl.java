package com.gourav.serviceImpl;

import com.gourav.manager.Manager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ServiceImpl {
    @Autowired
    ChromeDriver driverBean;

    @Autowired
    Manager manager;

    @PostConstruct
    public String scrape() {
        String url = "https://www.interviewbit.com/search/?q=Microsoft";
        WebDriverWait wait = new WebDriverWait(driverBean, 1000);
        driverBean.get(url);
        WebElement list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("container"))).get(1);
        manager.scrapeInterviewBit(list);
        url = "https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions";
        driverBean.get(url);
        list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("discuss-markdown-container")));
        manager.scrapeBlind75(list);
        return null;
    }

    @PreDestroy
    public void destroy() {
        driverBean.close();
        driverBean.quit();
        System.out.println("DONE DANA DONE");
    }
}
