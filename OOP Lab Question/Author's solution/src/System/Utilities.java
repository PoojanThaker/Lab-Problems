package System;
import User.*;
import java.awt.Rectangle;
import java.util.Random;
/**
 * 
 * @author Poojan Thaker
 *
 */
public class Utilities
{

    public static boolean checkCollision(Car c1, Car c2)
    {
        Rectangle r1 = new Rectangle(c1.getxCoordinate(),c1.getyCoordinate(),c1.getWidth(),c1.getHeight());
        Rectangle r2 = new Rectangle(c2.getxCoordinate(),c2.getyCoordinate(),c2.getWidth(),c2.getHeight());
        return r1.intersects(r2);
    }

    public static Road.Line getRandomLine()
    {
        Random rand = new Random();
        int x = rand.nextInt(Values.ROAD_WIDTH);
        x+=Values.ROAD_LEFT_B;
        int width = 10;
        int length = rand.nextInt(40);
        int y = rand.nextInt(3);
        y = -1*y*Values.CAR_HEIGHT;
        int opacity = rand.nextInt(50);
        opacity+=150;
        Road.Line ll = new Road.Line(x,y,width,length,opacity);
        return ll;
    }
    private static boolean lane=false;
    public static Car getRandomCar()
    {
            Random rand = new Random();
            String names[] = new String[2];
            names[0] = "c2";
            names[1] = "c3";
            int x = Values.ROAD_LEFT_B;
            if (lane == false)
            {
                x += rand.nextInt(Values.SCREEN_WIDTH / 2 - Values.CAR_WIDTH-5);
//                x -= Values.CAR_WIDTH / 2;
                lane=true;
            }
            else
            {
                lane=false;
                x += Values.ROAD_WIDTH/2;
//                x -= Values.CAR_WIDTH / 2;
            }
            int width = Values.CAR_WIDTH;
            int height = Values.CAR_HEIGHT;
            int delta = rand.nextInt(20);
            height += delta;
            int y = -1 * height - delta*Values.CAR_WIDTH;
            int speed = rand.nextInt(Values.SPEED + 5)+1;
            int level = rand.nextInt(2);
//            System.out.println("Level is "+   level);
            Car car = new Car(x, y, width, height, names[level], speed, level);
            return car;

    }
}
