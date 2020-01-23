package pacman.util;

import pacman.util.Const.Dir;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyWorker implements KeyListener {
    public boolean[] keys;
    public HashMap<String,Boolean> move;
    public KeyWorker(){
        keys = new boolean[256];
    }

    public Dir check(){
        if(keys[KeyEvent.VK_W])return Dir.up;
        else if(keys[KeyEvent.VK_S])return Dir.down;
        else if(keys[KeyEvent.VK_A])return Dir.left;
        else if(keys[KeyEvent.VK_D])return Dir.right;
        return null;
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }
}
