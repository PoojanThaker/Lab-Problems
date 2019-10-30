package System;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * 
 * @author Poojan Thaker
 *
 */
public class KeyBoardInput extends KeyAdapter
{
    private static final boolean[] keys = new boolean[256];

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        keys[e.getKeyCode()]=true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        super.keyReleased(e);
        keys[e.getKeyCode()]=false;
    }

    public static boolean isPressed(String key)
    {
        key = key.toUpperCase();
        int code=0;
        if(key=="UP")code = KeyEvent.VK_UP;
        else if(key=="DOWN")code = KeyEvent.VK_DOWN;
        else if(key=="RIGHT")code = KeyEvent.VK_RIGHT;
        else if(key=="LEFT")code = KeyEvent.VK_LEFT;
        return keys[code];
    }
    
    public static void settrue(String key)
    {
    	  key = key.toUpperCase();
          int code=0;
          if(key=="UP")code = KeyEvent.VK_UP;
          else if(key=="DOWN")code = KeyEvent.VK_DOWN;
          else if(key=="RIGHT")code = KeyEvent.VK_RIGHT;
          else if(key=="LEFT")code = KeyEvent.VK_LEFT;
          keys[code]=true;
    }
    public static void setfalse(String key)
    {
    	  key = key.toUpperCase();
          int code=0;
          if(key=="UP")code = KeyEvent.VK_UP;
          else if(key=="DOWN")code = KeyEvent.VK_DOWN;
          else if(key=="RIGHT")code = KeyEvent.VK_RIGHT;
          else if(key=="LEFT")code = KeyEvent.VK_LEFT;
          keys[code]=false;
    }
}
