import java.util.LinkedList;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CollisionChecker{
	
	public static boolean isColliding(Entity entity, LinkedList<Entity> entityList){
		for(int i=0; i<entityList.size(); i++){
			Entity tempEntity = entityList.get(i);
			Entity.EntityType type = tempEntity.getType();
			if(type != Entity.EntityType.BULLET && type != Entity.EntityType.ALLY && type != Entity.EntityType.WEAPON && entity.getBounds().intersects(tempEntity.getBounds())){
				return true;
			}
		}
		return false;
	}
	private void collide(){
		
	}
}
