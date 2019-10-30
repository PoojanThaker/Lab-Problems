package User;
/**
 * The car class is used for creating different cars on the screen. It is a displayable object.
 * 
 * @author Poojan Thaker
 *
 */
public class Car extends DisplayObject
{
	/**
	 * Name of the car
	 */
    private String name;
    /**
     * Level of the car
     */
    private int level;
    /**
     * Speed of the car
     */
    private int speed;
    /**
     *  True if the car is visible otherwise false.
     */
    private boolean isVisible;
    /**
     * Constructor of Car class. Calls the super constructor and passes the parameters xCoordinate,yCoordinate,width,height.
     * Initializes name,speed and level. Initializes isVisible to true.
     * @param xCoordinate The x-coordinate of the car
     * @param yCoordinate The y-coordinate of the car
     * @param width The width of the car
     * @param height The height of the car
     * @param name name of the car
     * @param speed speed of the car
     * @param level level of the car
     */
    public Car(int xCoordinate, int yCoordinate, int width, int height,String name,int speed,int level)
    {
        super(xCoordinate,yCoordinate,width,height);
        this.name=name;
        this.speed=speed;
        this.level=level;
        this.isVisible=true;
    }
    /**
     * Getter method for name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    /**
     * Getter method for level
     * @return level
     */
    public int getLevel()
    {
        return level;
    }
    /**
     * Getter method for speed
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }
    /**
     * Getter method for isVisible
     * @return True if the car is visible otherwise false
     */
    public boolean isVisible()
    {
        return isVisible;
    }
    /**
     * Setter method for isVisible. 
     * @param value
     */
    public void setVisible(boolean value)
    {
        isVisible = value;
    }
    /**
     * Increases the y-coordinate of the car by it's speed.
     */
    public void calculateNextFrame()
    {
        this.setyCoordinate(this.getyCoordinate()+this.speed);
    }
}
