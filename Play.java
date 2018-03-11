import java.util.Scanner;

public class Play
{
	public static void main(String[] args)
	{
        System.out.println("\n     Welcome! To the game of Hangman!\n");
        System.out.println("I have chosen a word for you to guess.");
		Game hangMan = new HangMan();
		Scanner sc = new Scanner(System.in);
		boolean playAgain = true;
		while(playAgain)
		{
			hangMan.run();
			System.out.println("Would you like to play again?");
			System.out.println("Type (y) or (n)");
			String answer = sc.next();
			if (answer.equals("n"))
				playAgain = false;
		}
	}
}
