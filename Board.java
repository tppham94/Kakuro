import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class Board {
	public static void main(String[] args)  {
		JFrame jf = new JFrame("Kakuro");
		
//adding labels in order
		
		

		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("11\\"));
		jf.add(new ClueCell("16\\"));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("3\\"));
		jf.add(new ClueCell("21\\"));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("7\\12"));
		TextCell t1=new TextCell();
		jf.add(t1);
		TextCell t2=new TextCell();
		jf.add(t2);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\4"));
		TextCell t3=new TextCell();
		jf.add(t3);
		TextCell t4=new TextCell();
		jf.add(t4);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\12"));
		TextCell t5=new TextCell();
		jf.add(t5);
		TextCell t6=new TextCell();
		jf.add(t6);
		TextCell t7=new TextCell();
		jf.add(t7);
		jf.add(new ClueCell("10\\"));
		jf.add(new ClueCell("16\\6"));
		TextCell t8=new TextCell();
		jf.add(t8);
		TextCell t9=new TextCell();
		jf.add(t9);
		jf.add(new ClueCell("17\\"));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\4"));
		TextCell t10=new TextCell();
		jf.add(t10);
		TextCell t11=new TextCell();
		jf.add(t11);
		jf.add(new ClueCell("38\\10"));
		TextCell t12=new TextCell();
		jf.add(t12);
		TextCell t13=new TextCell();
		jf.add(t13);
		jf.add(new ClueCell("10\\9"));
		TextCell t14=new TextCell();
		jf.add(t14);
		TextCell t15=new TextCell();
		jf.add(t15);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\37"));
		TextCell t16=new TextCell();
		jf.add(t16);
		TextCell t17=new TextCell();
		jf.add(t17);
		TextCell t18=new TextCell();
		jf.add(t18);
		TextCell t19=new TextCell();
		jf.add(t19);
		TextCell t20=new TextCell();
		jf.add(t20);
		TextCell t21=new TextCell();
		jf.add(t21);
		TextCell t22=new TextCell();
		jf.add(t22);
		TextCell t23=new TextCell();
		jf.add(t23);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));   
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("17\\10"));
		TextCell t24=new TextCell();
		jf.add(t24);
		TextCell t25=new TextCell();
		jf.add(t25);
		jf.add(new ClueCell("4\\7"));
		TextCell t26=new TextCell();
		jf.add(t26);
		TextCell t27=new TextCell();
		jf.add(t27);
		jf.add(new ClueCell("29\\"));
		jf.add(new ClueCell("23\\"));  
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\40"));
		TextCell t28=new TextCell();
		jf.add(t28);
		TextCell t29=new TextCell();
		jf.add(t29);
		TextCell t30=new TextCell();
		jf.add(t30);
		TextCell t31=new TextCell();
		jf.add(t31);
		TextCell t32=new TextCell();
		jf.add(t32);
		TextCell t33=new TextCell();
		jf.add(t33);
		TextCell t34=new TextCell();
		jf.add(t34);
		TextCell t35=new TextCell();
		jf.add(t35);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\16"));
		TextCell t36=new TextCell();
		jf.add(t36);
		TextCell t37=new TextCell();
		jf.add(t37);
		jf.add(new ClueCell("17\\7"));
		TextCell t38=new TextCell();
		jf.add(t38);
		TextCell t39=new TextCell();
		jf.add(t39);
		jf.add(new ClueCell("4\\11"));
		TextCell t40=new TextCell();
		jf.add(t40);
		TextCell t41=new TextCell();
		jf.add(t41);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\12"));
		TextCell t42=new TextCell();
		jf.add(t42);
		TextCell t43=new TextCell();
		jf.add(t43);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\18"));
		TextCell t44=new TextCell();
		jf.add(t44);
		TextCell t45=new TextCell();
		jf.add(t45);
		TextCell t46=new TextCell();
		jf.add(t46);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\17"));
		TextCell t47=new TextCell();
		jf.add(t47);
		TextCell t48=new TextCell();
		jf.add(t48);
		jf.add(new ClueCell(""));
		jf.add(new ClueCell("\\11"));
		TextCell t49=new TextCell();
		jf.add(t49);
		TextCell t50=new TextCell();
		jf.add(t50);
		jf.add(new ClueCell(""));
		
		
		
		
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(500, 500);
		jf.setLayout(new GridLayout(11, 10));
		jf.setVisible(true);
		
		
		
		JButton button = new JButton("validate");
		
		jf.add(button);
		button.addActionListener(new ActionListener(){
			 

			@Override   
			public void actionPerformed(ActionEvent arg0) {   //validates if all textfields are equal to the solution
				if(t1.getText().equals("5") &&
				   t2.getText().equals("7") &&
				   t3.getText().equals("1") &&
				   t4.getText().equals("3") &&
				   t5.getText().equals("2") &&
				   t6.getText().equals("1") &&
				   t7.getText().equals("9") &&
				   t8.getText().equals("2") &&
				   t9.getText().equals("4") &&
				   t10.getText().equals("1") &&
				   t11.getText().equals("3") &&
				   t12.getText().equals("1") &&
				   t13.getText().equals("9") &&
				   t14.getText().equals("1") &&
				   t15.getText().equals("8") &&
				   t16.getText().equals("4") &&
				   t17.getText().equals("2") &&
				   t18.getText().equals("5") &&
				   t19.getText().equals("3") &&
				   t20.getText().equals("7") &&
				   t21.getText().equals("1") &&
				   t22.getText().equals("6") &&
				   t23.getText().equals("9") &&
				   t24.getText().equals("8") &&
				   t25.getText().equals("2") &&
				   t26.getText().equals("2") &&
				   t27.getText().equals("5") &&
				   t28.getText().equals("8") &&
				   t29.getText().equals("6") &&
				   t30.getText().equals("4") &&
				   t31.getText().equals("1") &&
				   t32.getText().equals("3") &&
				   t33.getText().equals("2") &&
				   t34.getText().equals("7") &&
				   t35.getText().equals("9") &&
				   t36.getText().equals("9") &&
				   t37.getText().equals("7") &&
				   t38.getText().equals("3") &&
				   t39.getText().equals("4") &&
				   t40.getText().equals("5") &&
				   t41.getText().equals("6") &&
				   t42.getText().equals("3") &&
				   t43.getText().equals("9") &&
				   t44.getText().equals("1") &&
				   t45.getText().equals("9") &&
				   t46.getText().equals("8") &&
				   t47.getText().equals("9") &&
				   t48.getText().equals("8") &&
				   t49.getText().equals("3") &&
				   t50.getText().equals("8") ) {
					System.out.println("true");
					button.setBackground(Color.GREEN);
				}else {
					System.out.println("false");
					button.setBackground(Color.RED);
				}
				
				
			}
			});
		
		
		
	}
}
