package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(252, 131, 401, 29);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Your Full Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel.setBounds(78, 126, 164, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mobile Number:");
		
		
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(78, 181, 164, 29);
		contentPane.add(lblNewLabel_1);
		
		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String phoneNo=phone.getText();
				int length=phoneNo.length();
				char c=e.getKeyChar();
				
				//checking for numbers validation
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
						{
						if(length<10)	
							//editable true when length is less than 10
							phone.setEditable(true);
						else
							//editable false if length is more than 10
							phone.setEditable(false);
						}
				else
					//allow backspace  and delete keys
				if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)		
				{
					phone.setEditable(true);
				}
				else
				{
					phone.setEditable(false);
				}
				
				
			}
		});
		phone.setBounds(252, 185, 401, 29);
		contentPane.add(phone);
		phone.setColumns(10);
		
		email = new JTextField();
		email.setBounds(252, 239, 268, 29);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email Address:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(78, 231, 164, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Open Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_customers","root","");
					
					Random rand=new Random();
					int crn1=rand.nextInt(10000000);
					
					
					
					java.sql.Statement stmt= conn.createStatement();
					int no=0;
					ResultSet rs=stmt.executeQuery("select count(*) as num from customers");
					while(rs.next()) {
						 no=rs.getInt("num");
					}
					
					

					PreparedStatement ps=conn.prepareStatement("insert into customers(id,CRN,cust_name,phone,email) values(?,?,?,?,?)");
					
					  
					
//					PreparedStatement ps=conn.prepareStatement("insert into users(username,password) values(?,?)");
					ps.setInt(1,++no);
					ps.setInt(2,crn1);
					ps.setString(3, name.getText());
					ps.setString(4, phone.getText());
					ps.setString(5, email.getText());
					int x=ps.executeUpdate();
					
					JButton btnNewButton_1 = new JButton("Proceed to Account opening Form");
					btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15)); 
					btnNewButton_1.setBounds(82, 383, 481, 23);
					btnNewButton_1.setVisible(false);
					contentPane.add(btnNewButton_1);
					
					btnNewButton_1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
						
							
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Details frame = new Details();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
								
						}

						});
							
					
					if(x>0) 
					{
//						System.out.println("RegestrATION SUCESSFUL");
						btnNewButton_1.setVisible(true);
						
					}
					else {
						System.out.println("registration failed");
					}
				 		
					
			   			
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(259, 326, 133, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Open A Digital Savings Bank Account");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Banner", Font.BOLD, 24));
		lblNewLabel_3.setBounds(166, 59, 371, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("The  AB  Bank");
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(144, 11, 446, 37);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("X");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you Sure to close this Application")==0)
					System.exit(0);
			}
		});
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 23));
		lblNewLabel_5.setBounds(696, 0, 32, 29);
		contentPane.add(lblNewLabel_5);
		
		
		setUndecorated(true);
		
		
	}
}
