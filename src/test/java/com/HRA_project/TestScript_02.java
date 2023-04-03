package com.HRA_project;


import org.testng.annotations.Test;

public class TestScript_02 {
	@Test
	public void createAgain()
	{
		System.out.println("---Project createdAgain ---");
	}
	@Test(groups="smoke")
	public void modifyAgain()
	{
		System.out.println("---Project modifiedAgain---");
	}
	@Test(groups="regression")
	public void deleteAgain()
	{
		System.out.println("---Project deletedAgain---");
	}
}
