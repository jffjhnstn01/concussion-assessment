package concussionAssessment;

public class SummaryReport {
	
	SummaryReport(){}
	
	//Arrays used to hold Total Number of Symptoms and Total Severity Score for each game
	private int[] totalNumSymptoms = {0, 0, 0, 0, 0};
	private int[] totalSeverityScore = {0, 0, 0, 0, 0};
	
	//Helper array used to determine if a report was already printed for that game to prevent
	//Double counting Total Number of Symptoms and/or Total Severity Score
	private boolean[] didPrint = {false, false, false, false, false};
	
	private String[] symptomTable = {
			"Headache",
			"Pressure in Head",
			"Neck Pain",
			"Nausea or Vomiting",
			"Dizziness",
			"Blurred Vision",
			"Balance Problems",
			"Sensitivity to Light",
			"Sensitivity to Noise",
			"Feeling Slowed Down",
			"Feeling \"In a Fog\"",
			"Don't Feel Right",
			"Difficulty Concentrating",
			"Difficulty Remembering",
			"Fatigue or low energy",
			"Confusion",
			"Drowsiness",
			"More Emotional",
			"Trouble Falling Asleep",
			"Irritability",
			"Sadness",
			"Nervous"
	};
		
	//ANSI colors for printing Risky Condition Indicator Text Colors to Console
	//Does not print colors properly in IDE
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	//Shifts console text color back to default
	public static final String ANSI_RESET = "\u001B[0m";
	
	//Logic for Risky Condition Indicator
	private boolean isRed = false;
	private boolean isYellow = false;
	private boolean isGreen = false;

	//Nested for loops to print symptom scores for each game
	//Calculates total symptoms and severity score for each game if not already tabulated
	public void printSymptoms(Athlete athleteIn) {
		int gameNumber = athleteIn.getGameNumber();
		for (int i = 0; i < gameNumber; i++) {
			System.out.println("Symptoms for game/practice " + (i+1) + ": ");
			for (int j = 0; j < 22; j++) {
				System.out.println(symptomTable[j] + " score of: " + athleteIn.getSymptomScore(i, j));
				if (!getDidPrint(i)) {
					if (athleteIn.getSymptomScore(i, j) > 0 ) {
						totalNumSymptoms[i]++;
					}
					totalSeverityScore[i] += athleteIn.getSymptomScore(i, j);	
					
				}
			}
			itDidPrint(i);
		}
		
		for (int i = 0; i < gameNumber; i++) {
			System.out.println("Total Number of Symptoms for Game/Practice " + i+1 + ": " + totalNumSymptoms[i]);
			System.out.println("Total Severity Score for Game/Practice "+ i+1 + ": " + totalSeverityScore[i]);
		}
		
		
	}
	
	//Prints the Risk Indicator in corresponding text color to console if conditions are met per spec
	public void displayRiskyConditionIndicator(Athlete athleteIn) {
		int gameCount = athleteIn.getGameNumber();
		//Verify at least symptoms for at least one game have been entered
		if(gameCount < 1) {
			System.out.println("Error. Enter Symptom Information for at least 1 game.");
			return;
		}
		//If symptoms have only been entered for one game, the condition can only be red based on the spec.
		else if(gameCount == 1){
			if(totalSeverityScore[0] >= 15) {
					isRed = true;
			}
			else {
				System.out.println("Not enough information. Enter Symptom Information for at least 2 games.");
			}
		}
		//Compare differences and total scores from symptom number and severity score arrays
		else if(gameCount >= 2) {
			for (int i = 1; i < gameCount; i++) {
				if((totalNumSymptoms[i]-totalNumSymptoms[i-1] >= 3) || 
						(totalSeverityScore[i-1]  >= 15) ||
						(totalSeverityScore[i]) >= 15) {
					isRed = true;
				}
				else if((totalNumSymptoms[i]-totalNumSymptoms[i-1] < 3) && 
						(totalSeverityScore[i] >= 10)){
					isYellow = true;
				}
				else if((totalNumSymptoms[i]-totalNumSymptoms[i-1] < 3) && 
						(totalSeverityScore[i] < 10)){
					isGreen = true;
				}
			}
		}
		if(isRed) {
			System.out.println(ANSI_RED + "Very Different" + ANSI_RESET);
		}
		else if (isYellow && !isRed) {
			System.out.println(ANSI_YELLOW + "Unsure" + ANSI_RESET);

		}else if (isGreen && !isYellow && !isRed) {
			System.out.println(ANSI_GREEN + "No Difference" + ANSI_RESET);

		}
		
	}

	//Setters and Getters to update the didPrint Boolean array
	public boolean getDidPrint(int input) {
		return didPrint[input];
	}

	public void itDidPrint(int input) {
		this.didPrint[input] = true;
	}
		
}
