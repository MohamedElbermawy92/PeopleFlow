package backend_challenge.starter.repositry;

import java.util.List;

import org.springframework.stereotype.Repository;

import backend_challenge.starter.controller.Employee;
import io.swagger.annotations.Api;

@Repository
public interface Repo {

	Employee addEmployee(Employee e);
	Employee findEmployee(String name);
	boolean changeStatus( String empName , String state);
	List<Employee> getAllEmployee();
}
