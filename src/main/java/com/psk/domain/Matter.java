package com.psk.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by apichat on 3/8/2016 AD.
 */
@Table(name="Matter")
@Entity
public class Matter implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="createDate")
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="updateDate")
    private Date updateDate;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser createBy;

    @OneToOne(fetch = FetchType.EAGER)
    private AppUser updateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Column(name="endDate")
    private Date endDate;

    @Column(name="materialName")
    private String materialName;

    @Column(name="rohs")
    private String rohs;

    @Column(name="msds")
    private String msds;

    @Column(name="spec")
    private String spec;

    @Column(name="halogen")
    private String halogen;

    @Column(name="status")
    private String status;

    @Column(name="folw")
    private String folw;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<MaterialCode> materialCodes;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<DocumentHistory> documentHistorys;

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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AppUser getCreateBy() {
        return createBy;
    }

    public void setCreateBy(AppUser createBy) {
        this.createBy = createBy;
    }

    public AppUser getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(AppUser updateBy) {
        this.updateBy = updateBy;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getRohs() {
        return rohs;
    }

    public void setRohs(String rohs) {
        this.rohs = rohs;
    }

    public String getMsds() {
        return msds;
    }

    public void setMsds(String msds) {
        this.msds = msds;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getHalogen() {
        return halogen;
    }

    public void setHalogen(String halogen) {
        this.halogen = halogen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFolw() {
        return folw;
    }

    public void setFolw(String folw) {
        this.folw = folw;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public Set<MaterialCode> getMaterialCodes() {
        return materialCodes;
    }

    public void setMaterialCodes(Set<MaterialCode> materialCodes) {
        this.materialCodes = materialCodes;
    }

    public Set<DocumentHistory> getDocumentHistorys() {
        return documentHistorys;
    }

    public void setDocumentHistorys(Set<DocumentHistory> documentHistorys) {
        this.documentHistorys = documentHistorys;
    }

    @Override
    public String toString() {
        return "Matter{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", endDate=" + endDate +
                ", materialName='" + materialName + '\'' +
                ", rohs='" + rohs + '\'' +
                ", msds='" + msds + '\'' +
                ", spec='" + spec + '\'' +
                ", halogen='" + halogen + '\'' +
                ", status='" + status + '\'' +
                ", folw='" + folw + '\'' +
                ", materialType=" + materialType +
                ", materialCodes=" + materialCodes +
                ", documentHistorys=" + documentHistorys +
                '}';
    }
}
