package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginHome extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass1;
	private JTextField Username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public LoginHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 752, 488);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The AB Bank");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(171, 30, 311, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Perfect Banking Partner");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(339, 72, 209, 14);
		contentPane.add(lblNewLabel_1);
		
		pass1 = new JPasswordField();
		pass1.setToolTipText("");
		pass1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass1.setBounds(492, 273, 140, 20);
		contentPane.add(pass1);
		
		Username = new JTextField();
		Username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_customers","root","");
					
					String name=Username.getText();
					PreparedStatement stmt= conn.prepareStatement("select count(*) as flag from netbanking where username=? ");
					stmt.setString(1,name);
					int result=0;
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						result=rs.getInt("flag");
						
					}
					ImageIcon imgg=new ImageIcon("verified.jpg");
					JLabel checklabel = new JLabel(imgg,JLabel.CENTER);
					checklabel.setBounds(640, 178, 60, 53);
					contentPane.add(checklabel);
					checklabel.setVisible(false);
					
					 if(result==1) {
									
									checklabel.setVisible(true);
					 }else {
						 
						 checklabel.setVisible(false);
					 }
					 
					 }catch(Exception ex){
				ex.printStackTrace();
			}
			
				
			}
		});
		Username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Username.setText("UserName");
		Username.setBounds(492, 193, 140, 20);
		contentPane.add(Username);
		Username.setColumns(10);
		ImageIcon img=new ImageIcon("user.png");
		ImageIcon img1=new ImageIcon("lockimg.jpg");	
		ImageIcon img2=new ImageIcon("key.png");
		ImageIcon img3=new ImageIcon("bankig.jpg");
		
		JLabel lblNewLabel_5 = new JLabel(img,JLabel.CENTER);
		lblNewLabel_5.setBounds(386, 169, 77, 71);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel(img1,JLabel.CENTER);
		lblNewLabel_5_1.setBackground(new Color(255, 182, 193));
		lblNewLabel_5_1.setBounds(386, 252, 77, 71);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel(img2,JLabel.CENTER);
		lblNewLabel_5_2.setBounds(386, 334, 77, 71);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(492, 258, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel(img3,JLabel.CENTER);
		lblNewLabel_4.setBounds(548, 30, 115, 114);
		contentPane.add(lblNewLabel_4);
		
	
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_customers","root","");
					
					String name=Username.getText();
					PreparedStatement stmt= conn.prepareStatement("select count(*) as flag from netbanking where username=? ");
					stmt.setString(1,name);
					int result=0;
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						result=rs.getInt("flag");
						
					}
					
					 if(result==1)
				      {
						 
						 
						 PreparedStatement stmt1= conn.prepareStatement("select password from netbanking where username=? ");
							stmt1.setString(1,name);
							String db_password=null;
							ResultSet rs1=stmt1.executeQuery();
							while(rs1.next())
							{
								db_password=rs1.getString("password");
								
							}
						 
						 
				        @SuppressWarnings("deprecation")
						String p1=pass1.getText();
				 		String p2=db_password;		    		
							if(p1.equals(p2))
								{
									JFrame f=new JFrame();
									JOptionPane.showMessageDialog(f, "Successful Login","Alert",JOptionPane.WARNING_MESSAGE); 	   
								}
							else
							{
								JFrame f=new JFrame();
								JOptionPane.showMessageDialog(f, "Incorrect UserName And Password","Alert",JOptionPane.WARNING_MESSAGE); 	
							}
						}
				    	  
					else{
						  JFrame f=new JFrame();
			             JOptionPane.showMessageDialog(f, "Username Not Available","Alert",JOptionPane.WARNING_MESSAGE);
					    }
			
						
					
		}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
			
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 0, 205));
		btnNewButton.setBounds(504, 348, 115, 33);
		contentPane.add(btnNewButton);
		
		ImageIcon img5=new ImageIcon("banking.jpg");
		
		JLabel lblNewLabel_3 = new JLabel(img5,JLabel.CENTER);
		lblNewLabel_3.setBounds(37, 124, 339, 314);
		contentPane.add(lblNewLabel_3);
		
		
		
		
	
		
		
	}
}
