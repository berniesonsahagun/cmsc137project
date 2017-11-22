import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller{
	private LinkedList<Entity> entityList = new LinkedList<Entity>();
	private Game game;
	private static final Random rand = new Random();

	public Controller(Game game){
		this.game = game;
	}

	public void tick(){
		for(int i=0; i<entityList.size(); i++){
			Entity entity = entityList.get(i);

			if(entity.getType() == Entity.EntityType.WEAPON)	continue;
			entity.tick();
		}
	}

	public void render(Graphics g){
		for(int i=0; i<entityList.size(); i++){
			entityList.get(i).render(g);
		}
	}

	public void addEntity(Entity entity){
		entityList.add(entity);

	}

	public void removeEntity(Entity entity){
		if(entity.getType() == Entity.EntityType.BLOCK){
			int chance = rand.nextInt(100) + 1;
			if(chance >= 38 && chance <= 62){
				this.addEntity(new PowerBlock(entity.getX(),entity.getY(),this));
			}
		} 
		entityList.remove(entity);
	}

	public Game getGame(){
		return this.game;
	}

	public LinkedList<Entity> getEntityList(){
		return this.entityList;
	}
}