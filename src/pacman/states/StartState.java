package pacman.states;

import pacman.Game;

import java.awt.*;

public class StartState implements State {
    public boolean started;

    public StartState() {
        started = false;
    }

    public void tick(Game game) {
        if (started) {
            game.currentState = new GameState();
            started = false;
            return;
        }
        for (boolean b : game.keys.keys) {
            if (b) started = true;
        }
    }

    public void render(Graphics g, Game game) {
        g.clearRect(0, 0, game.width, game.height);
        g.drawString("press any key to start", 200, 300);
        g.drawString("controls:WASD movement", 200, 350);
    }
}
