package org.gtvapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name = "cre_date")
    private LocalDateTime createDate;

    @CreatedBy
    @Column(name = "cre_by")
    private String creBy;

    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @LastModifiedBy
    @Column(name = "mod_by")
    private String modBy;

    @Column(name = "record_status")
    private Integer recordStatus;

    @PrePersist
    public void prePersist() {
        if (recordStatus == null) {
            recordStatus = 1;
        }
    }

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
