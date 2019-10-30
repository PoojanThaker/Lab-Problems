
package User;
/**
 * 
 * This class is used for creating displayable objects.Any object which is displayed
 * on the screen contains basic information such as coordinates and dimensions.Note that
 * the top left corner of the screen is considered as origin.The
 * x-coordinate increases as we go towards the right.The y-coordinate
 * increases as we go down the screen.
 * @author Poojan Thaker
 *
 */
public class DisplayObject
{
    /**
     * The x-coordinate of the object
     */
    private int xCoordinate;
    /**
     * The y-coordinate of the object
     */
    private int yCoordinate;
    /**
     * The width of the object
     */
    private int width;
    /**
     * The height of the object
     */
    private int height;
    /**
     * Constructor for Display Object initializes all it's fields
     * @param xCoordinate The x-coordinate of the object
     * @param yCoordinate The y-coordinate of the object
     * @param width The width of the object
     * @param height The height of the object
     */
    public DisplayObject(int xCoordinate, int yCoordinate, int width, int height)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }
    /**
     * Getter method for x-coordinate
     * @return xCoordinate
     */
    public int getxCoordinate()
    {
        return xCoordinate;
    }
   /**
    * Setter method for x-coordinate
    * @param xCoordinate
    */
    public void setxCoordinate(int xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }
    /**
     * Getter method for y-coordinate
     * @return yCoordinate
     */
    public int getyCoordinate()
    {
        return yCoordinate;
    }
    /**
     * Setter method for y-coordinate
     * @param yCoordinate
     */
    public void setyCoordinate(int yCoordinate)
    {
        this.yCoordinate = yCoordinate;
    }
    /**
     * Getter method for width
     * @return width
     */
    public int getWidth()
    {
        return width;
    }
    /**
     * Getter method for height
     * @return height
     */
    public int getHeight()
    {
        return height;
    }
}
