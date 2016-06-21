package demo1;

interface IAnimal
{
	public void speak();
}

class Duck implements IAnimal
{
	@Override
	public void speak()
	{
		System.out.println("Duck says: Pack-pack.");
	}
}

class Tiger implements IAnimal
{
	@Override
	public void speak()
	{
		System.out.println("Tiger says: Halum..Halum.");
	}
}

abstract class IAnimalFactory
{
	public abstract IAnimal
	
	/* if we cannot instantiate in later stage, we'll throw exception. */
	getAnimalType(String type) throws Exception;
}

class ConcreteFactory extends IAnimalFactory
{
	@Override
	public IAnimal getAnimalType(String type) throws Exception
	{
		switch(type)
		{
			case "Duck":
				return new Duck();
			case "Tiger":
				return new Tiger();
			default:
				throw new Exception("Animal type: " + type + " cannot be instantiated.");
		}
	}
}

public class FactoryMethodPatternDemo
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("***Factory Method Pattern Demo 1***\n");
		
		IAnimalFactory animalFactory = new ConcreteFactory();
		IAnimal DuckType = animalFactory.getAnimalType("Duck");
		
		DuckType.speak();
		
		IAnimal TigerType = animalFactory.getAnimalType("Tiger");
		
		TigerType.speak();
		
		// There is no Lion type. So, an exception will be thrown.
		IAnimal LionType = animalFactory.getAnimalType("Lion");
		
		LionType.speak();
	}
}
