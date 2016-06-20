package demo3;

import java.util.ArrayList;

interface IObserver
{
	public void update(String subjectName,
			           int    updatedValue);
}

class Observer1 implements IObserver
{
	@Override
	public void update(String subjectName,
			           int    updatedValue)
	{
		System.out.println("Observer1: myValue in " + subjectName + " is now: " + updatedValue + ".");
	}
}

class Observer2 implements IObserver
{
	@Override
	public void update(String subjectName,
			           int    updatedValue)
	{
		System.out.println("Observer2: observes -> myValue is changed in " + subjectName + " to: " + updatedValue + ".");
	}
}

class Observer3 implements IObserver
{
	@Override
	public void update(String subjectName,
			           int    updatedValue)
	{
		System.out.println("Observer3 is observing: myValue is changed in " + subjectName + " to: " + updatedValue + ".");
	}
}

interface ISubject
{
	public void register(IObserver observer);
	public void unregister(IObserver observer);
	public void notifyObservers(int updatedValue);
}

class Subject1 implements ISubject
{
	private ArrayList<IObserver> observersList;
	private int myValue;
	
	Subject1()
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
			             .update(this.getClass()
			            		     .getSimpleName(),
					             updatedValue);
		}
	}
}

class Subject2 implements ISubject
{
	private ArrayList<IObserver> observersList;
	private int myValue;
	
	Subject2()
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
			             .update(this.getClass()
			            		     .getSimpleName(),
					             updatedValue);
		}
	}
}

public class ObserverPatternDemo
{
	public static void main(String args[])
	{
		Subject1 subject1 = new Subject1();
		Subject2 subject2 = new Subject2();
		Observer1 observer1 = new Observer1();
		Observer2 observer2 = new Observer2();
		Observer3 observer3 = new Observer3();
		
		System.out.println("***Observer Pattern Demo 3***\n");
		
		// observer1 and observer2 registers to subject1.
		subject1.register(observer1);
		subject1.register(observer2);
		
		// observer2 and observer3 registers to subject2.
		subject2.register(observer2);
		subject2.register(observer3);
		
		// Set new value to subject1.
		// observer1 and observer2 get notification.
		subject1.setMyValue(50);
		System.out.println();
		
		// Set new value to subject2.
		// observer2 and observer3 get notification.
		subject2.setMyValue(250);
		System.out.println();
		
		// Unregister observer2 from subject1.
		subject1.unregister(observer2);
		
		// Set new value to subject1 and only observer1 is notified.
		subject1.setMyValue(550);
		System.out.println();
		
		// observer2 can still notice change in subject2.
		subject2.setMyValue(750);
	}
}
