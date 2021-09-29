package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(72, 30, 356, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To ATM Interface");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(54, 11, 264, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JButton btnDeposite = new JButton("Deposite");
		btnDeposite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeposite.setForeground(Color.ORANGE);
		btnDeposite.setBackground(new Color(0, 0, 255));
		btnDeposite.setBounds(10, 145, 198, 47);
		contentPane.add(btnDeposite);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setForeground(Color.ORANGE);
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnWithdraw.setBackground(new Color(0, 0, 255));
		btnWithdraw.setBounds(292, 145, 198, 47);
		contentPane.add(btnWithdraw);
		
		JButton btnCheckAmount = new JButton("Check Amount");
		btnCheckAmount.setForeground(Color.ORANGE);
		btnCheckAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCheckAmount.setBackground(new Color(0, 0, 255));
		btnCheckAmount.setBounds(10, 241, 198, 47);
		contentPane.add(btnCheckAmount);
		
		JButton btnChangePin = new JButton("Change PIN");
		btnChangePin.setForeground(Color.ORANGE);
		btnChangePin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangePin.setBackground(new Color(0, 0, 255));
		btnChangePin.setBounds(292, 241, 198, 47);
		contentPane.add(btnChangePin);
		this.setLocationRelativeTo(null);
	}
}
