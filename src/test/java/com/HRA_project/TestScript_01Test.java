package com.HRA_project;




import org.testng.annotations.Test;


public class TestScript_01Test {
	@Test(groups="regression")
	public void test1() {
		System.out.println("From test1");
	}
	@Test(groups="regression")
	public void test2() {
		System.out.println("From test2");
	}
	@Test(groups="smoke")
	public void test3() {
		System.out.println("From test3");
	
}
}
