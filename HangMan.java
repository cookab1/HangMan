import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan extends Game
{
	private static final int WRONG_GUESSES = 7;
	private static final int NUM_WORDS = 30;
	private static final String[] WORDS = {"geography", "cat", "yesterday", "java", "truck", "opportunity",
											"fish", "token", "transportation", "bottom", "apple", "cake",
											"remote", "pocket", "terminology", "arm", "cranberry", "tool",
											"caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
											"fundamental", "capitol", "garbage", "anticipate", "apple", "baby"};

	private int wrongGuesses;
	private ArrayList<Character> guessed;
	private String chosenWord;
	private char[] word;
	private Random rand;
	
	public void initialize()
	{
		wrongGuesses = 0;
		guessed = new ArrayList<Character>();
		loadContent();
		doContinue = true;
	}
	
	public void loadContent()
	{
		rand = new Random();
		chosenWord = WORDS[rand.nextInt(30)];
		word = new char[chosenWord.length()];
		for (int i = 0; i < chosenWord.length(); i++)
		{
			word[i] = '*';
		}
	}
	
	public void userAction()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your letter guess.");
		char guess = sc.next().charAt(0);
		boolean there = guessed.contains(guess);
		guessed.add(guess);
		boolean correct = false;
		for(int i = 0; i < chosenWord.length(); i++)
		{
			if(chosenWord.charAt(i) == guess)
			{
				word[i] = guess;
				correct = true;
			}
		}
		if (!correct || there)
			wrongGuesses++;
	}
	
	public void draw()
	{
		for(int i = 0; i < chosenWord.length(); i++)
		{
			System.out.print(word[i]);
		}
		System.out.println("");
		printNoose();
        printGuessed();
    }
    	
	public boolean evaluateState()
	{
		for (int i = 0; i < chosenWord.length(); i++)
		{
			if (word[i] == '*' && (WRONG_GUESSES - wrongGuesses) > 0)
				return true;
		}
		return false;
	}
	
	public void report()
	{
		System.out.print("The Correct word was " + chosenWord);
		System.out.println("");
	    System.out.println("Game Over");
	}

    public void printGuessed()
    {
        System.out.print("Already Guessed: ");
        if(guessed.size() == 0)
            System.out.println("Nothing Guessed Yet.");       
        for(int i = 0; i < guessed.size(); i++)
        {
            if(i == guessed.size() - 1)
                System.out.println(guessed.get(i));
            else
                System.out.print(guessed.get(i) + ", ");
        }
    }

    public void printNoose()
    {
        assert(wrongGuesses < 8);
        
        System.out.println("");
        switch (wrongGuesses)
        {
            case 0:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 1:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (   ) \n"
                  +"   |        -   \n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 2:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (o o) \n"
                  +"   |        -   \n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 3:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (o o) \n"
                  +"   |        -   \n"
                  +"   |	    |   \n"
                  +"   |        |   \n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 4:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (o o) \n"
                  +"   |        -   \n"
                  +"   |	  \\_|   \n"
                  +"   |        |   \n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 5:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (o o) \n"
                  +"   |        -   \n"
                  +"   |	  \\_|_/ \n"
                  +"   |        |   \n"
                  +"   |\n"
                  +"   |\n"
                  +" ---------------\n");
				break;
            case 6:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (o o) \n"
                  +"   |        -   \n"
                  +"   |	  \\_|_/ \n"
                  +"   |        |   \n"
                  +"   |	    /   \n"
                  +"   |	   /    \n"
                  +" ---------------\n");
				break;
            case 7:
System.out.println("   ----------   \n"
                  +"   |        |   \n"
                  +"   |        _   \n"
                  +"   |      (x x) \n"
                  +"   |        -   \n"
                  +"   |	  \\_|_/ \n"
                  +"   |        |   \n"
                  +"   |	    /\\  \n"
                  +"   |	   /  \\ \n"
                  +" ---------------\n");
				break;
        }
    }
}
