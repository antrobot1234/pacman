package pacman.util;

import pacman.util.Const.Dir;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyWorker implements KeyListener {
    public boolean[] keys;
    public HashMap<String,Boolean> move;
    public Dir point;
    public KeyWorker(){
        keys = new boolean[256];
    }

    public void update(){
        if(keys[KeyEvent.VK_W])point = Dir.up;
        else if(keys[KeyEvent.VK_S])point = Dir.down;
        else if(keys[KeyEvent.VK_A])point = Dir.left;
        else if(keys[KeyEvent.VK_D])point = Dir.right;
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
