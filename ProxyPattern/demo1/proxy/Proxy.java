package demo1.proxy;

import demo1.original.*;

public class Proxy extends Subject
{
	ConcreteSubject concreteSubject;

	@Override
	public void doSomeWork()
	{
		System.out.println("Proxy call happening now.");
		
		// Lazy initialization.
		if(concreteSubject == null)
		{
			concreteSubject = new ConcreteSubject();
		}
		
		concreteSubject.doSomeWork();
	}
}
