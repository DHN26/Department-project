package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.entity.Department;
import com.example.demo.service.DeptService;
import com.mysql.cj.x.protobuf.MysqlxResultset.ContentType_BYTES;

@WebMvcTest(DeptController.class)
public class DeptControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DeptService deptService;

	private Department dept;

	@BeforeEach
	void setup() {

		dept = Department.builder().deptName("HR").deptAddress("Bengaluru").deptId(1L).build();

	}

//	@Test
//	void saveDepartment() {
//
//		Department inputdept = Department.builder().deptName("HR").deptAddress("Bengaluru")
//				.build();
//		Mockito.when(deptService.saveDepartment(inputdept)).thenReturn(dept);
//		
//		mockMvc.perform(post("/department")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(""
//					+ "{\r\n"
//					+ "    \"deptName\":\"HR\",\r\n"
//					+ "    \"deptAddress\":\"Bangalore\",\r\n"
//					+ "    \"deptCode\":\"d-07\"\r\n"
//					+ "}")).andExpect(status().isOk());
//	}

//	@Test
//	void fetchDeptById() {
//			Mockito.when(deptService.fetchDeptById(1L)).thenReturn(dept);
//		
//			 mockMvc.perform(get("/department/1")
//			.contentType(MediaType.APPLICATION_JSON))
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("$.deptName").
//					value(dept.getDeptName()));
//	}
}
