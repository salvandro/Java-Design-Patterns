package demo1.engineering.papers;

public abstract class BasicEngineering
{
	// Papers() in the template method.
	public void papers()
	{
		// Common papers.
		math();
		softSkills();
		
		// Specialized paper.
		specialPaper();
	}
	
	// Non-Abstract method Math(), SoftSkills() are already implemented by Template class.
	private void math()
	{
		System.out.println("Mathematics.");
	}
	
	private void softSkills()
	{
		System.out.println("SoftSkills.");
	}
	
	// Abstract method SpecialPaper() must be implemented in derived classes.
	public abstract void specialPaper();
}
