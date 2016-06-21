package demo1;

import demo1.aggregate.*;
import demo1.iterator.*;

public class IteratorPatternDemo
{
	public static void main(String args[])
	{
		ISubject scienceSubject = new Science();
		ISubject artsSubjects = new Arts();
		IIterator scienceIterator = scienceSubject.createIterator();
		IIterator artsIterator = artsSubjects.createIterator();
		
		System.out.println("***Iterator Pattern Demo 1***\n");
		
		System.out.println("\nScience subjects: ");
		Print(scienceIterator);
		
		System.out.println("\nArts subjects: ");
		Print(artsIterator);
	}
	
	public static void Print(IIterator iterator)
	{
		while (!iterator.isDone())
		{
			System.out.println(iterator.next());
		}
	}
}
