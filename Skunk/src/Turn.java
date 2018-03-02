import java.util.Scanner;

//score the roll and update the roll score
//create a turn
//make roll--> score the roll --> update score 
//keep track of numOfRoll
//ask if the turn is over(comes from skunk and player choice) DONE
//
public class Turn
{
	private Roll[] gameRoll; 
	private int turnScore;
	private int numOfRoll;
	
	
	public Turn() 
	{
		gameRoll = new Roll[100];
		turnScore = 0;
		numOfRoll = 0;
	}
	
	//for testing purpose
	public Roll createRoll_from_fakeDice() {
		Roll testRoll = new Roll (new LoadedDice (new SimDie(new int[]{1,2,3}), new SimDie(new int[]{4,5,6})));
		numOfRoll++;
		gameRoll[numOfRoll-1] = testRoll;
		return testRoll;
	}
	
	public Roll createRoll() 
	{
		Roll aRoll = new Roll(new Dice (new RandomDie(), new RandomDie()));
		numOfRoll++;
		gameRoll[numOfRoll-1] = aRoll; //store the new Roll object into array of Roll
		return aRoll;
	}

	//for testing
	public int addScore_test() 
	{
		int lastScore = 0;
		for(int x=0; x < gameRoll.length-1; x++) 
		{
			if(gameRoll[x].checkDoubleSkunk_test()==true) //check double skunk first
			{
				turnScore = 0;
				break;
			}
			else if(gameRoll[x].checkSkunk_test()==true) 
			{
				turnScore = lastScore;
				break;
			}
			else
			{
				turnScore = lastScore + gameRoll[x].getResult();
				break;
			}
		}
		return turnScore;
	}
	
	// main score summation that check skunk/double skunk	
	public int addScore() 
	{
		int lastScore = 0;
		for(int x=0; x < gameRoll.length-1; x++) 
		{
			if(gameRoll[x].checkDoubleSkunk()==true) //check double skunk first
			{
				turnScore = 0;
				break;
			}
			else if(gameRoll[x].checkSkunk()==true) 
			{
				turnScore = lastScore;
				break;
			}
			else
			{
				turnScore = lastScore + gameRoll[x].getResult();
				break;
			}
		}
		return turnScore;
	}
	
	public boolean turnStatus() {
		Scanner answer = new Scanner(System.in);
		System.out.println("Do you want to roll again?");
		Object rolls = answer.next();
		boolean skunk = false;
		if (rolls.equals("yes")) {
			skunk = false;
		} 
		if (rolls.equals("no")) {
			skunk = true;
	}
		return skunk;
	
}

	public int getTurnScore()
	{
		return turnScore;
	}

}