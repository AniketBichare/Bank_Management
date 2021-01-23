package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import java.awt.Choice;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Details extends JFrame {

	private JPanel contentPane;
	private JTextField aadhar;
	private JTextField textField_1;
	private JTextField textField_2;
	private JRadioButton male;
	private JRadioButton female;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AAdhar No:");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel.setBounds(65, 62, 110, 25);
		contentPane.add(lblNewLabel);
		
		aadhar = new JTextField();
		aadhar.setBounds(200, 67, 293, 20);
		contentPane.add(aadhar);
		aadhar.setColumns(10);
		aadhar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String aadharNo=aadhar.getText();
				int length=aadharNo.length();
				char c=e.getKeyChar();
				
				//checking for numbers validation
				
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
						{
						if(length<12)	
							//editable true when length is less than 10
							aadhar.setEditable(true);
						else
							//editable false if length is more than 10
							aadhar.setEditable(false);
						}
				else
					//allow backspace  and delete keys
				if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE)		
				{
					aadhar.setEditable(true);
				}
				else
				{
					aadhar.setEditable(false);
				}
				
				
			}
		});
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Fathers Name");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(65, 105, 110, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 110, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Mothers Name");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(65, 152, 110, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 152, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Annual Income");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(65, 224, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LESS THAN 1 LAKH", "1-2 LAKH", "2-4 LAKH", "MORE THAN 5 LAKH"}));
		comboBox.setBounds(200, 223, 152, 22);
		contentPane.add(comboBox);
		
		male = new JRadioButton("Male");
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(male.isSelected())
				{
					female.setSelected(false); 
				}
			}
		});
		male.setBounds(200, 181, 72, 23);
		contentPane.add(male);
		
		female = new JRadioButton("Female");
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(female.isSelected())
				{
					male.setSelected(false);
				}
			}
		});
		female.setBackground(Color.PINK);
		female.setBounds(297, 181, 78, 23);
		contentPane.add(female);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(65, 177, 106, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Marital Status");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(65, 261, 110, 25);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married"}));
		comboBox_1.setBounds(200, 265, 110, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Date of Birth");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(65, 305, 106, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File audioFile=new File("scam.wav");
				AudioInputStream audioStream;
				try {
					audioStream = AudioSystem.getAudioInputStream(audioFile);
					 Clip clip=AudioSystem.getClip()	;
					    clip.open(audioStream);
						clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			   
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
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 21));
		btnNewButton.setBounds(200, 378, 236, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Account Opening Form-1");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(139, 21, 354, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(83, 315, -32, -29);
		contentPane.add(lblNewLabel_8);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(241, 311, 57, 23);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(367, 311, 57, 23);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(2000, null, 2002, 1));
		spinner_2.setBounds(512, 311, 57, 23);
		contentPane.add(spinner_2);
		
		JLabel lblNewLabel_9 = new JLabel("Date");
		lblNewLabel_9.setBounds(200, 315, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Month");
		lblNewLabel_10.setBounds(329, 315, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Year");
		lblNewLabel_11.setBounds(464, 315, 46, 14);
		contentPane.add(lblNewLabel_11);
		setUndecorated(true);
	}
}
