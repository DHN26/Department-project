package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.entity.Department;



@DataJpaTest
public class DeptRepositoryTest {

	@Autowired
	private DeptRepository deptRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setup()
	{
		Department dept=Department.builder().
				deptName("HR").deptAddress("Ahmedabad").deptCode("d-05")
				.build();
		//while dealing with repo instead of using Mockito entity manager is used to mock DB data
		entityManager.persist(dept);
	}
	
	@Test
	public void whenFindById_thenREturnDept()
	{
		Department dept=deptRepository.findById(1L).get();
		assertEquals(dept.getDeptName(), "HR");
	}
}
