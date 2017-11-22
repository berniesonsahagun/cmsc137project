import java.util.LinkedList;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CollisionChecker{
	public static Entity collidedEntity;

	public static boolean isColliding(Entity entity, Controller controller){
		LinkedList<Entity> entityList = controller.getEntityList();

		for(int i=0; i<entityList.size(); i++){
			Entity tempEntity = entityList.get(i);
			Entity.EntityType type = tempEntity.getType();
			
			if(type == Entity.EntityType.ALLY || type == Entity.EntityType.WEAPON || type == Entity.EntityType.BULLET)	continue;

			if(entity.getBounds().intersects(tempEntity.getBounds())){
				collidedEntity = tempEntity;
				return true;
			}
		}
		return false;
	}
	private void collide(){
		
	}
}
