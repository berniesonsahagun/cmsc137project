import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animator {

	private int speed;
	private int frames;
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	public Animator(int speed, BufferedImage... images){
		this.speed = speed;
		this.images = images;
		this.frames = images.length;
	}
	
	public void runAnimation(){
		index++;
		if(index > speed){
			index = 0;
			nextFrame();
		}	
	}
	
	public void nextFrame(){
		currentImg = images[count];
		
		count += 1;

		if(count > frames)
			count = 0;
	}
	
	public void drawAnimation(Graphics g, double x, double y, int offset){
		g.drawImage(currentImg, (int)x - offset, (int)y, null);
	}
	
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		return count;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
}