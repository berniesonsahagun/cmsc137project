import java.util.LinkedList;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CollisionChecker{

	public static boolean isColliding(Entity entity, Controller controller){
		LinkedList<Entity> entityList = controller.getEntityList();

		for(int i=0; i<entityList.size(); i++){
			Entity tempEntity = entityList.get(i);
			Entity.EntityType type = tempEntity.getType();
			if(type != Entity.EntityType.BULLET && type != Entity.EntityType.ALLY && type != Entity.EntityType.WEAPON && entity.getBounds().intersects(tempEntity.getBounds())){
				if(entity.getType() == Entity.EntityType.BULLET){
					switch(type){
						case BLOCK:
							controller.removeEntity(tempEntity);
							controller.removeEntity(entity);
							break;
						case WALL:
							controller.removeEntity(entity);
							break;
						case FOE:
							tempEntity.setHP(tempEntity.getHP()-1);
							break;
					}
				}		
				return true;
			}
		}
		return false;
	}
	private void collide(){
		
	}
}
