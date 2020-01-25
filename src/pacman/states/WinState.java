package pacman.states;

import pacman.Game;

import java.awt.*;

public class WinState implements State {
    public void tick(Game game) {

    }

    public void render(Graphics g, Game game) {
        g.clearRect(0,0,game.width,game.height);
        g.drawString("you win!",200,300);
    }
}
