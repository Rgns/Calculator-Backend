package com.project.rg.Calculator.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class History {

    @Id
    private String id;
    private String userName;
    private String historyString;
    private Date timestamp;

    public History(String userName, String historyString, Date timestamp) {
        this.userName = userName;
        this.historyString = historyString;
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHistoryString() {
        return historyString;
    }

    public void setHistoryString(String historyString) {
        this.historyString = historyString;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


}
