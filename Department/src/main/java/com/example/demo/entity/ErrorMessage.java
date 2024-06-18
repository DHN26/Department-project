package com.example.demo.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ErrorMessage {

	//this is a comment
	private HttpStatus status;
	private String message;
	
	
	
}
