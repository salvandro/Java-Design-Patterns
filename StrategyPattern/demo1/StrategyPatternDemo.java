package demo1;

import demo1.contextofchoice.Context;
import demo1.choices.FirstChoice;
import demo1.choices.IChoice;
import demo1.choices.SecondChoice;
import java.io.IOException;
import java.util.Scanner;

public class StrategyPatternDemo
{
	public static void main(String args[]) throws IOException
	{
		Scanner in = new Scanner(System.in); // to take input from user.
		IChoice iChoice = null;
		Context context = new Context();
		String input1;
		String input2;
		String c;

		System.out.println("***Strategy Pattern Demo 1***");

		// Looping twice to test two different choices.
		try
		{
			for (int i = 1; i <= 2; i++)
			{
				System.out.print("Enter an integer: ");
				input1 = in.nextLine();

				System.out.print("Enter another integer: ");
				input2 = in.nextLine();

				System.out.println("Enter ur choice(1 or 2).");
				System.out.print("Press 1 for Addition, 2 for Concatenation: ");
				c = in.nextLine();
				
				/* For Java old versions-use these lines to collect input
                 * from user BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 * c = br.readLine();
				 */
				if(c.equals("1"))
				{
					/* If user input is 1, create object of FirstChoice(Strategy1). */
					iChoice = new FirstChoice();
				}
				else
				{
					/* If user input is 2, create object of SecondChoice(Strategy 2). */
					iChoice = new SecondChoice();
				}
				
				/* Associate the Strategy with Context. */
				context.setChoice(iChoice);
				
				context.showChoice(input1,
						           input2);
			}
		}
		finally
		{
			in.close();
		}
		
		System.out.println("End of Strategy pattern.");
	}
}
