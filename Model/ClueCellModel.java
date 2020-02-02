package Model;

public class ClueCellModel {

	private String rightLabelValue;
	private String downLabelValue;
	
	/**
	 * @param rightLabelValue
	 * @param downLabelValue
	 */
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
}
