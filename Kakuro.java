
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Kakuro {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Kakuro");
		// JPanel jp=new JPanel(new GridLayout());
		JTextField t7, t8, t9, t10, t12, t13, t14, t15, t16, t17, t19, t20, t21, t23, t24, t25;
		JLabel l1, l2, l3, l4, l5,l6, l11_a, l11_b, l18, l22;
		JPanel jp = new JPanel();
//adding labels in order
		l1 = new JLabel("");
		l2 = new JLabel("13", JLabel.CENTER);
		l3 = new JLabel("11", JLabel.CENTER);
		l4 = new JLabel("26", JLabel.CENTER);
		l5 = new JLabel("22", JLabel.CENTER);
		l6 = new JLabel("25", JLabel.RIGHT);
		// text field in order
		t7 = new JTextField("");
		t8 = new JTextField("");
		t9 = new JTextField("");
		t10 = new JTextField("");
		//adding panel
		l11_a = new JLabel("21");
		l11_b = new JLabel("10");
		jp.add(l11_a);
		jp.add(l11_b);
		//adding text field 
		t12 = new JTextField("");
		t13 = new JTextField("");
		t14 = new JTextField("");
		t15 = new JTextField("");
		t16 = new JTextField("");
		t17 = new JTextField("");
		//Labels
		l18 = new JLabel("11", JLabel.RIGHT);
	//text fields
		
		t19 = new JTextField("");
		t20 = new JTextField("");
		t21 = new JTextField("");
		//labels
		l22 = new JLabel("15", JLabel.RIGHT);
		//textfields
		t23 = new JTextField("");
		t24 = new JTextField("");
		t25 = new JTextField("");
		// Label--------
	
	
		//jp.add(l11_a, l11_b);
		

		jf.add(l1);
	//	l1.setBackground(Color.black);
		jf.add(l2);
		jf.add(l3);
		jf.add(l4);
		jf.add(l5);
		jf.add(l6);
	
//Adding text field
		jf.add(t7);
		jf.add(t8);
		jf.add(t9);
		jf.add(t10);
		jf.add(jp);
		jf.add(t12);
		jf.add(t13);
		jf.add(t14);
		jf.add(t15);
		jf.add(t16);
		jf.add(t17);
		jf.add(l18);
		jf.add(t19);
		jf.add(t20);
		jf.add(t21);
		jf.add(l22);
		jf.add(t23);
		jf.add(t24);
		jf.add(t25);
l1.setBackground(Color.BLACK);

		jp.setBackground(Color.gray);
	
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 500);
		jf.setLayout(new GridLayout(6, 6));
		jf.setVisible(true);
		
		JButton button = new JButton("validate");
		jf.add(button);		
		button.addActionListener(new ActionListener(){
			 

			@Override   
			public void actionPerformed(ActionEvent arg0) {   //validates if all textfields are equal to the solution
				if(t7.getText().equals("4") && t8.getText().equals("6") && t9.getText().equals("8") && t10.getText().equals("7") && t12.getText().equals("3") &&
						t13.getText().equals("5") && t14.getText().equals("7") && t15.getText().equals("6") && t16.getText().equals("8") && t17.getText().equals("6") &&
						t19.getText().equals("6") && t20.getText().equals("5") && t21.getText().equals("2") && t23.getText().equals("6") && t24.getText().equals("5") && 
						t25.getText().equals("4")) {
					System.out.println("true");
					button.setBackground(Color.GREEN);
				}else {
					System.out.println("false");
					button.setBackground(Color.RED);
				}
				
				if(t7.getText().equals("4")) {
					System.out.println("true2");
					button.setBackground(Color.GREEN);
				}
			}
			});
		
		
		
	}
}