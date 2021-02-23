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

import backend_challenge.starter.kafka.KafkaSender;
import backend_challenge.starter.services.EmpService;

@RestController
@RequestMapping("/api")
@Api(tags ={"Apis"})
public class Controller {

	@Autowired
	EmpService ser;
	
	@Autowired
	KafkaSender kafkaSender;
	
	
	@ApiOperation("Add Employee")
	@PostMapping(value={"/add"})
	public ResponseEntity<Employee> addEmp(@RequestBody Employee emp){
	
		Employee r = ser.addEmployee(emp);
		return new ResponseEntity<>(r,HttpStatus.CREATED);
	}

	@ApiOperation("Change State")
	@PutMapping(value={"/change"})
	public ResponseEntity<String> changeState(@RequestBody ObjectNode json){
	
		
		String empName =  json.get("name").asText();
		String state =  json.get("state").asText();
		kafkaSender.send(empName,state);
		//Employee e = ser.changeStatus(empName,state);
		return new ResponseEntity<>("Request added to queue successfully",HttpStatus.OK);
	}
	
	@ApiOperation("get all employees")
	@GetMapping(value={"/getAll"})
	public ResponseEntity<List<Employee>> getAllEmployee(){
	
		return new ResponseEntity<>(ser.getAllEmployee(),HttpStatus.OK);
	}
}
