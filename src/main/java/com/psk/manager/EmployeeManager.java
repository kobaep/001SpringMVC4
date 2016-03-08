package com.psk.manager;

import com.psk.domain.Employee;

import java.util.List;

/**
 * Created by apichat on 3/8/2016 AD.
 */
public interface EmployeeManager {

    public void insertEmployee(Employee employee);

    public List<Employee> findAllEmployee();
}
