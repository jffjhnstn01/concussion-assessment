package concussionAssessment;
import java.util.HashMap;


public class AthleteUI extends UserInterface{
	
	//Athlete log in function. Will check athletesInSystem HashMap for existing athlete,
	//Create a new athlete if one does not exist, and verifies ID format
	public static Athlete athleteLogin(HashMap<String, Athlete> athletesInSystem) {
		String athleteUserID;
		Athlete loggedInAthlete = new Athlete();
		
		System.out.println("Please enter your user ID (your birthday in the form MM-DD-YY: ");
		System.out.println("If you are a new user, an account will be created for you.");
		athleteUserID = inScan.next();
		
		//Wrong ID format
		if (athleteUserID.length() != 8) {
			System.out.println("Incorrect ID Format, try again.");
			athleteLogin(athletesInSystem);
		}
		//Check for existing Athlete in system if medical practitioner added them
		else if(UserInterface.athletesInSystem.containsKey(athleteUserID)){
			loggedInAthlete = UserInterface.athletesInSystem.get(athleteUserID);
			assert loggedInAthlete.getUserID() == athleteUserID : " ID Mismatch";
			System.out.println("You are logged in.");
		}
		//Create new athlete user if one does not exist and logs in
		else {
			System.out.println("Welcome new user! Your new ID is " + athleteUserID);
			loggedInAthlete.setUserID(athleteUserID);
			UserInterface.athletesInSystem.put(athleteUserID, loggedInAthlete);
		}
		return loggedInAthlete;
		
	};
	
	//Displays the Athlete Menu after he/she logs in. Gives 4 options based on primary functionalities.
	public void displayMenu(Athlete sportsDude, SummaryReport report) {
		int input = 0;
		
		System.out.println("Sports Concussion Assessment System");
		System.out.println("Please enter a menu number");
		System.out.println("Enter Symptom Information: 1");
		System.out.println("Print Symptom Summary Report: 2");
		System.out.println("Am I At Risk?: 3");
		System.out.println("Log Out: 4");
		
		input = inScan.nextInt();
		
		switch (input) {
		
		case 1:
			enterSymptomInformation(sportsDude);
			break;
		
		case 2:
			if(sportsDude.getGameNumber()>0) {
				report.printSymptoms(sportsDude);
			}
			else {
				System.out.println("Error. Enter Sympotom Information.");
				displayMenu(sportsDude, report);
			}
			break;
			
		case 3:
			report.displayRiskyConditionIndicator(sportsDude);
			break;
			
		case 4:
			logout();
			break;
		
		default:
			System.out.println("Error. Try Again.");
			displayMenu(sportsDude, report);
		}
	}
	
	//Collect Symptom info for an athlete and update athlete symptom profile
	//Assumes scores are between 0 and 6
	public void enterSymptomInformation(Athlete sportsDude) {
		int input;
		int gameNumber = sportsDude.getGameNumber();
		
		//Checks to see if data is already stored for 5 games. If so, deletes the earliest played game
		//to make room for the most recent one in the symptom profile.
		//Resets the gameNumber to 4 for the most recent game.
		if(gameNumber == 5){
			sportsDude.deleteEarliestGame();
			sportsDude.setGameNumber(4);
		}
		
		System.out.println("Enter Symptom Information");
		System.out.println("Scores are ranked from 0 to 6, with 0 being no symptoms, and 6 being severe symptoms.");
		
		System.out.println("Please enter your headache score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.headache, input);
		
		System.out.println("Please enter your pressure in head score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.pressureInHead, input);
		
		System.out.println("Please enter your neck pain score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.neckPain, input);
		
		System.out.println("Please enter your nausea or vomiting score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.nauseaVomiting, input);
		
		System.out.println("Please enter your dizziness score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.dizziness, input);
		
		System.out.println("Please enter your blurred vision score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.blurredVision, input);
		
		System.out.println("Please enter your balance problems score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.balanceProblems, input);
		
		System.out.println("Please enter your sensitivty to light score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.sensitivityToLight, input);
		
		System.out.println("Please enter your sensitivity to noise score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.sensitivityToNoise, input);
		
		System.out.println("Please enter your feeling slowed down score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.feelingSlowedDown, input);
		
		System.out.println("Please enter your feeling like \"in a fog\" score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.feelingInAFog, input);
		
		System.out.println("Please enter your \"don't feel right\" score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.dontFeelRight, input);
		
		System.out.println("Please enter your difficulty concentrating score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.difficultyConcentrating, input);
		
		System.out.println("Please enter your difficulty remembering score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.difficultyRemembering, input);
		
		System.out.println("Please enter your fatigue/low energy score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.fatigue, input);
		
		System.out.println("Please enter your confusion score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.confusion, input);
		
		System.out.println("Please enter your drowsiness score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.drowsiness, input);
		
		System.out.println("Please enter your trouble falling asleep score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.troubleFallingAsleep, input);
		
		System.out.println("Please enter your more emotional score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.moreEmotional, input);
		
		System.out.println("Please enter your irritability score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.irritability, input);
		
		System.out.println("Please enter your sadness score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.sadness, input);
		
		System.out.println("Please enter your nervous score	(none (0), mild (1-2), moderate (3-4), & severe (5-6): ");
		input = inScan.nextInt();
		sportsDude.setSymptomScore(sportsDude.getGameNumber(), sportsDude.nervous, input);
		
		//Checks if 5 games have been played, and increments to next game if not
		if (gameNumber < 5) {
			sportsDude.setGameNumber(++gameNumber);
		}
	}
	
	public static void main(String args[]) {
		//Create new instance of athleteUI and SummaryReport
		AthleteUI athleteApp = new AthleteUI();
		SummaryReport concussionSummReport = new SummaryReport();
		
		//Log in the athlete using the app
		Athlete sportsDude = athleteLogin(athletesInSystem);
		
		//Keep athlete logged in until they log out
		while(!getLoggedOut()) {
			athleteApp.displayMenu(sportsDude, concussionSummReport);
		}
		return;
		
	}
}