package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DeptRepository;

@Service
public class DeptServiceImplementation implements DeptService{

	@Autowired
	private DeptRepository deptRepository;
	
	@Override
	public Department saveDepartment(Department dept) {
		return deptRepository.save(dept);
	}

	@Override
	public List<Department> fetchDept() {
		
		return deptRepository.findAll();
	}

	@Override
	public Department fetchDeptById(Long deptId) throws DepartmentNotFoundException {
		
		Optional<Department> dept =deptRepository.findById(deptId);
		if(!dept.isPresent()) {
			throw new DepartmentNotFoundException("Department not found");
		}
		else
			return dept.get();
	}

	

	@Override
	public void deleteDept(Long deptId) {
		deptRepository.deleteById(deptId);
		
	}

	@Override
	public Department updateDept(Long deptId, Department dept) {
		//This line fetches the existing department from the database using its ID. 
		//The deptRepository.findById(deptId) returns an Optional<Department>, and the .get() method retrieves the Department object from the Optional
		Department deptDb=deptRepository.findById(deptId).get();
		
		//These conditionals check if the corresponding fields in the input Department object (dept) are non-null and non-empty.
		if(Objects.nonNull(dept.getDeptName()) &&
				!"".equalsIgnoreCase(dept.getDeptName())) {
			deptDb.setDeptName(dept.getDeptName());
		}
		
		if(Objects.nonNull(dept.getDeptCode()) &&
				!"".equalsIgnoreCase(dept.getDeptCode())) {
			deptDb.setDeptCode(dept.getDeptCode());
		}
		
		if(Objects.nonNull(dept.getDeptAddress()) &&
				!"".equalsIgnoreCase(dept.getDeptAddress())) {
			deptDb.setDeptAddress(dept.getDeptAddress());
		}
		
		return deptRepository.save(deptDb);
	}

	@Override
	public Department findDeptByName(String deptName) {
		return deptRepository.findByDeptNameIgnoreCase(deptName);
	}

	

}
