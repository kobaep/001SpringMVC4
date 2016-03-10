package com.psk.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by apichat on 3/9/2016 AD.
 */
@Table(name="AppUser")
@Entity
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="username", unique = true)
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="department")
    private String department;

    @Column(name="departmentCode")
    private String departmentCode;

    @Column(name="emailAddress")
    private String emailAddress;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Value("1")
    @Column(name="enabled")
    private Integer enabled;

    @Column(name="roleName")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enabled=" + enabled +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
