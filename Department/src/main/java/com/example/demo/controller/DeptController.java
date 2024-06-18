package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DeptService;

import jakarta.validation.Valid;


@RestController
public class DeptController {
	
	@Autowired 
	//it is autowired since in the saveDepartment method we need obj of service interface. 
	//but if we use new keyword then it will be tightly coupled. in order to avoid 
	//this we are saying spring to give one of the component which it has stored in container while loading
	private DeptService deptservice;

	//defining log
	private final Logger log=LoggerFactory.getLogger(DeptController.class);
	
	
	//done to put data into database @Valid validates incoming request body with already defined constraints and displays message if dept name is not there
	@PostMapping("/department")
	public Department saveDepartment(@Valid @RequestBody Department dept) {
		log.info("Inside saveDepartment of controller");
		return deptservice.saveDepartment(dept);
	}
	
	//done to display data to user
	@GetMapping("department")
	public List<Department> fetchDept(){
		return deptservice.fetchDept();
	}
	
	//to get particular dept using id as input
	@GetMapping("department/{id}")
	public Department fetchDeptById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
		return deptservice.fetchDeptById(deptId);
	}
	
	//delete data
	@DeleteMapping("department/{id}")
	public String deleteDept(@PathVariable("id") Long deptId) {
		deptservice.deleteDept(deptId);
		return "Deleted successfully";
	}
	
	//update data
	@PutMapping("department/{id}")
	public Department updateDept(@PathVariable("id")Long deptId, @RequestBody Department dept) {
		return deptservice.updateDept(deptId, dept);
	}
	
	//get data using deptName
	@GetMapping("department/deptName/{deptName}")
	public Department findDeptByName(@PathVariable("deptName") String deptName) {
		return deptservice.findDeptByName(deptName);
	}
}
