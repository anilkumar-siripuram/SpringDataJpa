package com.example.SortinAndPagination.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> role;
	public static volatile SingularAttribute<Employee, LocalDateTime> dateCreated;
	public static volatile SingularAttribute<Employee, String> createdBy;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, String> company;
	public static volatile SingularAttribute<Employee, LocalDateTime> dateModified;
	public static volatile SingularAttribute<Employee, String> modifiedBy;
	public static volatile SingularAttribute<Employee, Long> id;
	public static volatile SingularAttribute<Employee, Long> salary;

	public static final String ROLE = "role";
	public static final String DATE_CREATED = "dateCreated";
	public static final String CREATED_BY = "createdBy";
	public static final String NAME = "name";
	public static final String COMPANY = "company";
	public static final String DATE_MODIFIED = "dateModified";
	public static final String MODIFIED_BY = "modifiedBy";
	public static final String ID = "id";
	public static final String SALARY = "salary";

}

