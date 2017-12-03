import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import java.awt.image.BufferedImage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import java.awt.Font;

import java.util.Random;

public class Misc{//miscellaneous dumpsite for easy access
	public static void playSound(String filename, boolean repeat) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("../sounds/"+filename+".wav"));
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat());
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			if(repeat)
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			else
				clip.start();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	} //only accepts .wav file extensions

	public static BufferedImage loadImage(String filename){
		try {
			return ImageIO.read(new File("assets/img/"+filename+".png"));	
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}return null;
	}//reads things and returns them as full fledged images to lessen code bulk

}