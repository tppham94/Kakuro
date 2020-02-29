package Model;

public class CellModel {
	int correctNumber;
	int userNumber;
	boolean isCorrect;
//	CellView view;
	
	public CellModel() {
		isCorrect = false;
	}
	
	public boolean update(String str) {
		if (str.matches("\\d+")) {
			if(str.matches("[1-9]")) {
				userNumber = Integer.parseInt(str);
				if(userNumber==correctNumber) {
					setCorrect(true);
				}
				else {
					setCorrect(false);
				}
			} 
			return true;
		}
		else return false;
	}
	
	public void setCorrect (boolean correct) {
		isCorrect = correct;
	}
	
}
