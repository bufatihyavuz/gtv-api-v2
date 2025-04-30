package org.gtvapi.entity;

import jakarta.persistence.Column;

import java.time.LocalTime;

public class BaseEntity {

    @Column(name = "create_date")
    private LocalTime createDate;

    @Column(name = "cre_by")
    private String creBy;

    @Column(name = "mod_date")
    private LocalTime modDate;

    @Column(name = "mod_by")
    private String modBy;

    @Column(name = "record_status")
    private int recordStatus;

    public LocalTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalTime createDate) {
        this.createDate = createDate;
    }

    public String getCreBy() {
        return creBy;
    }

    public void setCreBy(String creBy) {
        this.creBy = creBy;
    }

    public LocalTime getModDate() {
        return modDate;
    }

    public void setModDate(LocalTime modDate) {
        this.modDate = modDate;
    }

    public String getModBy() {
        return modBy;
    }

    public void setModBy(String modBy) {
        this.modBy = modBy;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }
}
