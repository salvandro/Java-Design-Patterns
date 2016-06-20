package demo4;

class MakeACaptain
{
	private MakeACaptain()
	{
		
	}
	
	// Bill Pugh solution.
	private static class SingletonHelper
	{
		// Nested class is referenced after getCaptain() is called.
		private static final MakeACaptain captain = new MakeACaptain();
	}
	
	public static MakeACaptain getCaptain()
	{
		return SingletonHelper.captain;
	}
}

public class SingletonPatternDemo
{
	public static void main(String args[])
	{
		System.out.println("***Singleton Pattern Demo 4***\n");
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
