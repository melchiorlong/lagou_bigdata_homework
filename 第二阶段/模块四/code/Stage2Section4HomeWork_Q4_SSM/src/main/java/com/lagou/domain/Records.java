package com.lagou.domain;

import java.sql.Date;

/**
 * @author Administrator
 */
public class Records {

    private int recordsId;
    private int customerId;
    private Date happenedDate;
    private String location;
    private String description;
    private String details;
    private int managerId;

    @Override
    public String toString() {
        return "Records{" +
                "recordsId=" + recordsId +
                ", customerId=" + customerId +
                ", happenedDate=" + happenedDate +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", managerId=" + managerId +
                '}';
    }

    public int getRecordsId() {
        return recordsId;
    }

    public void setRecordsId(int recordsId) {
        this.recordsId = recordsId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getHappenedDate() {
        return happenedDate;
    }

    public void setHappenedDate(Date happenedDate) {
        this.happenedDate = happenedDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
