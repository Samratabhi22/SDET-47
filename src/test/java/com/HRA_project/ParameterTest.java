package com.HRA_project;

import org.testng.annotations.Test;

public class ParameterTest {
	@Test
	public void testlavanaya() {
	String URL= System.getProperty("url");
	String USERNAME=System.getProperty("username");
	String BROWSER=System.getProperty("browser");
	String PASSWORD= System.getProperty("password");
	
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(BROWSER);
	System.out.println(PASSWORD);
	
	
	}
}
