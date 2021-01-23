package accountForm.bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;


public class Audio {

	public static void main(String[] args) {

		JFrame frame=new JFrame();
		frame.setSize(200,200);
		JButton button=new JButton("CLick here");
		frame.add(button);
		button.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			try {
				music();
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	

	public  void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
		File audioFile=new File("achint.wav");
		AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
	    Clip clip=AudioSystem.getClip()	;
	    clip.open(audioStream);
		clip.start();
	}
});}

}
