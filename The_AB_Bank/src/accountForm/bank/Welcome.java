package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 51, 255));
		contentPane.setBackground(new Color(255, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon img=new ImageIcon("banklogo1.jpg");
	
		
		
		JLabel biglabel = new JLabel(img,JLabel.CENTER);
		biglabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		biglabel.setText("");
		biglabel.setForeground(Color.MAGENTA);
		biglabel.setBounds(0, 0, 751, 461);
		contentPane.add(biglabel);
		
		
		
		JLabel lblNewLabel = new JLabel("Welcome to AB Bank");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel.setBounds(135, 21, 452, 69);
		biglabel.add(lblNewLabel);
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_customers","root","");
			java.sql.Statement stmt=conn.createStatement();
			String acNumber=null;
			int crn=0;
			ResultSet rs=stmt.executeQuery("select phone from customers where id=(select count(*) from customers)");
			
			while(rs.next())
			{
				acNumber ="91"+rs.getString("phone");
				
			}
			ResultSet rs1=stmt.executeQuery("select CRN  from customers where id=(select count(*) from customers)");
			while(rs1.next())
			{
				crn=rs1.getInt("CRN");
			}
			
			JLabel lblNewLabel_2 = new JLabel("IFSC CODE : ABKY0123456");
			biglabel.add(lblNewLabel_2);
			lblNewLabel_2.setForeground(Color.MAGENTA);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.BOLD, 21));
			lblNewLabel_2.setBounds(135, 178, 452, 40);
			JLabel lblNewLabel_3 = new JLabel("Your Account Number:"+ acNumber);
			biglabel.add(lblNewLabel_3);
			lblNewLabel_3.setForeground(Color.MAGENTA);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 21));
			lblNewLabel_3.setBounds(135, 220, 452, 33);
			
			JLabel lblNewLabel_2_1 = new JLabel("CRN : " +crn);
			biglabel.add(lblNewLabel_2_1);
			lblNewLabel_2_1.setForeground(Color.MAGENTA);
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setFont(new Font("Yu Gothic Medium", Font.BOLD, 21));
			lblNewLabel_2_1.setBounds(135, 264, 417, 40);
			
			JLabel lblNewLabel_4 = new JLabel("Bank Securely 24*7  (Banking At Your Fingertips)");
			biglabel.add(lblNewLabel_4);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_4.setBounds(163, 315, 419, 29);
			
			JButton btnNewButton = new JButton("Generate Net-Banking Username And Password");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								NetBankLogin frame = new NetBankLogin();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				
				}
				
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			biglabel.add(btnNewButton);
			btnNewButton.setBounds(203, 405, 339, 23);
			
			JLabel lblNewLabel_1 = new JLabel("Thanks for creating a digital Bank Account with us");
			biglabel.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.RED);
			lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 23));
			lblNewLabel_1.setBounds(34, 88, 661, 62);
			
			JLabel lblNewLabel_5 = new JLabel("Please Kindly Note Your CRN  It will be Required while generating Net-Banking Username and Password ");
			lblNewLabel_5.setForeground(Color.CYAN);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblNewLabel_5.setBounds(10, 355, 720, 23);
			biglabel.add(lblNewLabel_5);
			
			
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		
		
	
  }
}
