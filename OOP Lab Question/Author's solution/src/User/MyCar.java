package User;
import System.*;
/**
 * The MyCar class is used for creating the car controlled by the user. 
 * 
 * @author Poojan Thaker
 *
 */
public class MyCar extends Car
{
	/**
	 * Calculates the next frame for the car<br>
	 * This method moves the user's car up,down,left or right
	 * according to keys pressed while making sure that the car remains within the bounds.<br>
	 * -----------------------------------------------------------------------------------------------------------<br>
	 * Note  : To check if a particular key is pressed use KeyBoardInput.isPressed() method from the System package.
	 * This method takes the name of the key as a String parameter and returns true if it is currently pressed.For
	 * example if you want to check if UP key is pressed, use : <br>
	 * 
	 * KeyBoardInput.isPressed("UP")<br>
	 * This will return true if up key is pressed otherwise false.<br>
	 * ------------------------------------------------------------------------------------------------------------<br>

	 * Check if any of the following keys are currently pressed:<br>
	 * 1.UP<br>
	 * 2.DOWN<br>
	 * 3.RIGHT<br>
	 * 4.LEFT<br>
	 * <pre>
	 * if UP key is pressed : 
	 *    if y-coordinate of car - speed of car > 0 
	 *       decrement the y-coordinate of the car by it's speed.
	 * if DOWN key is pressed : 
	 *    if y-coordinate of car + speed of car + height of car < Values.SCREEN_HEIGHT
	 *       increment the y-coordinate of the car by it's speed.
	 * if RIGHT key is pressed : 
	 *    if x-coordinate of car + speed of car + width of car < Values.ROAD_RIGHT_B
	 *       increment the x-coordinate of the car by it's speed.
	 * if LEFT key is pressed : 
	 *    if x-coordinate of car - speed of car > Values.ROAD_LEFT_B
	 *       decrement the x-coordinate of the car by it's speed.
     *</pre>
     *   Note that if multiple keys are pressed, your code
     *   should take into account the effect of all the keys.
     *
	 */
    @Override
    public void calculateNextFrame()
    {
        if(KeyBoardInput.isPressed("UP"))
        {     	
            if(this.getyCoordinate()- this.getSpeed()>0)
            this.setyCoordinate(this.getyCoordinate()-this.getSpeed());              
        }
        if(KeyBoardInput.isPressed("DOWN")) 
        { 
        	if(this.getyCoordinate()+ this.getSpeed()+ this.getHeight()< Values.SCREEN_HEIGHT)
            this.setyCoordinate(this.getyCoordinate()+ this.getSpeed());
        }
        if(KeyBoardInput.isPressed("RIGHT"))
        {
            if(this.getxCoordinate()+ this.getSpeed()+ this.getWidth() < Values.ROAD_RIGHT_B)
            this.setxCoordinate(this.getxCoordinate()+ this.getSpeed());
        }
        if(KeyBoardInput.isPressed("LEFT"))
        {
            if(this.getxCoordinate()- this.getSpeed()> Values.ROAD_LEFT_B)
            this.setxCoordinate(this.getxCoordinate()- this.getSpeed());
        }
    }
    /**
     * Constructor for MyCar. Calls the super constructor.
     * @param xCoordinate The x-coordinate of the car
     * @param yCoordinate The y-coordinate of the car
     * @param width The width of the car
     * @param height The height of the car
     * @param name name of the car
     * @param speed speed of the car
     * @param level level of the car
     */
    public MyCar(int xCoordinate, int yCoordinate, int width, int height,String name,int speed,int level)
    {
        super(xCoordinate,yCoordinate,width,height,name,speed,level);
    }
}
