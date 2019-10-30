package System;
import javax.imageio.ImageIO;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import User.*;
/**
 * 
 * @author Poojan Thaker
 *
 */
public class GameBoard extends Canvas
{
    public static final int FPS = 100;
    HashMap<String,BufferedImage> m1;
    KeyBoardInput kbi = new KeyBoardInput();
    private Screen screen;
    MyCar myCar = new MyCar(Values.CAR_START_X,Values.CAR_START_Y,Values.CAR_WIDTH,Values.CAR_HEIGHT,"c1",Values.CAR_SPEED,0);
    BufferedImage carimage;
    public GameBoard()
    {
        this.screen = new Screen(myCar);
        this.addKeyListener(kbi);
        m1 = new HashMap<>();
    }
    public void run()
    {
        double current = System.nanoTime();
        double prev = System.nanoTime();
        double diff=0;
        double required = (1000000000)/FPS;
        while(true)
        {
            prev=current;
            current=System.nanoTime();
            diff+=current-prev;
            if(diff>=required)
            {
                diff=0;
                screen.calculateNextFrame();
                render(screen);
            }
        }
    }

    public void render(Screen screen)
    {
        Road road = screen.getRoad();
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        // grass
        g2d.setColor(Color.green);
        g2d.fillRect(0,0,1000,1000);
        //grey road
        g2d.setColor(Color.gray);
        g2d.fillRect(road.getxCoordinate(),road.getyCoordinate(),road.getWidth(),road.getHeight());

        Road.Line ll[] = road.getLines();

        for(Road.Line l:ll)
        {
            Color c = new Color(255,255,255,l.getOpacity());
            g2d.setColor(c);
            g2d.fillRect(l.getxCoordinate(),l.getyCoordinate(),l.getWidth(),l.getHeight());
        }
        //car rendering
        if(carimage==null)
        {
            try
            {
                carimage = ImageIO.read(new File("./resources/"+screen.getMyCar().getName()+".png"));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        g2d.drawImage(carimage,myCar.getxCoordinate(),myCar.getyCoordinate(),myCar.getWidth(),myCar.getHeight(),null);
        Car car[] = screen.getOtherCars();
        for(Car c:car)
        {
            if(m1.get(c.getName())==null)
            {
                try
                {
                    BufferedImage i = ImageIO.read(new File("./resources/"+c.getName()+".png"));
                    m1.put(c.getName(),i);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
            if(c.isVisible()==true)
            g2d.drawImage(m1.get(c.getName()),c.getxCoordinate(),c.getyCoordinate(),c.getWidth(),c.getHeight(),null);
        }
        g2d.setColor(new Color(0,0,0));
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g2d.drawString("Lives :" + screen.getLives(),20,20);
        g2d.drawString("Score :" + screen.getScore(),20,50);
        if(screen.getLives()==0)
        {
            g2d.setColor(Color.red);
            g2d.drawString("GAME OVER",150,200);
        }
        g2d.dispose();
        bs.show();
    }
}
