package cmsc137project.game.gameobjects;

public interface Entity{
	private double x;
	private double y;
	private EntityType type;
	private Texture tex;

	public void tick();
	public void render();
	public double getX();
	public double getY();
	public Type getType();
	public void setX(double x);
	public void setY(double y);
	public void setType(Type type);
}