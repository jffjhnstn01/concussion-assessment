package concussionAssessment;

public abstract class User {
	
	User(){}
	
	//Using a String of the User's birthday as a login ID. Entered during log in
	//Used as key to map to athlete for symptoms
	private String userID = "";
	
	public String getUserID() {
		return userID;
	}
	
	public String setUserID(String birthday) {
		return this.userID = birthday; 
	}
	
}
