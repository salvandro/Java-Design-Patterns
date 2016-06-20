package demo1;

abstract class Component
{
	public abstract void doJob();
}

class ConcreteComponent extends Component
{
	@Override
	public void doJob()
	{
		System.out.println("I am from ConcreteComponent. I am closed for modification.");
	}
}

abstract class AbstractDecorator extends Component
{
	protected Component component;
	
	public void SetComponent(Component component)
	{
		this.component = component;
	}
	
	public void doJob()
	{
		if(component != null)
		{
			component.doJob();
		}
	}
}

class ConcreteDecoratorEx_1 extends AbstractDecorator
{
	public void doJob()
	{
		super.doJob();
		
		// Add additional thing if necessary.
		System.out.println("I am explicitly from ConcreteDecoratorEx_1.");
	}
}

class ConcreteDecoratorEx_2 extends AbstractDecorator
{
	public void doJob()
	{
		System.out.println("");
		System.out.println("***START ConcreteDecoratorEx_2***");
		
		super.doJob();
		
		// Add additional thing if necessary.
		System.out.println("Explicitly From ConcreteDecoratorEx_2.");
		System.out.println("***END ConcreteDecoratorEX_2***");
	}
}

public class DecoratorPatternDemo
{
	public static void main(String args[])
	{
		ConcreteComponent concreteComponent = new ConcreteComponent();
		ConcreteDecoratorEx_1 concreteDecoratorEx_1 = new ConcreteDecoratorEx_1();
		ConcreteDecoratorEx_2 concreteDecoratorEx_2 = new ConcreteDecoratorEx_2();
		
		System.out.println("***Decorator Pattern Demo 1***");
		
		// Decorating ConcreteComponent object concreteComponent with ConcreteDecoratorEx_1.
		concreteDecoratorEx_1.SetComponent(concreteComponent);
		concreteDecoratorEx_1.doJob();
		
		// Decorating ConcreteComponent object concreteComponent with ConcreteDecoratorEx_1 and
		// ConcreteDecoratorEx_2.
		concreteDecoratorEx_2.SetComponent(concreteDecoratorEx_1); // Adding results from concreteDecoratorEx_1 now.
		concreteDecoratorEx_2.doJob();
	}
}
