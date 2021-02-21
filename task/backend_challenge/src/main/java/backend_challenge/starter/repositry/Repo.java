package backend_challenge.starter.repositry;

import org.springframework.stereotype.Repository;

import backend_challenge.starter.controller.Employee;

@Repository
public interface Repo {

	Employee addEmployee(Employee e);
	Employee findEmployee(String name);
	Employee changeStatus( String empName , String state);
}
