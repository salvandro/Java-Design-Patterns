package demo1.aggregate;

import demo1.iterator.*;
import java.util.LinkedList;

public class Science implements ISubject
{
	private LinkedList<String> subjects;
	
	public Science()
	{
		subjects = new LinkedList<String>();
		
		subjects.addLast("Maths");
		subjects.addLast("Computer Science");
		subjects.addLast("Physics");
	}
	
	@Override
	public IIterator createIterator()
	{
		return new ScienceIterator(subjects);
	}
	
	// Containing the ScienceIterator.
	public class ScienceIterator implements IIterator
	{
		private LinkedList<String> subjects;
		private int position;
		
		public ScienceIterator(LinkedList<String> subjects)
		{
			this.subjects = subjects;
			position = 0;
		}
		
		public void first()
		{
			position = 0;
		}
		
		public String next()
		{
			return subjects.get(position++);
		}
		
		public Boolean isDone()
		{
			return position >= subjects.size();
		}
		
		public String currentItem()
		{
			return subjects.get(position);
		}
	}
}
