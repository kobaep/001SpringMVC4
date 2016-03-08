package com.psk.dao;

import com.psk.domain.Employee;

import java.util.List;

/**
 * Created by apichat on 3/7/2016 AD.
 */
public interface EmployeeDAO {

    public void insertEmployee(Employee employee);

    public List<Employee> findAllEmployee();
}
