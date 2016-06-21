package demo1.robotfacade;

import demo1.robotparts.*;

public class RobotFacade
{
	RobotColor robotColor;
	RobotMetal robotMetal ;
	RobotBody robotBody;
	
	public RobotFacade()
	{
		robotColor = new RobotColor();
		robotMetal = new RobotMetal();
		robotBody = new RobotBody();
	}
	
	public void constructRobot(String color,
			                   String metal)
	{
		System.out.println("\nCreation of the robot start.");
		
		robotColor.setColor(color);
		robotMetal.setMetal(metal);
		robotBody.createBody();
		
		System.out.println("\nRobot creation end.");
		System.out.println();
	}
}
