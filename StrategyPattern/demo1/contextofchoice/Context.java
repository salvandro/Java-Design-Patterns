package demo1.contextofchoice;

import demo1.choices.IChoice;

public class Context
{
	IChoice myChoice;
	
	// Set a Strategy or algorithm in the Context.
	public void setChoice(IChoice iChoice)
	{
		myChoice = iChoice;
	}
	
	public void showChoice(String s1,
			               String s2)
	{
		myChoice.myChoice(s1,
				          s2);
	}
}
