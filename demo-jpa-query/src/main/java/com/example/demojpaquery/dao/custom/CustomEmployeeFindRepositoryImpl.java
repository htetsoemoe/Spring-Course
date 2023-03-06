package com.example.demojpaquery.dao.custom;

import com.example.demojpaquery.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CustomEmployeeFindRepositoryImpl implements CustomEmployeeFindRepository{
   @Autowired
   private EntityManager entityManager;

    @Override
    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        System.out.println("Starting custom implementation of findByFirstNameAndLastName.");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.where(
                criteriaBuilder.and(
                criteriaBuilder.equal(employeeRoot.get("firstName"), firstName),
                criteriaBuilder.equal(employeeRoot.get("lastName"), lastName)
                )
        );

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
