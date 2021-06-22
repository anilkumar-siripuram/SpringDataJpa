package com.example.SortinAndPagination.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.SortinAndPagination.model.Employee;
import com.example.SortinAndPagination.projections.EmployeeProjection;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>, QuerydslPredicateExecutor<Employee>  {
	
	Page<Employee> findByCompany(String companyName, Pageable pageable);
	
	Slice<Employee> findByCompanyOrderByCompany(String companyName, Pageable pageable);
	
	<T> List<T>	findByNameLike(String name,Class<T> type);

}
