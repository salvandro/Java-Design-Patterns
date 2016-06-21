package demo1;

import demo1.robotfacade.RobotFacade;

public class FacadePatternDemo
{
	public static void main(String args[])
	{
		System.out.println("***Facade Pattern Demo 1***");
		
		RobotFacade robotFacade1 = new RobotFacade();
		robotFacade1.constructRobot("Green",
				                    "Iron");
		
		RobotFacade robotFacade2 = new RobotFacade();
		robotFacade2.constructRobot("Blue",
				                    "Steel");
	}
}
