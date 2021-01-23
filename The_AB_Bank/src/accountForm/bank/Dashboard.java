package accountForm.bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The AB Bank");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 27));
		lblNewLabel.setBounds(148, 23, 435, 39);
		contentPane.add(lblNewLabel);
		
		ImageIcon img=new ImageIcon("mobile.png");
		ImageIcon img1=new ImageIcon("lightbill.jpg");	
		ImageIcon img2=new ImageIcon("dth.jpg");
		ImageIcon img3=new ImageIcon("fd.png");

		
		
		JLabel lblNewLabel_1 = new JLabel(img,JLabel.CENTER);
		lblNewLabel_1.setBounds(52, 140, 81, 80);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(img1,JLabel.CENTER);
		lblNewLabel_1_1.setBounds(189, 140, 81, 80);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel(img2,JLabel.CENTER);
		lblNewLabel_1_2.setBounds(52, 269, 81, 80);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel(img3,JLabel.CENTER);
		lblNewLabel_1_3.setBounds(189, 269, 81, 80);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setBounds(325, 140, 81, 80);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(325, 269, 81, 80);
		contentPane.add(lblNewLabel_2);
	}
}
