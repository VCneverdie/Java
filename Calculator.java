/**
 * @author Ying Cui
 * This is just the window of calculator. It's not the working one.
 */
import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame  {
	public Calculator(String title, Color bg) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(280, 400);
		Container c = getContentPane();
		c.setBackground(bg);
		JTextField display = new JTextField();
		c.add(BorderLayout.NORTH,  display = new JTextField("Number"));
		Font f = new Font("Times", Font.PLAIN, 70);
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
		for (int i = 0; i < btname.length; i++)	
		{
			JButton b = new JButton(btname[i]);
			p.add(b);
		}
		c.add(BorderLayout.CENTER, p);

		this.setVisible(true);		
	}
	
	
	public static void main(String[] a) {
		new Calculator("Calculator", Color.WHITE);
	}
}