package com.example.demo.error;

public class DepartmentNotFoundException extends Exception{
	public DepartmentNotFoundException(String msg)
	{
		super(msg);
	}
}
