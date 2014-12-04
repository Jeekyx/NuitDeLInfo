package com.epita.mti.nuitdelinfoandroid.model;

import java.util.Date;
import java.util.List;

/**
 * Created by yvan on 12/4/14.
 */
public class Campaign {
    private String name;
    private String description;
    private String location;
    private int volunteers;

    private CharityProfile charityProfile;
    private List<Feed> feeds;

    private Date startDate;
    private Date endDate;
    private Date inscriptionEndDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(int volunteers) {
        this.volunteers = volunteers;
    }

    public CharityProfile getCharityProfile() {
        return charityProfile;
    }

    public void setCharityProfile(CharityProfile charityProfile) {
        this.charityProfile = charityProfile;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getInscriptionEndDate() {
        return inscriptionEndDate;
    }

    public void setInscriptionEndDate(Date inscriptionEndDate) {
        this.inscriptionEndDate = inscriptionEndDate;
    }
}
