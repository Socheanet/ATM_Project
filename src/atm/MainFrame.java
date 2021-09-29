package atm;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField card_no;
	private JPasswordField pinCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setTitle("ATM Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.MAGENTA);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(53, 78, 96, 32);
		contentPane.add(lblNewLabel_1);
		
		card_no = new JTextField();
		card_no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		card_no.setFont(new Font("Tahoma", Font.PLAIN, 11));
		card_no.setBounds(180, 84, 168, 20);
		contentPane.add(card_no);
		card_no.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PIN Code");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(53, 131, 96, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton sign_up = new JButton("Sign Up");
		sign_up.setForeground(Color.BLUE);
		sign_up.setBackground(Color.ORANGE);
		sign_up.setBounds(53, 188, 89, 23);
		contentPane.add(sign_up);
		
		JButton sign_in = new JButton("Sign In");
		sign_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm","root","");
					Statement stmt=con.createStatement();
					String sql = "Select * from card_no where Card_Number='"+card_no.getText()+"'";
					String sql2 = "Select * from pin_code where Pin_Code='"+pinCode.getText()+"'" ;
					ResultSet rs = stmt.executeQuery(sql);
					boolean r1 = rs.next();
					ResultSet rm = stmt.executeQuery(sql2);
					boolean r2= rm.next();
					if(r1&&r2) {
						//JOptionPane.showMessageDialog(null, "Login Sucessfully...");
						Menu form = new Menu();
						form.setVisible(true);
						form.pack();
						form.setLocationRelativeTo(null);
						form.setBounds(100, 100, 516, 381);
						form.setLocationRelativeTo(null);
						// close the currrent form
						dispose();
						
						}
					else 
						JOptionPane.showMessageDialog(null, "Incorrect Card Number and PIN Code...");
					con.close();
				}catch(Exception e1) {System.out.print(e1);}
			}
			
		});
		sign_in.setForeground(Color.BLUE);
		sign_in.setBackground(Color.ORANGE);
		sign_in.setBounds(180, 188, 89, 23); 
		contentPane.add(sign_in);
		
		JButton btnNewButton = new JButton("Forget PIN");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(307, 188, 89, 23);
		contentPane.add(btnNewButton);
		
		pinCode = new JPasswordField();
		pinCode.setBounds(180, 137, 168, 20);
		contentPane.add(pinCode);
		
		Panel panel = new Panel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.ORANGE);
		panel.setBounds(53, 10, 343, 32);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("ATM Interface");
		panel.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel card_icon = new JLabel("");
		card_icon.setBounds(28, 78, 33, 32);
		contentPane.add(card_icon);
		//set icon for jLabel
		
		
		
		//set location to the center of the screen
		this.setLocationRelativeTo(null);
	}
}
