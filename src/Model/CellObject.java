package Model;

import View.CellView;

public class CellObject {
	CellModel cellModel;
	CellView cellView;
	
	public CellObject (int correctCellModelNumber) {
		cellModel = new CellModel (correctCellModelNumber);
		cellView = cellModel.getCellView();
	}
	
	public void setCellModel (int correctCellModelNumber){
		cellModel = new CellModel (correctCellModelNumber);
		cellView = cellModel.getCellView();
	}
	
	public void updateCellModel (String str) {
		cellModel.update(str);
	}
	
	public CellView getCellView() {
		return cellView;
	}
}
