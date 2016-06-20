package demo1;

import java.util.ArrayList;

class Observer
{
	public void update()
	{
		System.out.println("flag value changed in Subject.");
	}
}

interface ISubject
{
	public void register(Observer observer);
	public void unregister(Observer observer);
	public void notifyObservers();
}

class Subject implements ISubject
{
	private ArrayList<Observer> observersList;
	private int flag;
	
	Subject()
	{
		observersList = new ArrayList<Observer>();
	}
	
	public int getFlag()
	{
		return flag;
	}
	
	public void setFlag(int flag)
	{
		this.flag = flag;
		
		// flag value changed.
		// So notify observer(s).
		notifyObservers();
	}
	
	@Override
	public void register(Observer observer)
	{
		observersList.add(observer);
	}
	
	@Override
	public void unregister(Observer observer)
	{
		observersList.remove(observer);
	}
	
	@Override
	public void notifyObservers()
	{
		for(int i = 0; i < observersList.size(); i++)
		{
			observersList.get(i)
			             .update();
		}
	}
}

public class ObserverPatternDemo
{
	public static void main(String args[])
	{
		Subject subject1 = new Subject();
		Observer observer1 = new Observer();
		
		System.out.println("***Observer Pattern Demo 1***\n");
		
		subject1.register(observer1);
		
		System.out.println("Setting flag = 5.");
		subject1.setFlag(5);
		
		System.out.println("Setting flag = 25.");
		subject1.setFlag(25);
		
		subject1.unregister(observer1);
		
		// No notification this time to o1.
		// Since it is unregistered.
		System.out.println("Setting flag = 50.");
		subject1.setFlag(50);
	}
}
