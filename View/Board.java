package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.GameController;
import Model.ClueCellModel;

public class Board {

	GameController controller;
	JButton validateButton;
	TextCell t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23,
			t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41, t42, t43, t44,
			t45, t46, t47, t48, t49, t50;

	// Constructor called by Game Driver
	public Board() {

		// Create controller
		controller = new GameController();

		// Create JFrame
		JFrame jf = new JFrame("Kakuro");

		// adding labels in order

		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "11")));
		jf.add(new ClueCell(new ClueCellModel("", "16")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "3")));
		jf.add(new ClueCell(new ClueCellModel("", "21")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("12", "7")));
		t1 = new TextCell(controller);
		jf.add(t1);
		t2 = new TextCell(controller);
		jf.add(t2);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("4", "")));
		t3 = new TextCell(controller);
		jf.add(t3);
		t4 = new TextCell(controller);
		jf.add(t4);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("12", "")));
		t5 = new TextCell(controller);
		jf.add(t5);
		t6 = new TextCell(controller);
		jf.add(t6);
		t7 = new TextCell(controller);
		jf.add(t7);
		jf.add(new ClueCell(new ClueCellModel("", "10")));
		jf.add(new ClueCell(new ClueCellModel("6", "16")));
		t8 = new TextCell(controller);
		jf.add(t8);
		t9 = new TextCell(controller);
		jf.add(t9);
		jf.add(new ClueCell(new ClueCellModel("", "17")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("4", "")));
		t10 = new TextCell(controller);
		jf.add(t10);
		t11 = new TextCell(controller);
		jf.add(t11);
		jf.add(new ClueCell(new ClueCellModel("10", "38")));
		t12 = new TextCell(controller);
		jf.add(t12);
		t13 = new TextCell(controller);
		jf.add(t13);
		jf.add(new ClueCell(new ClueCellModel("9", "10")));
		t14 = new TextCell(controller);
		jf.add(t14);
		t15 = new TextCell(controller);
		jf.add(t15);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("37", "")));
		t16 = new TextCell(controller);
		jf.add(t16);
		t17 = new TextCell(controller);
		jf.add(t17);
		t18 = new TextCell(controller);
		jf.add(t18);
		t19 = new TextCell(controller);
		jf.add(t19);
		t20 = new TextCell(controller);
		jf.add(t20);
		t21 = new TextCell(controller);
		jf.add(t21);
		t22 = new TextCell(controller);
		jf.add(t22);
		t23 = new TextCell(controller);
		jf.add(t23);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("10", "17")));
		t24 = new TextCell(controller);
		jf.add(t24);
		t25 = new TextCell(controller);
		jf.add(t25);
		jf.add(new ClueCell(new ClueCellModel("7", "4")));
		t26 = new TextCell(controller);
		jf.add(t26);
		t27 = new TextCell(controller);
		jf.add(t27);
		jf.add(new ClueCell(new ClueCellModel("", "29")));
		jf.add(new ClueCell(new ClueCellModel("", "23")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("40", "")));
		t28 = new TextCell(controller);
		jf.add(t28);
		t29 = new TextCell(controller);
		jf.add(t29);
		t30 = new TextCell(controller);
		jf.add(t30);
		t31 = new TextCell(controller);
		jf.add(t31);
		t32 = new TextCell(controller);
		jf.add(t32);
		t33 = new TextCell(controller);
		jf.add(t33);
		t34 = new TextCell(controller);
		jf.add(t34);
		t35 = new TextCell(controller);
		jf.add(t35);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("16", "")));
		t36 = new TextCell(controller);
		jf.add(t36);
		t37 = new TextCell(controller);
		jf.add(t37);
		jf.add(new ClueCell(new ClueCellModel("7", "17")));
		t38 = new TextCell(controller);
		jf.add(t38);
		t39 = new TextCell(controller);
		jf.add(t39);
		jf.add(new ClueCell(new ClueCellModel("11", "4")));
		t40 = new TextCell(controller);
		jf.add(t40);
		t41 = new TextCell(controller);
		jf.add(t41);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("12", "")));
		t42 = new TextCell(controller);
		jf.add(t42);
		t43 = new TextCell(controller);
		jf.add(t43);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("18", "")));
		t44 = new TextCell(controller);
		jf.add(t44);
		t45 = new TextCell(controller);
		jf.add(t45);
		t46 = new TextCell(controller);
		jf.add(t46);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("17", "")));
		t47 = new TextCell(controller);
		jf.add(t47);
		t48 = new TextCell(controller);
		jf.add(t48);
		jf.add(new ClueCell(new ClueCellModel("", "")));
		jf.add(new ClueCell(new ClueCellModel("11", "")));
		t49 = new TextCell(controller);

		jf.add(t49);
		t50 = new TextCell(controller);
		jf.add(t50);
		jf.add(new ClueCell(new ClueCellModel("", "")));

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(600, 600);
		jf.setLayout(new GridLayout(11, 10));
		jf.setVisible(true);

		// Validate Button
		validateButton = new JButton("validate");
		validateButton.setToolTipText("Validate");
		jf.add(validateButton);

		validateButton.addActionListener(controller);

		controller.bindTextCells(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19,
				t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40,
				t41, t42, t43, t44, t45, t46, t47, t48, t49, t50);
	}
}
