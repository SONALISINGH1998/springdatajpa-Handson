package com.cognizant.ormlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Set;
import java.util.Date;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
@SpringBootApplication
public class OrmLearnApplication {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);	
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	
public static void main(String[] args)  {
	ApplicationContext context=SpringApplication.run(OrmLearnApplication.class, args);
	
	employeeService=context.getBean(EmployeeService.class);
	departmentService=context.getBean(DepartmentService.class);
	skillService=context.getBean(SkillService.class);
	testGetEmployee();
	testAddEmployee();
	testUpdateEmployee();
	testGetDepartment();
	testAddSkillToEmployee();
	testGetAllPermanentEmployees() ;
	testGetAverageSalary();
	testAllEmployeesNative();
	testFindEmployeesByName();
	
}
private static void testGetEmployee() {
	
	LOGGER.info("Start");
	Employee employee = employeeService.get(1);
	LOGGER.debug("Employee:{}", employee);
	LOGGER.debug("Department:{}", employee.getDepartment());
	LOGGER.debug("Skills:{}", employee.getSkillList());
	LOGGER.info("End");

}

	
	public static void testAddEmployee()
	{
		LOGGER.info("Start");
		LOGGER.info("Insert new Employee:");
		Employee employee=new Employee();
		employee.setDateOfBirth(new Date());
		employee.setName("sanky");
		employee.setPermanent(true);
		employee.setSalary(100000);
		employee.setDepartment(departmentService.get(1));		
		employeeService.save(employee);
		LOGGER.info("End");		
				
	}
	
	public static void testUpdateEmployee()
	{
		LOGGER.info("Start");	
		LOGGER.info("Before update:");
		Employee e=employeeService.get(1);
		LOGGER.debug("employee:{}",e);
		Department d=departmentService.get(3);
		
		e.setDepartment(d);		
		employeeService.save(e);
		LOGGER.info("After update:");
		LOGGER.info("employee:{}",e);
		LOGGER.info("End");	
		
		
	}
	
	public static void testGetDepartment()
	{
		Department department=departmentService.get(3);
		LOGGER.debug("department:{}",department);
		Set<Employee> employees=department.getEmployeeList();		
		LOGGER.debug("employees:{}",employees);
	}
	
	public static void  testAddSkillToEmployee()
	{
		Employee e=employeeService.get(4);
		Skill s=skillService.get(1);
		
		Set<Skill> skillList = e.getSkillList();
		skillList.add(s);
		
		employeeService.save(e);
		
	}
	
	 public static void testGetAllPermanentEmployees() {

		 LOGGER.info("Start");
		 List<Employee> employees = employeeService.getAllPermanentEmployees();
		 LOGGER.debug("Permanent Employees:{}", employees);
		 employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		 LOGGER.info("End");

		 } 
	 
	 public static void testGetAverageSalary() {
		 LOGGER.info("Start");
		 LOGGER.debug("Avg Salary:{}", employeeService.getAverageSalary(1));
		 LOGGER.info("End");
	 
	 }
	 
	 public static void testAllEmployeesNative() {
		 LOGGER.info("Start");
		 LOGGER.debug("Employees:{}", employeeService.getAllEmployeesNative());
		 LOGGER.info("End");
	 
	 }
	 
	 public static void testFindEmployeesByName()
	 {
		 LOGGER.info("Start");
		 LOGGER.debug("Employees:{}", employeeService.findEmployeesByName("Jack"));
		 LOGGER.info("End");		 
	 }
	
	
}


