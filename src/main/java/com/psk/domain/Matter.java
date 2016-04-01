package com.psk.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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

    @Column(name="materialName")
    private String materialName;

    @Column(name="manufacturing")
    private String manufacturing;

    @Column(name="rohs")
    private String rohs;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="rohsDateTest")
    private Date rohsDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="rohsAlertDateTest")
    private Date rohsAlertDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="rohsEndDateTest")
    private Date rohsEndDateTest;

    @Column(name="msds")
    private String msds;

    @Column(name="spec")
    private String spec;

    @Column(name="halogen")
    private String halogen;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="halogenDateTest")
    private Date halogenDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="halogenAlertDateTest")
    private Date halogenAlertDateTest;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="halogenEndDateTest")
    private Date halogenEndDateTest;

    @Column(name="status")
    private String status;

    @Column(name="folw")
    private String folw;

    @Column(name="ulNumber")
    private String ulNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @Column(name="reason")
    private String reason;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<MaterialCode> materialCodes = new HashSet<MaterialCode>();

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<DocumentHistory> documentHistorys = new HashSet<DocumentHistory>();

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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }

    public String getRohs() {
        return rohs;
    }

    public void setRohs(String rohs) {
        this.rohs = rohs;
    }

    public Date getRohsDateTest() {
        return rohsDateTest;
    }

    public void setRohsDateTest(Date rohsDateTest) {
        this.rohsDateTest = rohsDateTest;
    }

    public Date getRohsAlertDateTest() {
        return rohsAlertDateTest;
    }

    public void setRohsAlertDateTest(Date rohsAlertDateTest) {
        this.rohsAlertDateTest = rohsAlertDateTest;
    }

    public Date getRohsEndDateTest() {
        return rohsEndDateTest;
    }

    public void setRohsEndDateTest(Date rohsEndDateTest) {
        this.rohsEndDateTest = rohsEndDateTest;
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

    public Date getHalogenDateTest() {
        return halogenDateTest;
    }

    public void setHalogenDateTest(Date halogenDateTest) {
        this.halogenDateTest = halogenDateTest;
    }

    public Date getHalogenAlertDateTest() {
        return halogenAlertDateTest;
    }

    public void setHalogenAlertDateTest(Date halogenAlertDateTest) {
        this.halogenAlertDateTest = halogenAlertDateTest;
    }

    public Date getHalogenEndDateTest() {
        return halogenEndDateTest;
    }

    public void setHalogenEndDateTest(Date halogenEndDateTest) {
        this.halogenEndDateTest = halogenEndDateTest;
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

    public String getUlNumber() {
        return ulNumber;
    }

    public void setUlNumber(String ulNumber) {
        this.ulNumber = ulNumber;
    }

    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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
}
