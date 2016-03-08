package com.psk.service;

import com.psk.dao.EmployeeDAO;
import com.psk.domain.Employee;
import com.psk.manager.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by apichat on 3/7/2016 AD.
 */
@Service
public class EmployeeService implements EmployeeManager{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public void insertEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }
}
