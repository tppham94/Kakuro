package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import Controller.GameController;
import Controller.TrainingController;
import Model.ClueCellModel;

public class Board {

	GameController controller;
	TrainingController trainingController;
	
	JButton validateButton;
	JComponent[] gameComponents;
	JFrame jf;

	// Constructor called by Game Driver
	public Board() {
		controller = new GameController();
		jf = new JFrame("Kakuro");
		gameComponents = new JComponent[100];
		
		initializeGameComponents();
		// Binding components with the controller
		controller.bindTextCells(gameComponents);
		
		addComponentsToJFrame();
		setVisualLayout();
		addValidateButton();
		validateButton.addActionListener(controller);
	}
	
	public Board(int size) {
		controller = new GameController();
		jf = new JFrame("Kakuro");
		gameComponents = new JComponent[size];
		
		initializeGameComponents();
		// Binding components with the controller
		controller.bindTextCells(gameComponents);
		
		addComponentsToJFrame();
		setVisualLayout();
		addValidateButton();
		validateButton.addActionListener(controller);
	}

	// Adding validate button
	private void addValidateButton() {
		validateButton = new JButton("validate");
		validateButton.setToolTipText("Validate");
		jf.add(validateButton);
	}

	// Adding visual layout to jframe
	private void setVisualLayout() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 600);
		jf.setLayout(new GridLayout(11, 10));
		jf.setVisible(true);

	}
	
	// Adding visual layout to jframe with size as param
	private void setVisualLayout(int sizex, int sizey) {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 600);
		jf.setLayout(new GridLayout(sizex,sizey));
		jf.setVisible(true);

	}

	// Adding J-components to the grid
	private void addComponentsToJFrame() {
		for (int i = 0; i < gameComponents.length; i++) {
			jf.add(gameComponents[i]);
		}
	}

	/* This methods initializes the game components
	 * and adds it to the gameComponents array
	 * * *   TODO: to be enhanced in upcoming iteration * * *
	 */
	private void initializeGameComponents() {
		gameComponents[0] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[1] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[2] = new ClueCell(new ClueCellModel("", "11"));
		gameComponents[3] = new ClueCell(new ClueCellModel("", "16"));
		gameComponents[4] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[5] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[6] = new ClueCell(new ClueCellModel("", "3"));
		gameComponents[7] = new ClueCell(new ClueCellModel("", "21"));
		gameComponents[8] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[9] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[10] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[11] = new ClueCell(new ClueCellModel("12", "7"));
		gameComponents[12] = new TextCell(controller, "5");
		gameComponents[13] = new TextCell(controller, "7");
		gameComponents[14] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[15] = new ClueCell(new ClueCellModel("4", ""));
		gameComponents[16] = new TextCell(controller, "1");
		gameComponents[17] = new TextCell(controller, "3");
		gameComponents[18] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[19] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[20] = new ClueCell(new ClueCellModel("12", ""));
		gameComponents[21] = new TextCell(controller, "2");
		gameComponents[22] = new TextCell(controller, "1");
		gameComponents[23] = new TextCell(controller, "9");
		gameComponents[24] = new ClueCell(new ClueCellModel("", "10"));
		gameComponents[25] = new ClueCell(new ClueCellModel("6", "16"));
		gameComponents[26] = new TextCell(controller, "2");
		gameComponents[27] = new TextCell(controller, "4");
		gameComponents[28] = new ClueCell(new ClueCellModel("", "17"));
		gameComponents[29] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[30] = new ClueCell(new ClueCellModel("4", ""));
		gameComponents[31] = new TextCell(controller, "1");
		gameComponents[32] = new TextCell(controller, "3");
		gameComponents[33] = new ClueCell(new ClueCellModel("10", "38"));
		gameComponents[34] = new TextCell(controller, "1");
		gameComponents[35] = new TextCell(controller, "9");
		gameComponents[36] = new ClueCell(new ClueCellModel("9", "10"));
		gameComponents[37] = new TextCell(controller, "1");
		gameComponents[38] = new TextCell(controller, "8");
		gameComponents[39] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[40] = new ClueCell(new ClueCellModel("37", ""));
		gameComponents[41] = new TextCell(controller, "4");
		gameComponents[42] = new TextCell(controller, "2");
		gameComponents[43] = new TextCell(controller, "5");
		gameComponents[44] = new TextCell(controller, "3");
		gameComponents[45] = new TextCell(controller, "7");
		gameComponents[46] = new TextCell(controller, "1");
		gameComponents[47] = new TextCell(controller, "6");
		gameComponents[48] = new TextCell(controller, "9");
		gameComponents[49] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[50] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[51] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[52] = new ClueCell(new ClueCellModel("10", "17"));
		gameComponents[53] = new TextCell(controller, "8");
		gameComponents[54] = new TextCell(controller, "2");
		gameComponents[55] = new ClueCell(new ClueCellModel("7", "4"));
		gameComponents[56] = new TextCell(controller, "2");
		gameComponents[57] = new TextCell(controller, "5");
		gameComponents[58] = new ClueCell(new ClueCellModel("", "29"));
		gameComponents[59] = new ClueCell(new ClueCellModel("", "23"));
		gameComponents[60] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[61] = new ClueCell(new ClueCellModel("40", ""));
		gameComponents[62] = new TextCell(controller, "8");
		gameComponents[63] = new TextCell(controller, "6");
		gameComponents[64] = new TextCell(controller, "4");
		gameComponents[65] = new TextCell(controller, "1");
		gameComponents[66] = new TextCell(controller, "3");
		gameComponents[67] = new TextCell(controller, "2");
		gameComponents[68] = new TextCell(controller, "7");
		gameComponents[69] = new TextCell(controller, "9");
		gameComponents[70] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[71] = new ClueCell(new ClueCellModel("16", ""));
		gameComponents[72] = new TextCell(controller, "9");
		gameComponents[73] = new TextCell(controller, "7");
		gameComponents[74] = new ClueCell(new ClueCellModel("7", "17"));
		gameComponents[75] = new TextCell(controller, "3");
		gameComponents[76] = new TextCell(controller, "4");
		gameComponents[77] = new ClueCell(new ClueCellModel("11", "4"));
		gameComponents[78] = new TextCell(controller, "5");
		gameComponents[79] = new TextCell(controller, "6");
		gameComponents[80] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[81] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[82] = new ClueCell(new ClueCellModel("12", ""));
		gameComponents[83] = new TextCell(controller, "3");
		gameComponents[84] = new TextCell(controller, "9");
		gameComponents[85] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[86] = new ClueCell(new ClueCellModel("18", ""));
		gameComponents[87] = new TextCell(controller, "1");
		gameComponents[88] = new TextCell(controller, "9");
		gameComponents[89] = new TextCell(controller, "8");
		gameComponents[90] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[91] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[92] = new ClueCell(new ClueCellModel("17", ""));
		gameComponents[93] = new TextCell(controller, "9");
		gameComponents[94] = new TextCell(controller, "8");
		gameComponents[95] = new ClueCell(new ClueCellModel("", ""));
		gameComponents[96] = new ClueCell(new ClueCellModel("11", ""));
		gameComponents[97] = new TextCell(controller, "3");
		gameComponents[98] = new TextCell(controller, "8");
		gameComponents[99] = new ClueCell(new ClueCellModel("", ""));

	}
}
