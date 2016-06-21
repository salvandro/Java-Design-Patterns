package demo2;

interface IIntegerValue
{
	public int getInteger();
}

class IntegerValue implements IIntegerValue
{
	@Override
	public int getInteger()
	{
		return 5;
	}
}

class ClassAdapter extends IntegerValue
{
	// Incrementing by 2.
	public int getInteger()
	{
		return 2 + super.getInteger();
	}
}

class ObjectAdapter
{
	private IIntegerValue myInt;
	
	public ObjectAdapter(IIntegerValue myInt)
	{
		this.myInt = myInt;
	}
	
	// Incrementing by 2.
	public int getInteger()
	{
		return 2 + this.myInt
				       .getInteger();
	}
}

public class ClassAndObjectAdapter
{
	public static void main(String args[])
	{
		ClassAdapter classAdapter1 = new ClassAdapter();
		ClassAdapter classAdapter2 = new ClassAdapter();
		ObjectAdapter objectAdapter = new ObjectAdapter(new IntegerValue());
		
		System.out.println("***Class and Object Adapter Demo 2***");
		
		System.out.println("Class Adapter is returning: " + classAdapter1.getInteger());
		
		System.out.println("Object Adapter is returning: " + objectAdapter.getInteger());
	}
}
