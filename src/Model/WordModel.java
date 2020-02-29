package Model;

import View.ClueView;

public class WordModel {

	private int TargetSum;
	private Cell[] Cells;
	
	
	public WordModel(int TargetSum, Cell[] Cells) {
		this.TargetSum = TargetSum;
		this.Cells = Cells;
	}
	
	//it2 addition
	public boolean validate() {
		return false;
	}

	
}
