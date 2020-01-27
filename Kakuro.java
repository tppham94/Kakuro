import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Kakuro {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		// JPanel jp=new JPanel(new GridLayout());
		JTextField t7, t8, t9, t10, t12, t13, t14, t15, t16, t17, t19, t20, t21, t23, t24, t25;
		JLabel l1, l2, l3, l4, l5,l6, l11_a, l11_b, l18, l22;
		JPanel jp = new JPanel();
//adding labels in order
		l1 = new JLabel("");
		l2 = new JLabel("13");
		l3 = new JLabel("11");
		l4 = new JLabel("26");
		l5 = new JLabel("22");
		l6 = new JLabel("25");
		// text field in order
		t7 = new JTextField("4");
		t8 = new JTextField("0");
		t9 = new JTextField("8");
		t10 = new JTextField("0");
		//adding panel
		l11_a = new JLabel("21");
		l11_b = new JLabel("10");
		jp.add(l11_a);
		jp.add(l11_b);
		//adding text field 
		t12 = new JTextField("0");
		t13 = new JTextField("0");
		t14 = new JTextField("0");
		t15 = new JTextField("0");
		t16 = new JTextField("0");
		t17 = new JTextField("0");
		//Labels
		l18 = new JLabel("11");
	//text fields
		
		t19 = new JTextField("0");
		t20 = new JTextField("0");
		t21 = new JTextField("0");
		//labels
		l22 = new JLabel("15");
		//textfields
		t23 = new JTextField("0");
		t24 = new JTextField("0");
		t25 = new JTextField("0");
		// Label--------
	
	
		//jp.add(l11_a, l11_b);
		
//
		jf.add(l1);
	//	l1.setBackground(Color.black);
		jf.add(l2);
		jf.add(l3);
		jf.add(l4);
		jf.add(l5);
		jf.add(l6);
	
//Adding text feild
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
	

		jf.setSize(400, 400);
		jf.setLayout(new GridLayout(5, 5));
		jf.setVisible(true);
	}
}
