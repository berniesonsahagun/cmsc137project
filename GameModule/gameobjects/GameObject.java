package cmsc137project.game.gameobjects;

public class GameObject implements Entity{
	public void tick(){

	}
	public void render(){

	}
	public double getX(){
		return this.x;
	}
	public double getY(){
		return this.y
	}
	public Type getType(){
		return this.type
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setType(Type type){
		this.type = type;
	}
}