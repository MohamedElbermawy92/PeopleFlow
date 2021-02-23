package backend_challenge.starter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import backend_challenge.starter.ExceptionHandler.ConflictException;
import backend_challenge.starter.ExceptionHandler.NotFoundException;
import backend_challenge.starter.controller.Employee;
import backend_challenge.starter.repositry.Repo;
import io.swagger.annotations.Api;

@Service
public class EmpService implements Repo{

	@Autowired
	Repo repo;
	 List<Employee> list = new ArrayList<Employee>();
	
	public Employee addEmployee(Employee e) {
		
		Employee emp = repo.findEmployee(e.getName());
		
		if(emp == null){
			e.setState(States.A);
			list.add(e);
		}
		else 
			throw new ConflictException("this employee already exist!!!");

		return e;
	}

	public Employee findEmployee(String name) {
		for (Employee employee : list) {
			if(employee.getName().equals(name))
				return employee;
			 
		}
		return null;
	}

	public Employee changeStatus(String empName , String stateName) {
		
		States state =States.fromText(stateName);
		Employee employee = repo.findEmployee(empName);
		if(employee == null)
			throw new NotFoundException("No data found");
			
		employee.setState(state);
		
		return employee;
	}

	public  List<Employee> getAllEmployee() {
		if(list.size()==0)
			throw new NotFoundException("No data found in list");
		return list;
	}
	
	
	 
}
