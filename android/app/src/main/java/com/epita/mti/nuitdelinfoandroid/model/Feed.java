package com.epita.mti.nuitdelinfoandroid.model;

import java.util.Date;

/**
 * Created by yvan on 12/4/14.
 */
public class Feed extends Model {
    private String messsage;
    private String imageLocation;
    private Date submissionDate;
    private User user;

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
