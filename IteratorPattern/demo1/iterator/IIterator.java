package demo1.iterator;

public interface IIterator
{
	public void first(); // Reset to first element.
	public String next(); // Get next element.
	public Boolean isDone(); // End of collection check.
	public String currentItem(); // Retrieve current item.
}
