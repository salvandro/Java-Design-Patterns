package demo1;

interface ICommand
{
	public void _do();
}

class MyUndoCommand implements ICommand
{
	private Receiver receiver;
	
	MyUndoCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	@Override
	public void _do()
	{
		// Call undo in receiver.
		receiver.performUndo();
	}
}

class MyRedoCommand implements ICommand
{
	private Receiver receiver;
	
	MyRedoCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}
	
	@Override
	public void _do()
	{
		// Call redo in receiver.
		receiver.performRedo();
	}
}

// Receiver class.
class Receiver
{
	public void performUndo()
	{
		System.out.println("Executing MyUndoCommand.");
	}
	
	public void performRedo()
	{
		System.out.println("Executing MyRedoCommand");
	}
}

// Invoker class.
class Invoke
{
	ICommand command;
	
	public void ExecuteCommand(ICommand command)
	{
		this.command = command;
		command._do();
	}
}

// Client class.
public class CommandPatternDemo
{
	public static void main(String args[])
	{
		Receiver intendedReceiver = new Receiver();
		/* Client holds Invoker and Command objects. */
		Invoke invoke = new Invoke();
		MyUndoCommand undoCommand = new MyUndoCommand(intendedReceiver);
		MyRedoCommand redoCommand = new MyRedoCommand(intendedReceiver);
		
		System.out.println("***Command Pattern Demo***\n");
		
		invoke.ExecuteCommand(undoCommand);
		invoke.ExecuteCommand(redoCommand);
	}
}
