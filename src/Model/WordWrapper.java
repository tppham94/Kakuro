package Model;

public class WordWrapper {
	WordModel wordModel;
	BlankWordModel blankWordModel;

	public WordWrapper () {
		wordModel = new WordModel ();
		blankWordModel = new BlankWordModel ();
	}
	
	public WordWrapper (int regSize, int blankSize) {
		wordModel = new WordModel (regSize);
		blankWordModel = new BlankWordModel (blankSize);
	}
	
	public WordWrapper (int regSize, int totalWordModel, int blankSize) {
		wordModel = new WordModel (regSize, totalWordModel);
		blankWordModel = new BlankWordModel (blankSize);
	}
	
	public WordWrapper (BlankWordModel blankWordModel) {
		this.blankWordModel = blankWordModel;
	}
	
	public WordWrapper (WordModel wordModel) {
		this.wordModel = wordModel;
	}
	
	public WordWrapper (WordModel wordModel, BlankWordModel blankWordModel) {
		this.wordModel = wordModel;
		this.blankWordModel = blankWordModel;
	}
	
	public WordModel getWordModel() {
		return wordModel;
	}

	public void setWordModel(WordModel wordModel) {
		this.wordModel = wordModel;
	}

	public BlankWordModel getBlankWordModel() {
		return blankWordModel;
	}

	public void setBlankWordModel(BlankWordModel blankWordModel) {
		this.blankWordModel = blankWordModel;
	}
}
