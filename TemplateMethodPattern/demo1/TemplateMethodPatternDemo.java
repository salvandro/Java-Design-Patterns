package demo1;

import demo1.engineering.papers.*;

public class TemplateMethodPatternDemo
{
	public static void main(String args[])
	{
		BasicEngineering basicEngineering = new ComputerScience();
		
		System.out.println("***Template Method Pattern Demo 1***\n");
		
		System.out.println("Computer Sciene Papers:");
		basicEngineering.papers();
		System.out.println();
		
		basicEngineering = new Electronics();
		System.out.println("Electronics Papers:");
		basicEngineering.papers();
	}
}
