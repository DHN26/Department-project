package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.entity.Department;
import com.example.demo.repository.DeptRepository;

@SpringBootTest
public class DeptServiceTest {

	@Autowired
	private DeptService deptService;
	
	@MockBean
	private DeptRepository deptRepository;
	
	@BeforeEach
	void setup()
	{
		Department dept=Department.builder().deptName("HR")
				.deptAddress("Bengaluru")
				.deptCode("d-01")
				.deptId(1L)
				.build();
		Mockito.when(deptRepository.findByDeptNameIgnoreCase("HR")).thenReturn(dept);
	}
	
//	WORKING : In your test method, when you call deptService.findDeptByName(department), 
//	it internally invokes deptRepository.findByDeptNameIgnoreCase("HR") (assuming that's 
//	the behavior of findDeptByName). However, instead of actually hitting the database, 
//	it's intercepted by Mockito, and the predefined dept object is returned, mimicking the 
//	behavior of the repository method.
	
	@Test //When you run your test suite, JUnit will execute all methods annotated with @Test.
	@DisplayName("Get data based on valid name")
	//@Disabled --> used when we need to disable this particular test case out of others
	public void whenValidDepartment_thenDepartmentShouldFound()
	{
		String department="HR";
		Department found=
				deptService.findDeptByName(department);
		assertEquals(department, found.getDeptName());
	}
}
