import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Database
{
	// private instance variables
	private static int counter = 0, contestantCounter = 0;
	private static String team, tempPrediction;
	// array of contestant scores starting at zero for everyone
	int contestantScores[] =
	{ 0, 0, 0, 0, 0, 0, 0 };
	// array of predictions
	private static String[][] predicitions =
	{
			{ "manchester city", "liverpool", "tottenham", "arsenal", "manchester united", "chelsea", "everton",
					"fulham" }, // josh
			{ "manchester city", "liverpool", "arsenal", "manchester united", "tottenham", "chelsea", "wolves",
					"everton" }, // andrew
			{ "united", "liverpool", "tottenham", "arsenal", "leicester", "chelsea", "burnley", "everton" }, // harman
			{ "city", "tottenham", "liverpool", "united", "arsenal", "chelsea", "everton", "westham" }, // lyle
			{ "mancity", "united", "liverpool", "chelsea", "everton", "arsenal", "crystal", "godsplan" }, // lovepreet
			{ "arsenal", "city", "united", "liverpool", "chelsea", "tottenham", "everton", "cardif" }, // dino
			{ "arsenal", "city", "liverpool", "united", "spurs", "chelsea", "everton", "wolves" } }; // quain
	// scanners for reading
	Scanner s, s1, s2;

	// files for reading
	File standingsFile = new File("eplstandings.txt");

	public Database()
	{
		checkDatabaseFiles("eplstandings.txt");
	}

	// Receives: a string holding the file name
	// Task: checks to make sure all the database files exist, if they don't it
	// creates them
	// Returns: nothing
	public void checkDatabaseFiles(String fname)
	{
		File f = new File(fname);
		if (f.exists() && !f.isDirectory())
		{
		} else
		{
			try
			{
				f.createNewFile();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // if file already exists will do nothing
		}
	}

	// Receives: a file
	// Task: create a scanner to a file of users choice
	// Returns: Scanner
	public Scanner getScanner(File f)
	{
		try
		{
			s = new Scanner(f);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	public void checkStandings()
	{
		s = getScanner(standingsFile);

		while (s.hasNextLine())
		{
			team = s.nextLine();
			System.out.println(team);
			if (counter == 0)
			{
				while (contestantCounter < 7)
				{
					if (predicitions[contestantCounter][counter].equals(team))
					{
						contestantScores[contestantCounter] += 3;
					}
					contestantCounter++;
				}
				contestantCounter = 0;

				// test contestant predictions for second place
			} else if (counter == 1)
			{
				while (contestantCounter < 7)
				{
					if (predicitions[contestantCounter][counter].equals(team))
					{
						contestantScores[contestantCounter] += 2;
					}
					contestantCounter++;
				}
				contestantCounter = 0;

				// test contestant predictions for 3rd-8th places
			} else if (counter > 1)
			{
				while (contestantCounter < 7)
				{
					if (predicitions[contestantCounter][counter].equals(team))
					{
						contestantScores[contestantCounter] += 1;
					}
					contestantCounter++;
				}
				contestantCounter = 0;
			}

			counter++;
		}
		counter = 0;
		System.out.println();
	}
	public void write() {
		System.out.println("josh = " + contestantScores[0]);
		System.out.println("andrew = " + contestantScores[1]);
		System.out.println("harman = "  + contestantScores[2]);
		System.out.println("lyle = "  + contestantScores[3]);
		System.out.println("lovepreet = "  + contestantScores[4]);
		System.out.println("dino = "  + contestantScores[5]);
		System.out.println("quain = "  + contestantScores[6]);
		
		contestantScores[0] = 0;
		contestantScores[1] = 0;
		contestantScores[2] = 0;
		contestantScores[3] = 0;
		contestantScores[4] = 0;
		contestantScores[5] = 0;
		contestantScores[6] = 0;
		
	}
}
