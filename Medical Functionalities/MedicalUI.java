package concussionAssessment;
import java.util.Scanner;

public class MedicalUI extends UserInterface{

	public void medicalLogin() {
		Scanner stringIn = new Scanner(System.in);
		String medicalUserID;
		System.out.println("Please enter your user ID (your birthday in the form MM-DD-YY: ");
		medicalUserID = stringIn.next();
		if (medicalUserID.length() != 8) {
			System.out.println("Incorrect ID Format, try again.");
			medicalLogin();
		}
		stringIn.close();
	}
	
	public void displayMenu() {
		Scanner in = new Scanner(System.in);
		int input;
		
		System.out.println("Sports Concussion Assessment System - Medical Practitioner");
		System.out.println("Please enter a menu number");
		System.out.println("Add New User: 1");
		System.out.println("Print Symptom Summary Report for an Athlete: 2");
		System.out.println("Confirm Risky Condition Indicator: 3"); 
		input = in.nextInt();
		
		switch (input) {
		
		case 1:
			addNewUser();
			break;
			
		case 2:
			printSummaryReport();
			break;
			
		case 3:
			confirmRiskIndicator();
			break;
			
		default:
			System.out.println("Error. Try Again");
			displayMenu();
		}
		
		in.close();
	}
	
	public void addNewUser() {
		
	}
	
	public void printSummaryReport() {
		
	}
	
	public void confirmRiskIndicator() {
		
	}
	
	public static void main(String[] args) {

	}

}
