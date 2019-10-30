package User;
import  System.*;

/**
 * Used for creating the road on the screen 
 * @author Poojan Thaker
 *
 */

public class Road extends DisplayObject
{
	/**
	 * Used for creating the white lines on the screen which move downward so that the user's car on the screen appears to move upwards.
	 * @author Poojan Thaker
	 *
	 */
	  public static class Line extends DisplayObject
	    {
		  /**
		   * Opacity of the line
		   */
	        private int opacity;
	        /**
	         * Contructor for line object. Calls the super constructor. Initializes opacity.
	         * @param xCoordinate The x-coordinate of the object
	         * @param yCoordinate The y-coordinate of the object
	         * @param width The width of the object
	         * @param height The height of the object
             * @param opacity Opacity of the line
	         */
	        public Line(int xCoordinate,int yCoordinate,int width,int height,int opacity)
	        {
	            super(xCoordinate,yCoordinate,width,height);
	            this.opacity=opacity;
	        }
	        /**
	         * Getter method for opacity.
	         * @return opacity
	         */
	        public int getOpacity()
	        {
	            return opacity;
	        }
	    }
	  /**
	   * Array of lines
	   */
    private static Line lines[];
    /**
     * Note : To generate a random line, use Utilities.getRandomLine() in System package.<br>
     * ---------------------------------------------------------------------------------------<br>
     * Initializes each line in the lines array with a random line.<br>
     */
    public void initLines()
    {
        for(int i=0;i<lines.length;i++)
        {
            lines[i]= Utilities.getRandomLine();
        }
    }
    /**
     *  Constructor for Road. Calls the super constructor with the following parameters :<br>
     *  xCoordinate : Values.ROAD_LEFT_B<br>
     *  yCoordinate : 0<br>
     *  width       : Values.ROAD_WIDTH<br>
     *  height      : Values.SCREEN_HEIGHT<br>
     *  <br>
     *  Initializes the lines array to the size : Values.MAX_LINES<br>
     *  Calls initLines() <br>
     */
    public Road()
    {
        super(Values.ROAD_LEFT_B,0, Values.ROAD_WIDTH, Values.SCREEN_HEIGHT);
        lines = new Line[Values.MAX_LINES];
        initLines();
    }
  
    /**
     * Note : To generate a random line, use Utilities.getRandomLine() in System package.<br>
     * ---------------------------------------------------------------------------------------<br>
     * Iterate through the lines array : <br>
     * If y-coordinate of the line >  Values.SCREEN_HEIGHT<br>
     * 	Replace that line with a new random line.<br>
     * 
     */
    public void changeLines()
    {
        for(int i=0;i<lines.length;i++)
        {
            if(lines[i].getyCoordinate()> Values.SCREEN_HEIGHT)
            {
                lines[i]= Utilities.getRandomLine();
            }
        }
    }
    /**
     *   This method calculates the next frame of the road<br>
     *   Increment the y-coordinate of each line in the lines array by Values.SPEED<br>
     *   and then call changeLines()<br>
     *   
     */
    public void calculateNextFrame()
    {
        int change = Values.SPEED;
        for(int i = 0; i< Values.MAX_LINES; i++)
        {
            lines[i].setyCoordinate(lines[i].getyCoordinate()+change);
        }
        changeLines();
    }
    /**
     * Getter method for lines<br>
     * @return lines<br>
     */
    public static Line[] getLines()
    {
        return lines;
    }
}
