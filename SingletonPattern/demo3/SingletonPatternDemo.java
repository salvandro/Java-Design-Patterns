package demo3;

class MakeACaptain
{
	// Early initialization.
	private static MakeACaptain captain = new MakeACaptain();
	
	// We make the constructor private to prevent the use of "new".
	private MakeACaptain()
	{
		
	}
	
	// Global point of access MakeACaptain.getCaptain() is a public static method.
	public static MakeACaptain getCaptain()
	{
		return captain;
	}
}

public class SingletonPatternDemo
{
	public static void main(String args[])
	{
		System.out.println("***Singleton Pattern Demo 3***\n");
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
