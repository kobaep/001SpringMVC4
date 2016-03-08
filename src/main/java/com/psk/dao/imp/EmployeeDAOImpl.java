package com.psk.dao.imp;

import com.psk.dao.EmployeeDAO;
import com.psk.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by apichat on 3/7/2016 AD.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public List<Employee> findAllEmployee() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
}
