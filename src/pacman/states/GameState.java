package pacman.states;

import pacman.Game;
import pacman.util.DrawTools;

import java.awt.*;

public class GameState implements State{

    public GameState(){}

    public void tick(Game g) {

    }
    public void render(Graphics g, Game game) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.width, game.height);
        DrawTools.drawMap(g, game.gameMap.map);
        DrawTools.drawEntity(g, game.gameMap.objList);
    }
}
