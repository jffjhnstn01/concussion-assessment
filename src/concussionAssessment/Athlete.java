package concussionAssessment;

public class Athlete extends User{
	/*Storing symptoms as indexes for the symptom profile
	 * Makes it easier to read code later on
	 * There are the indices 0-21 for the 2D array
	 */
	public int headache = 0;
	public int pressureInHead = 1;
	public int neckPain = 2;
	public int nauseaVomiting = 3;
	public int dizziness = 4;
	public int blurredVision = 5;
	public int balanceProblems = 6;
	public int sensitivityToLight = 7;
	public int sensitivityToNoise = 8;
	public int feelingSlowedDown = 9;
	public int feelingInAFog = 10;
	public int dontFeelRight = 11;
	public int difficultyConcentrating = 12;
	public int difficultyRemembering = 13;
	public int fatigue = 14;
	public int confusion = 15;
	public int drowsiness = 16;
	public int troubleFallingAsleep = 17;
	public int moreEmotional = 18;
	public int irritability = 19;
	public int sadness = 20;
	public int nervous = 21;
	
	//The game number is the index 0-4 in the 2D array
	//Get's incremented to 5 to trigger the deleteEarliestGame function
	private int gameNumber = 0;
	
	
	//Data structure that stores symptom information for each athlete
	//For up to 5 games or practices, 22 different symptoms
	private int[][] symptomProfile = new int[5][22];
	
	public int getSymptomScore(int game, int symptom) {
		return symptomProfile[game][symptom];
	}
	
	//Set the score for a given symptom for a given game/practice. Asserts that
	// 0 <= score <= 6
	public void setSymptomScore(int game, int symptom, int score) {
		assert (score <= 6 && score >=0) : "Invalid Score";
		symptomProfile[game][symptom] = score;
	}
	
	//Copies the values in the array from next game to the current game
	//Moves 1 to 0, 2 to 1, and so on. Then overwrite 4 with new symptoms
	public void deleteEarliestGame() {
			for (int i = 0; i < 4; i++) {
				symptomProfile[i] = symptomProfile[i + 1];
			}
		}

	//Setters and Getters for Game Number
	public int getGameNumber() {
		return gameNumber;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
	
	
}
