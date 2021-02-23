package backend_challenge.starter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.fasterxml.jackson.databind.node.ObjectNode;

import backend_challenge.starter.services.EmpService;

@RestController
@RequestMapping("/api")
@Api(tags ={"Apis"})
public class Controller {

	@Autowired
	EmpService service;
	
	@ApiOperation("Add Employee")
	@PostMapping(value={"/add"})
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
	
		Employee r = service.addEmployee(emp);
		return new ResponseEntity<>(r,HttpStatus.CREATED);
		//return (r)?new ResponseEntity<>("Employee added successfully",HttpStatus.CREATED):new ResponseEntity<>("Failed to create employee",HttpStatus.BAD_REQUEST);
	}

	@ApiOperation("Change State")
	@PutMapping(value={"/change"})
	public ResponseEntity<Employee> changeState(@RequestBody ObjectNode json){
	
		String empName =  json.get("name").asText();
		String state =  json.get("state").asText();
		Employee e = service.changeStatus(empName,state);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@ApiOperation("get all employees")
	@GetMapping(value={"/getAll"})
	public ResponseEntity<List<Employee>> getAllEmployee(){
	
		return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
	}
}
