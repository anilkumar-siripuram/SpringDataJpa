package com.example.SortinAndPagination;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.SortinAndPagination.model.Employee;
import com.example.SortinAndPagination.repositories.EmployeeRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SortinAndPaginationApplication  implements CommandLineRunner{
	
	@Autowired
	EmployeeRepository empRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(SortinAndPaginationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		List<Employee> empList = new LinkedList<Employee>();
		empList.add(new Employee(1,"Legato","Aravind",500000, "ASE", null, null,null,null));
		empList.add(new Employee(2,"TCS","Kalpana",500000, "ASE", null, null,null,null));
		empList.add(new Employee(3,"Legato","Mahi",700000, "ASE", null, null,null,null));
		empList.add(new Employee(4,"Legato","Singh",800000, "SE", null, null,null,null));
		empList.add(new Employee(5,"Dell","Dhrona",900000, "SE", null, null,null,null));
		empList.add(new Employee(6,"Dell","Mani",1000000, "SE", null, null,null,null));
		empList.add(new Employee(7,"Dell","Karthk",1100000, "SE", null, null,null,null));
		empList.add(new Employee(8,"Legato","Chaitanya",1200000, "SE", null, null,null,null));
		empList.add(new Employee(9,"Legato","Chawla",1300000, "SSE", null, null,null,null));
		empList.add(new Employee(10,"Legato","Sanjay",1400000, "SSE", null, null,null,null));
		empList.add(new Employee(11,"Legato","Utej",1500000, "SSE", null, null,null,null));
		empList.add(new Employee(12,"Legato","Anuridh",1600000, "SSE", null, null,null,null));
		empList.add(new Employee(13,"Accenture","Mohan",1700000, "SSE", null, null,null,null));
		empList.add(new Employee(14,"Accenture","Kapil",1800000, "SSE", null, null,null,null));
		empList.add(new Employee(15,"Accenture","Seema",1900000, "SSE", null, null,null,null));
		empList.add(new Employee(16,"Accenture","Suhas",2000000, "SSE", null, null,null,null));
		empList.add(new Employee(17,"Accenture","Anjali",2100000, "SSE", null, null,null,null));
		empList.add(new Employee(18,"Legato","Manasa",2200000, "TL", null, null,null,null));
		empList.add(new Employee(19,"Legato","Kavya",2300000, "TL", null, null,null,null));
		empList.add(new Employee(20,"Legato","Vijay",2400000, "TL", null, null,null,null));
		empList.add(new Employee(21,"Legato","Dev",2500000, "TL", null, null,null,null));
		empList.add(new Employee(22,"TCS","Nikhil",2600000, "TL", null, null,null,null));
		empRepo.saveAll(empList);
		
	}

}
