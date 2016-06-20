package demo1;

class MakeACaptain
{
	private static MakeACaptain captain;
	
	// We make the constructor private to prevent the use of "new".
	private MakeACaptain()
	{
		
	}
	
	public static MakeACaptain getCaptain()
	{
		// Lazy initialization.
		if(captain == null)
		{
			captain = new MakeACaptain();
			System.out.println("New Captain selected for our team.");
		}
		else
		{
			System.out.print("You already have a captain for your team.");
			System.out.println("Send him for the toss.");
		}
		
		return captain;
	}
}

public class SingletonPatternDemo
{
	public static void main(String args[])
	{
		System.out.println("***Singleton Pattern Demo 1***\n");
		System.out.println("Trying to make a captain for our team.");
		
		MakeACaptain captain1 = MakeACaptain.getCaptain();
		
		System.out.println("Trying to make another captain for our team.");
		
		MakeACaptain captain2 = MakeACaptain.getCaptain();
		
		if(captain1 == captain2)
		{
			System.out.println("captain1 and captain2 are same instance.");
		}
	}
}
