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

    @Column(name="msds")
    private String msds;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="msdsDateTest")
    private Date msdsDateTest;

    @Column(name="spec")
    private String spec;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="specDateTest")
    private Date specDateTest;

    @Column(name="halogen")
    private String halogen;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="halogenDateTest")
    private Date halogenDateTest;

    @Column(name="status")
    private String status;

    @Column(name="folw")
    private String folw;

    @Column(name="ulNumber")
    private String ulNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "materialType")
    private MaterialType materialType;

    @OrderBy("createDate")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "matter")
    private Set<MaterialCode> materialCodes = new HashSet<MaterialCode>();

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

    public String getMsds() {
        return msds;
    }

    public void setMsds(String msds) {
        this.msds = msds;
    }

    public Date getMsdsDateTest() {
        return msdsDateTest;
    }

    public void setMsdsDateTest(Date msdsDateTest) {
        this.msdsDateTest = msdsDateTest;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Date getSpecDateTest() {
        return specDateTest;
    }

    public void setSpecDateTest(Date specDateTest) {
        this.specDateTest = specDateTest;
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
