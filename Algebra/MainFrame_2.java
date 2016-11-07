package Algebra;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame_2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame_2 frame = new MainFrame_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Font f = new Font("Helvetica", Font.PLAIN, 12);
		
		JButton btnNewButton = new JButton("Arithmetics Mode");
		btnNewButton.setFont(f);
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new ArithFrame_2();
//			}
//		});
		btnNewButton.setBounds(56, 87, 136, 86);
		contentPane.add(btnNewButton);
		
		JButton btnMode = new JButton("Variable Mode");
		btnMode.setFont(f);
//		btnMode.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Variable_2()
//			}
//		});
		btnMode.setBounds(238, 87, 136, 86);
		contentPane.add(btnMode);
	}
}
