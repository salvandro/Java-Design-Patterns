package demo2;

import java.util.ArrayList;

interface IObserver
{
	public void update(int updatedValue);
}

class Observer1 implements IObserver
{
	@Override
	public void update(int updatedValue)
	{
		System.out.println("Observer1: myValue in Subject is now: " + updatedValue + ".");
	}
}

class Observer2 implements IObserver
{
	@Override
	public void update(int updatedValue)
	{
		System.out.println("Observer2: observes -> myValue is changed in Subject to: " + updatedValue + ".");
	}
}

interface ISubject
{
	public void register(IObserver observer);
	public void unregister(IObserver observer);
	public void notifyObservers(int updatedValue);
}

class Subject implements ISubject
{
	private ArrayList<IObserver> observersList;
	private int myValue;
	
	Subject()
	{
		observersList = new ArrayList<IObserver>();
	}
	
	public int getMyValue()
	{
		return myValue;
	}
	
	public void setMyValue(int myValue)
	{
		this.myValue = myValue;
		
		// Notify observers.
		notifyObservers(myValue);
	}
	
	@Override
	public void register(IObserver observer)
	{
		observersList.add(observer);
	}
	
	@Override
	public void unregister(IObserver observer)
	{
		observersList.remove(observer);
	}
	
	@Override
	public void notifyObservers(int updatedValue)
	{
		for(int i = 0; i < observersList.size(); i++)
		{
			observersList.get(i)
			             .update(updatedValue);
		}
	}
}

public class ObserverPatternDemo
{
	public static void main(String args[])
	{
		Subject subject1 = new Subject();
		Observer1 observer1 = new Observer1();
		Observer2 observer2 = new Observer2();
		
		System.out.println("***Observer Pattern Demo 2***\n");
		
		subject1.register(observer1);
		subject1.register(observer2);
		
		subject1.setMyValue(5);
		System.out.println();
		
		subject1.setMyValue(25);
		System.out.println();
		
		// Unregister observer1 only.
		subject1.unregister(observer1);
		
		// Now only observer2 will observe the change.
		subject1.setMyValue(100);
	}
}
