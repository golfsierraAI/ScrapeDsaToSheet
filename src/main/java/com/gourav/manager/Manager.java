package com.gourav.manager;

import com.gourav.pojo.Pojo;
import com.gourav.utils.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Manager {
    @Autowired
    Util util;

    public void scrapeInterviewBit(WebElement element) {
        List<WebElement> table2 = element.findElements(By.className("row")).get(2).findElements(By.className("panel-default"));
        List<Pojo> pojoList = new ArrayList<>();
        table2.forEach((item) -> {
            List<WebElement> innerList = item.findElements(By.tagName("span"));
            Pojo pojo = new Pojo();
            innerList.forEach((innerItem) -> {
                if (innerItem.getAttribute("class").equals("label label-danger")) {
                    pojo.getTags().add(innerItem.getText());
                } else if (innerItem.getAttribute("class").equals("label label-success")) {
                    pojo.getCompanies().add(innerItem.getText());
                }
            });
            try {
                pojo.setName((item.getText().substring(0, item.getText().indexOf(pojo.getTags().get(0)))));
            } catch (Exception e) {
                pojo.setName((item.getText().substring(0, item.getText().indexOf(pojo.getCompanies().get(0)))));
                System.out.println("Code phat gaya tha but bacha lia maine");
            }
            pojo.setLink(item.findElement(By.className("pull-right")).findElement(By.tagName("a")).getAttribute("href"));
            pojoList.add(pojo);
        });
        util.interviewBitWriter(pojoList);
        return;
    }

    public void scrapeBlind75(WebElement webElement) {
        List<WebElement> tagsList = webElement.findElements(By.tagName("h3"));
        List<WebElement> questionsList = webElement.findElements(By.tagName("ul"));
        List<Pojo> pojoList = new ArrayList<>();
        int[] i = {0};
        questionsList.forEach((question) -> {
            List<WebElement> links = question.findElements(By.tagName("a"));
            links.forEach((link) -> {
                Pojo pojo = new Pojo();
                pojo.getTags().add(tagsList.get(i[0]).getText());
                pojo.setLink(link.getAttribute("href"));
                pojo.setName(link.getText());
                System.out.println(link.getText());
                pojoList.add(pojo);
            });
            i[0]++;
        });
        util.blind75Writer(pojoList);
        return;
    }
}
