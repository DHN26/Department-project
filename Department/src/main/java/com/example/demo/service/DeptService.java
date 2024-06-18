package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DeptService {

	public Department saveDepartment(Department dept);

	public List<Department> fetchDept();

	public Department fetchDeptById(Long deptId) throws DepartmentNotFoundException;

	public void deleteDept(Long deptId);

	public Department updateDept(Long deptId, Department dept);

	public Department findDeptByName(String deptName);
	
	

}
