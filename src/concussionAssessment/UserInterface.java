package concussionAssessment;
import java.util.HashMap;
import java.util.Scanner;

//Driver Class for the App
class UserInterface {
	
	UserInterface(){}
	
	//Boolean to control log out function. Runs loop in AthleteUI until this is true
	private static boolean isLoggedOut = false;
	
	public void setLoggedOut(boolean boolIn) {
		isLoggedOut = boolIn;
	}
	
	public static boolean getLoggedOut() {
		return isLoggedOut;
	}
	
	//Data Structure used to hold Athlete Information. HashMap maps a birthday String to an athlete object
	public static HashMap<String,Athlete> athletesInSystem = new HashMap<String, Athlete>();
	
	//Scanner used for console input from user
	public static Scanner inScan = new Scanner(System.in);
	
	//Prints Welcome Message. Switch case functionality used for other user types as needed
	public void welcomeMessage(HashMap<String, Athlete> athletesInSystem) {
		//Scanner in = new Scanner(System.in);
		int userType;
		
		System.out.println("Welcome to the Sports Concussion Assessment Application.");
		System.out.println("Please enter 1 if you are an athlete: ");
		userType = inScan.nextInt();
		
		switch(userType) {
		
		case 1:
			AthleteUI.main(null);
			break;
			
		/*case 2:
			MedicalUI.main(null);
			break;
		*/
			
		default:
			System.out.println("Error. Try Again.");
			welcomeMessage(athletesInSystem);
		}
		
	}
	
	//Abstract display menu function for multiple types of users
	public void displayMenu(User userIn) {
		
	}
	
	//Triggers logout sequence and exits the main function
	public void logout() {
		System.out.println("Thank you for using the Sports Concussion Assessment Application.");
		System.out.println("Logging Out...");
		setLoggedOut(true);
	}
		
	public static void main(String[] args) {
		UserInterface concussionApp = new UserInterface();
		concussionApp.welcomeMessage(athletesInSystem);
	}
	

}
