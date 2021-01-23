package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NetBankLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField passwd;
	private JTextField check;
	private JTextField crn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public NetBankLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 502);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("The AB Bank");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(239, 11, 309, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Your Perfect Banking Partner");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(338, 50, 236, 14);
		contentPane.add(lblNewLabel);
		
		ImageIcon img=new ImageIcon("user.png");
		ImageIcon img1=new ImageIcon("key.png");	
		ImageIcon img2=new ImageIcon("key.png");
		
		
		JLabel lblNewLabel_2 = new JLabel("UserName");
		JLabel lblNewLabel_6 = new JLabel("UserName must be 8 characters Long.");
		lblNewLabel_6.setBounds(258, 246, 327, 14);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		
		username = new JTextField();
		username.setBounds(258, 205, 230, 30);
		contentPane.add(username);
		username.setColumns(10);
		
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseEntered(MouseEvent e) {
				
				String input=username.getText();
				if(input.length()<=7)
				lblNewLabel_6.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(102, 189, 483, 58);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(102, 271, 483, 58);
		contentPane.add(lblNewLabel_3);
		
		
 		
		passwd = new JTextField();
		passwd.setColumns(10);
		passwd.setBounds(258, 287, 230, 30);
		contentPane.add(passwd);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(102, 349, 483, 58);
		contentPane.add(lblNewLabel_4);
		
		check = new JTextField();
		check.setBounds(258, 365, 230, 30);
		contentPane.add(check);
		check.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_customers","root","");
					
					
                    PreparedStatement ps=conn.prepareStatement("insert into Netbanking(Username,Password,CRN) values(?,?,?)");
					
					ps.setString(1, username.getText());
					ps.setString(2, passwd.getText());
					ps.setString(3, crn.getText());
					
					
					String no=crn.getText(); 
					 int num=Integer.parseInt(no);
					 
					PreparedStatement stmt= conn.prepareStatement("select count(*) as flag from customers where CRN=? ");
					stmt.setInt(1,num);
					 
				     int result=0;
					ResultSet rs=stmt.executeQuery();
					while(rs.next()) {
						
						  result=rs.getInt("flag");
					}
					 if(result==1)
						      {
						 String p1=passwd.getText();
						 String p2=check.getText();						    		
									if(p1.equals(p2))
										{
										int x=ps.executeUpdate();
												if(x>0)
												{
							                        JFrame f=new JFrame();
							                        JOptionPane.showMessageDialog(f, "Net-Banking Username  and passWord Generated.","Alert",JOptionPane.WARNING_MESSAGE);
												}
												else {
													JFrame f=new JFrame();
							                        JOptionPane.showMessageDialog(f, "Net-Banking Login not generated. Try again after some time.","Alert",JOptionPane.WARNING_MESSAGE); 	
												}
										}
									else
									{
										JFrame f=new JFrame();
										JOptionPane.showMessageDialog(f, "Passwords are not matched","Alert",JOptionPane.WARNING_MESSAGE); 	
									}
								}
						    	  
						      
				else{
					  JFrame f=new JFrame();
                      JOptionPane.showMessageDialog(f, "Incorrect CRN","Alert",JOptionPane.WARNING_MESSAGE);
				}
					
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
				
			}
			});
		
		
		
		btnNewButton.setBounds(294, 418, 138, 23);
		contentPane.add(btnNewButton);
	
		
		
		
		JLabel lblNewLabel_5 = new JLabel(img,JLabel.CENTER);
		lblNewLabel_5.setBounds(500, 121, 74, 57);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel(img1,JLabel.CENTER);
		lblNewLabel_5_1.setBounds(498, 217, 76, 57);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel(img2,JLabel.CENTER);
		lblNewLabel_5_2.setBounds(500, 313, 74, 57);
		contentPane.add(lblNewLabel_5_2);
		
		
		
		JLabel lblNewLabel_6_1 = new JLabel("Password must be at least 8 digits.");
		lblNewLabel_6_1.setBounds(258, 328, 423, 23);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("Your CRN");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(102, 121, 472, 53);
		contentPane.add(lblNewLabel_7);
		
		crn = new JTextField();
		crn.setBounds(258, 134, 230, 30);
		contentPane.add(crn);
		crn.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("visit TheAB_Bank.com for logging in into Your Internet banking");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_8.setBounds(102, 449, 380, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Click Here");
		lblNewLabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginHome frame = new LoginHome();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		lblNewLabel_9.setForeground(Color.MAGENTA);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(452, 440, 109, 23);
		contentPane.add(lblNewLabel_9);
	}
}
