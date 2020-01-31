package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.TextCell;

public class GameController implements ActionListener, FocusListener {

	TextCell t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23,
			t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37, t38, t39, t40, t41, t42, t43, t44,
			t45, t46, t47, t48, t49, t50;

	public GameController() {
		super();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (t1.getText().equals("5") && t2.getText().equals("7") && t3.getText().equals("1") && t4.getText().equals("3")
				&& t5.getText().equals("2") && t6.getText().equals("1") && t7.getText().equals("9")
				&& t8.getText().equals("2") && t9.getText().equals("4") && t10.getText().equals("1")
				&& t11.getText().equals("3") && t12.getText().equals("1") && t13.getText().equals("9")
				&& t14.getText().equals("1") && t15.getText().equals("8") && t16.getText().equals("4")
				&& t17.getText().equals("2") && t18.getText().equals("5") && t19.getText().equals("3")
				&& t20.getText().equals("7") && t21.getText().equals("1") && t22.getText().equals("6")
				&& t23.getText().equals("9") && t24.getText().equals("8") && t25.getText().equals("2")
				&& t26.getText().equals("2") && t27.getText().equals("5") && t28.getText().equals("8")
				&& t29.getText().equals("6") && t30.getText().equals("4") && t31.getText().equals("1")
				&& t32.getText().equals("3") && t33.getText().equals("2") && t34.getText().equals("7")
				&& t35.getText().equals("9") && t36.getText().equals("9") && t37.getText().equals("7")
				&& t38.getText().equals("3") && t39.getText().equals("4") && t40.getText().equals("5")
				&& t41.getText().equals("6") && t42.getText().equals("3") && t43.getText().equals("9")
				&& t44.getText().equals("1") && t45.getText().equals("9") && t46.getText().equals("8")
				&& t47.getText().equals("9") && t48.getText().equals("8") && t49.getText().equals("3")
				&& t50.getText().equals("8")) {

			((JButton) e.getSource()).setBackground(Color.GREEN);
			JOptionPane.showMessageDialog(null, "Well Played!");
		} else {
			((JButton) e.getSource()).setBackground(Color.RED);
			JOptionPane.showMessageDialog(null, "Try Again!");
			((JButton) e.getSource()).setBackground(new JButton().getBackground());
		}
	}

	public void bindTextCells(TextCell t1, TextCell t2, TextCell t3, TextCell t4, TextCell t5, TextCell t6,
			TextCell t7, TextCell t8, TextCell t9, TextCell t10, TextCell t11, TextCell t12, TextCell t13, TextCell t14,
			TextCell t15, TextCell t16, TextCell t17, TextCell t18, TextCell t19, TextCell t20, TextCell t21,
			TextCell t22, TextCell t23, TextCell t24, TextCell t25, TextCell t26, TextCell t27, TextCell t28,
			TextCell t29, TextCell t30, TextCell t31, TextCell t32, TextCell t33, TextCell t34, TextCell t35,
			TextCell t36, TextCell t37, TextCell t38, TextCell t39, TextCell t40, TextCell t41, TextCell t42,
			TextCell t43, TextCell t44, TextCell t45, TextCell t46, TextCell t47, TextCell t48, TextCell t49,
			TextCell t50) {

		this.t1 = t1;
		this.t2 = t2;
		this.t3 = t3;
		this.t4 = t4;
		this.t5 = t5;
		this.t6 = t6;
		this.t7 = t7;
		this.t8 = t8;
		this.t9 = t9;
		this.t10 = t10;
		this.t11 = t11;
		this.t12 = t12;
		this.t13 = t13;
		this.t14 = t14;
		this.t15 = t15;
		this.t16 = t16;
		this.t17 = t17;
		this.t18 = t18;
		this.t19 = t19;
		this.t20 = t20;
		this.t21 = t21;
		this.t22 = t22;
		this.t23 = t23;
		this.t24 = t24;
		this.t25 = t25;
		this.t26 = t26;
		this.t27 = t27;
		this.t28 = t28;
		this.t29 = t29;
		this.t30 = t30;
		this.t31 = t31;
		this.t32 = t32;
		this.t33 = t33;
		this.t34 = t34;
		this.t35 = t35;
		this.t36 = t36;
		this.t37 = t37;
		this.t38 = t38;
		this.t39 = t39;
		this.t40 = t40;
		this.t41 = t41;
		this.t42 = t42;
		this.t43 = t43;
		this.t44 = t44;
		this.t45 = t45;
		this.t46 = t46;
		this.t47 = t47;
		this.t48 = t48;
		this.t49 = t49;
		this.t50 = t50;

	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {

		String cellValue = ((TextCell) e.getSource()).getText();

		if (cellValue == null || "".equalsIgnoreCase(cellValue)) {
			return;
		}

		int value = 0;

		try {
			value = Integer.parseInt(((TextCell) e.getSource()).getText());
		} catch (java.lang.Exception ex) {
			promptValidationError(e, "Value should be a digit.");
			return;
		}

		if (value < 1 || value > 9) {
			promptValidationError(e, "Value should be between 1 and 9.");
			return;
		}
	}
	
	private void promptValidationError(FocusEvent e, String errorMessage) {
		TextCell cell = ((TextCell) e.getSource());
		cell.setBackground(Color.red);
		JOptionPane.showMessageDialog(null, errorMessage);
		cell.setBackground(Color.white);
		cell.setText("");
	}
}
