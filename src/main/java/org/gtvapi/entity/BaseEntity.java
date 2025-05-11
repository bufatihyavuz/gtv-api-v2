package org.gtvapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "cre_date")
    private LocalDateTime createDate;

    @Column(name = "cre_by")
    private String creBy;

    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @Column(name = "mod_by")
    private String modBy;

    @Column(name = "record_status")
    private Integer recordStatus;

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCreBy() {
        return creBy;
    }

    public void setCreBy(String creBy) {
        this.creBy = creBy;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }

    public void setModDate(LocalDateTime modDate) {
        this.modDate = modDate;
    }

    public String getModBy() {
        return modBy;
    }

    public void setModBy(String modBy) {
        this.modBy = modBy;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }
}
