package com.example.SortinAndPagination.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SortinAndPagination.model.Employee;
import com.example.SortinAndPagination.projections.EmployeeProjection;
import com.example.SortinAndPagination.projections.EmployeeProjectionTwo;
import com.example.SortinAndPagination.repositories.EmployeeRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
//import com.swyrik.SortinAndPagination.model.Employee_;

@RestController
public class JpaController {

	@Autowired
	EmployeeRepository empRepo;

	@GetMapping("/sortDefault")
	public List<Employee> getEmployeeNameSorted() {
		return empRepo.findAll(Sort.by("name").ascending());
	}

	@GetMapping("/sortByNamePageReq/{company}")
	public Page<Employee> sortByNamePageReq(@PathVariable("company") String company) {
		return empRepo.findByCompany(company, PageRequest.of(0, 2, Sort.by("name").ascending()));
	}

	@GetMapping("/sortByNameSliceReq/{company}")
	public Slice<Employee> sortByNameSliceReq(@PathVariable("company") String company) {
		return empRepo.findByCompanyOrderByCompany(company, PageRequest.of(0, 2, Sort.by("company").ascending()));
	}

	@PostMapping("/addEmp")
	public Employee sortByNameSliceReq(@RequestBody Employee emp) {
		return empRepo.save(emp);
	}

	@GetMapping("/projection")
	public List<EmployeeProjection> projectionWithName() {
		return empRepo.findByNameLike("A%", EmployeeProjection.class);
	}

	@GetMapping("/projection2")
	public List<EmployeeProjectionTwo> projectionWithNameTwo() {
		return empRepo.findByNameLike("A%", EmployeeProjectionTwo.class);
	}

	@GetMapping("/specification/{company}")
	public List<Employee> specification(@PathVariable("company") String company) {
		return empRepo.findAll((Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

			
			Predicate equal = cb.equal(root.get("company"), company);
			Predicate like = cb.like(root.get("name"), "A%");
			return cb.and(equal, like);
		});
	}
	
	@GetMapping("/queryDsl")
	public List<Employee> queryDsl() {
		BooleanExpression booleanExpression = com.example.SortinAndPagination.model.QEmployee.employee.salary.goe(2000000);
	      OrderSpecifier<Long> orderSpecifier = com.example.SortinAndPagination.model.QEmployee.employee.salary.asc();
	      List<Employee> employees2 = (List<Employee>) empRepo.findAll(booleanExpression, orderSpecifier);
	      return employees2;
	}

}
