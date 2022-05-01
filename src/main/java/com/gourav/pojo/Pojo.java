package com.gourav.pojo;

import java.util.ArrayList;
import java.util.List;

public class Pojo {
    private List<String> tags = new ArrayList<>();
    private List<String> companies = new ArrayList<>();
    private String name;
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
