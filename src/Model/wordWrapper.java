package Model;

public class wordWrapper {
	WordModel wordModel;
	BlankWordModel blankWordModel;

	wordWrapper () {
		wordModel = new WordModel ();
		blankWordModel = new BlankWordModel ();
	}
	
	wordWrapper (int regSize, int blankSize) {
		wordModel = new WordModel (regSize);
		blankWordModel = new BlankWordModel (blankSize);
	}
	
	wordWrapper (int regSize, int totalWordModel, int blankSize) {
		wordModel = new WordModel (regSize, totalWordModel);
		blankWordModel = new BlankWordModel (blankSize);
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
