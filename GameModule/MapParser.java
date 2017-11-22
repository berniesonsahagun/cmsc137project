import java.awt.image.BufferedImage;

public class MapParser{
	private BufferedImage image;
	private Game game;
	private Controller controller;
	private Player player;

	public MapParser(Game game, BufferedImage image, Controller controller){
		this.game = game;
		this.image = image;
		this.controller = controller;
	}

	public void parse(){
		int width = image.getWidth();
		int height = image.getHeight();

		for(int x=0; x<width; x++){
			for(int y=0; y<height; y++){
				int pixel = image.getRGB(x,y);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red >= 200) controller.addEntity(new Wall(x*32, y*32, controller));
				else if(blue >= 200) {
					this.player = new Player(x*32, y*32, controller);
					controller.addEntity(player);

				}
				else if(green >= 200) controller.addEntity(new Block(x*32, y*32, controller));
			}
		}
	}
	public Player getPlayer(){
		return this.player;
	}
}