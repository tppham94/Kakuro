package Kakuro;

public class KakuroPuzzle{
	
	protected String [][] board;
	protected boolean [][] mutable;
	private final int ROWS;
	private final int COLUMNS;
	private final int BOXWIDTH;
	private final int BOXHEIGHT;
	private final String [] VALIDVALUES;
	
	public KakuroPuzzle(int rows, int columns, int boxWidth, int boxHeight, String [] validValues) {
		this.ROWS = rows;
		this.COLUMNS = columns;
		this.BOXWIDTH = boxWidth;
		this.BOXHEIGHT = boxHeight;
		this.VALIDVALUES = validValues;
		this.board = new String[ROWS][COLUMNS];
		this.mutable = new boolean[ROWS][COLUMNS];
		//initializeKakuroBoard();
		//initializeMutableSlots();
	}
	
	public KakuroPuzzle(KakuroPuzzle puzzle) {
		this.ROWS = puzzle.ROWS;
		this.COLUMNS = puzzle.COLUMNS;
		this.BOXWIDTH = puzzle.BOXWIDTH;
		this.BOXHEIGHT = puzzle.BOXHEIGHT;
		this.VALIDVALUES = puzzle.VALIDVALUES;
		this.board = new String[ROWS][COLUMNS];
		for(int r = 0; r < ROWS; r++) {
			for(int c = 0; c < COLUMNS; c++) {
				board[r][c] = puzzle.board[r][c];
			}
		}
		this.mutable = new boolean[ROWS][COLUMNS];
		for(int r = 0; r < ROWS; r++) {
			for(int c = 0; c < COLUMNS; c++) {
				this.mutable[r][c] = puzzle.mutable[r][c];
			}
		}
	}
	
	public int getNumRows() {
		return this.ROWS;
	}
	
	public int getNumColumns() {
		return this.COLUMNS;
	}
	
	public int getBoxWidth() {
		return this.BOXWIDTH;
	}
	
	public int getBoxHeight() {
		return this.BOXHEIGHT;
	}
	
	public String [] getValidValues() {
		return this.VALIDVALUES;
	}
	
	
}