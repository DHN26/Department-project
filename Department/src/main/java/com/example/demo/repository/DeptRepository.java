package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long>{

	//defined by us (JPQL)
	public Department findByDeptNameIgnoreCase(String deptName);
	

	//@Query(value="..whatever sql query.." nativeQuery=true)
	//use default methods in repo if not JPQL or write sql queries
}
