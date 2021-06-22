package com.example.SortinAndPagination.projections;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public interface EmployeeProjectionTwo {
	
	@JsonIgnore
	String getName();

	@JsonIgnore
	String getSalary();

	@JsonAlias("nameAndSalary")
	default String getNameAndSalary() {
		return getName()+" - "+getSalary();
	}
	
	@Value("#{'Omg... ' + target.company}")
	String getCompany();
	
}
