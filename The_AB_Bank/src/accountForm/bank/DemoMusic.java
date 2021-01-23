package accountForm.bank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DemoMusic {
public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException
	{	
	Scanner input=new Scanner(System.in);
		File audioFile=new File("scam.wav");
		AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
	    Clip clip=AudioSystem.getClip()	;
	    clip.open(audioStream);
		clip.start();
		
		String ab=input.next();
		System.out.println(ab); 
		input.close();
		
	}

}