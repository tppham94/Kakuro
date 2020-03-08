package Model;

import View.ClueCell;

public class ClueCellModel {

	private String rightLabelValue;
	private String downLabelValue;
	private ClueCell clueCellView;
	
	public ClueCellModel(ClueCell clueCellView) { //blank cell?
		this.rightLabelValue = "";
		this.downLabelValue = "";
		this.clueCellView = clueCellView;
	}
	
	public ClueCellModel(String rightLabelValue, String downLabelValue) {
		this.rightLabelValue = rightLabelValue;
		this.downLabelValue = downLabelValue;
	}
	
	//Getters and Setters
	public String getRightLabelValue() {
		return rightLabelValue;
	}

	public void setRightLabelValue(String rightLabelValue) {
		this.rightLabelValue = rightLabelValue;
	}

	public String getDownLabelValue() {
		return downLabelValue;
	}

	public void setDownLabelValue(String downLabelValue) {
		this.downLabelValue = downLabelValue;
	}
	
	public ClueCell getClueCellView() {
		return clueCellView;
	}

	public void setClueCellView(ClueCell clueCellView) {
		this.clueCellView = clueCellView;
	}
}
