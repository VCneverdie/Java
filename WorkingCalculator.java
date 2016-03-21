/**
 * @author Ying Cui
 * This is a working calculator. 
 * It contains four basic functions(add, subtract, multiply and divide)
 * Button C is for deleting the text in text field and starting a new operation.
 * Button CE is for deleting the last number.
 * Button % is percentage.
 * Button +/- is for making number positive or negative.
 * If you want to do multiple calculation, please always press equals after one operation.
 * For example: 3 + 2 + 1. Press "3" "+" "2" "=" "+" "1" "="
 * 
 */

import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.*;

public class WorkingCalculator extends JFrame  {
	private JTextField display;
	JButton[] btn = new JButton[20];
	double number1 = 0, number2 = 0, result = 0;
	int operator = 0;
	
	public WorkingCalculator()
	{
		super("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(280, 400);
		Container c = getContentPane();
		display = new JTextField();
		c.add(BorderLayout.NORTH, display);
		Font f = new Font("Helvetica", Font.PLAIN, 70);
		display.setFont(f);
		display.setEditable(false);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5, 4));
		String[] btname = {
				"C", "CE", "%", "/",
				"7", "8", "9", "*",
				"4", "5", "6", "-",
				"1", "2", "3", "+",
				"+/-", "0", ".", "="};
		for (int i = 0; i < btn.length; i++)	
		{
			btn[i] = new JButton(btname[i]);
			p.add(btn[i]);
			//number buttons
			if ((i >= 4 && i <=6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14) || i == 17 || i == 18)
				btn[i].addActionListener(new NumberActionListener());
			//operation buttons
			if (i == 3 || i == 7 || i == 11 || i == 15)
			{
				btn[i].addActionListener(new OperationActionListener());
			}
			if (i == 19)
			{
				btn[i].addActionListener(new EqualActionListener());
			}
			if (i == 0)
			{
				btn[i].addActionListener(new DeleteActionListener());
			}
			if (i == 1)
				btn[i].addActionListener(new DeleteOneActionListener());
			if (i == 2)
				btn[i].addActionListener(new PercentageActionListener());
			if (i == 16)
				btn[i].addActionListener(new PNActionListener());
		}
		c.add(BorderLayout.CENTER, p);

		this.setVisible(true);		
	}
	
	
	// action listener of buttons
	class NumberActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e1)
		{
			display.setText(display.getText().concat(((JButton)e1.getSource()).getText()));
		}
	}
	class OperationActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e2)
		{
			number1 = Double.parseDouble(display.getText());
			display.setText("");
			JButton operB = (JButton)e2.getSource();
			if (operB == btn[3])
				operator = 4;
			else if (operB == btn[7])
				operator = 3;
			else if (operB == btn[11])
				operator = 2;
			else if (operB == btn[15])
				operator = 1;
		}
	}
	class EqualActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e3)
		{
			number2 = Double.parseDouble(display.getText());
			switch(operator)
			{
				case 1:
					result = number1 + number2;
					break;
				case 2:
					result = number1 - number2;
					break;
				case 3:
					result = number1 * number2;
					break;
				case 4:
					result = number1 / number2;
					break;
			}
			display.setText("" + result);
		}
	}
	class DeleteActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e4)
		{
			display.setText("");
			number1 = 0;
			number2 = 0;
			result = 0;
		}
	}
	class DeleteOneActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e5)
		{
			try
			{
				display.setText(display.getText(0, display.getDocument().getLength() - 1));
			} catch (BadLocationException e6)
			{
				e6.printStackTrace();
			}
		}
	}
	class PercentageActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e7)
		{
			double num = Double.parseDouble(display.getText());
			String text = String.valueOf(num * 0.01);
			display.setText(text);
		}
	}
	class PNActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e8)
		{
			double num = Double.parseDouble(display.getText());
			num = -num;
			String text = String.valueOf(num);
			display.setText(text);
		}
	}
	public static void main(String[] a) {
		new WorkingCalculator();
	}
}
