package User;

import System.*;
/**
 * 
 * @author Poojan Thaker
 *
 */
public class Screen
{
	/**
	 * Number of lives remaining
	 */
    private static int lives;
    /**
     * Current score of the user
     */
    private static int score;
    /**
     * True if the game is over otherwise false
     */
    public boolean gameOver;
    /**
     * User's car
     */
    private MyCar myCar;
    /**
     * Other cars on the road
     */
    private static Car otherCars[];
    /**
     *  The grey rectangular block which is displayed at the center of the screen.
     */
    private Road road;
/**
 * Constructor for Screen.Initializes myCar,road. <br>
 * Initializes otherCars array to size Values.MAX_CARS .<br>
 * Initializes lives to 3.<br>
 * Initializes score to 0.<br>
 * Initializes gameOver to false.<br>
 * Calls initCars<br>
 * @param myCar
 */
    public Screen(MyCar myCar)
    {
        this.myCar = myCar;
        this.road = new Road();
        otherCars = new Car[Values.MAX_CARS];
        lives=3;
        score=0;
        this.gameOver=false;
        initCars();
    }

    /**
     * Note : To generate a random car, use Utilities.getRandomCar() in System package.<br>
     * ---------------------------------------------------------------------------------------<br>
     *  Initializes each car in the otherCars array with a random car.<br>
     */
    public void initCars()
    {
        for(int i = 0; i< otherCars.length; i++)
        {
            otherCars[i]= Utilities.getRandomCar();
        }
    }

    /**
     * Getter method for myCar
     * @return myCar
     */
    public MyCar getMyCar()
    {
        return myCar;
    }
    /**
     * Getter method for road
     * @return road
     */
    public Road getRoad()
    {
        return road;
    }
    /**
     * Getter method for otherCars
     * @return otherCars
     */
    public Car[] getOtherCars()
    {
        return otherCars;
    }
    /**
     * Getter method for lives
     * @return lives
     */
    public static int getLives()
    {
        return lives;
    }
    /**
     * Getter method for score
     * @return score
     */
    public static int getScore()
    {
        return score;
    }
    /**
     * Note : To generate a random car, use Utilities.getRandomCar() in System package<br>
     * ---------------------------------------------------------------------------------------<br>
     * Iterate through the otherCars array : <br>
     * If y-coordinate of the car >  Values.SCREEN_HEIGHT<br>
     * 	Replace that car with a new random car.<br>
     * 
     */
    public void changeCars()
    {
        for(int i=0;i<otherCars.length;i++)
        {
            if(otherCars[i].getyCoordinate()> Values.SCREEN_HEIGHT)
            {
                otherCars[i] = Utilities.getRandomCar();
            }
        }
    }
    /**
     *  Execute the method if and only if game is not over.<br>
     *  if lives have become 0, set gameover to true and return.<br>
     *  
     *  Calculate the next frame for myCar. <br>
     *  Calculate the next frame for road.<br>
     *  Calculate the next frame for each car in the otherCars array.<br>
     *  Call the changeCars() method.<br>
     *  ------------------------------------------------------------------------------------------------------------<br>
     *  Note : To find out if two cars are colliding use the Utilities.checkCollision() method from System class.<br>
     *  It takes in 2 cars as parameters and returns true if they are colliding otherwise false.<br>
     *  ------------------------------------------------------------------------------------------------------------<br>
     *
     *  Iterate through each car 'c' in the otherCars array and check if <br>
     *  the following conditions are satisfied simultaneously : <br>
     *   1. c collides with myCar<br>
     *   2. c is visible <br>
     *   <pre>
     *   if both these conditions are satisfied :
     *        if level of c <= myCar:
     *        		increment score by 10
     *        if level of c > myCar :
     *        		 decrement lives by 1
     *        make c invisible
     *   else :
     *        do nothing
     *        </pre>     */
    public void calculateNextFrame()
    {
        if(gameOver==false)
        {
            if(lives==0)
            {
                gameOver=true;
                return;
            }
            myCar.calculateNextFrame();
            road.calculateNextFrame();
            for(Car c: otherCars)c.calculateNextFrame();
            changeCars();
            for(Car c: otherCars)
            {
                if(Utilities.checkCollision(myCar,c)==true&&c.isVisible())
                {
                    if (myCar.getLevel() >= c.getLevel())
                    {
                        score += 10;
                    }
                    else
                    {
                        lives--;
                    }
                    c.setVisible(false);
                }
            }
        }
    }

}
