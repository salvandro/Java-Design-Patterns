package demo1;

class Memento
{
	private String state;
	
	public Memento(String state)
	{
		this.state = state;
	}
	
	public String getState()
	{
		return state;
	}
}

class Originator
{
	private String state;
	Memento memento;
	
	public void setState(String state)
	{
		this.state = state;
		System.out.println("State at present: " + state + ".");
	}
	
	// Creates memento.
	public Memento originatorMemento()
	{
		memento = new Memento(state);
		return memento;
	}
	
	// Back to old state.
	public void Revert(Memento memento)
	{
		System.out.println("Restoring to previous state...");
		state = memento.getState();
		System.out.println("State at present: " + state + ".");
	}
}

class Caretaker
{
	private Memento memento;
	
	public void saveMemento(Memento memento)
	{
		this.memento = memento;
	}
	
	public Memento retrieveMemento()
	{
		return memento;
	}
}

public class MementoPatternDemo
{
	public static void main(String args[])
	{
		System.out.println("***Memento Pattern Demo 1***\n");
		
		Originator originator = new Originator();
		originator.setState("First state");
		
		// Holding old state.
		Caretaker caretaker = new Caretaker();
		caretaker.saveMemento(originator.originatorMemento());
		
		// Changing state.
		originator.setState("Second state");
		
		// Restore saved state.
		originator.Revert(caretaker.retrieveMemento());
	}
}
