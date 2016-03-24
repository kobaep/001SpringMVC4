package com.psk.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Table(name="DocumentHistory")
@Entity
public class DocumentHistory implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @Column(name="actionType")
    private String actionType;

    @Column(name="remark")
    private String remark;

    @Column(name="status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matter")
    private Matter matter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppUser getCreateBy() {
        return createBy;
    }

    public void setCreateBy(AppUser createBy) {
        this.createBy = createBy;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Matter getMatter() {
        return matter;
    }

    public void setMatter(Matter matter) {
        this.matter = matter;
    }

}
