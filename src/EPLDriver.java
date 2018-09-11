import java.util.Scanner;

public class EPLDriver
{
	// private instance variables
	private static String command, type, temp;
	private static String[] arrTemp;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Database d = new Database();

		do
		{
			// prompt user to enter input
			System.out.println(">>>");
			// reads the user input as one string
			command = s.nextLine();
			// switch statement that goes through possible commands
			switch (command)
			{
			case "s":
			{
				d.checkStandings();
				d.write();
			}
				break;
			case "q":
				break;
			}
		} while (!command.equals("q"));
	}
}
