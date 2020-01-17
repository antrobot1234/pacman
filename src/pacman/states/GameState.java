package pacman.states;

import pacman.Game;
import pacman.Main;
import pacman.util.DrawTools;

import java.awt.*;

public class GameState implements State{

    public GameState(){
        t=0;
        total = 32;
        s = 0;
    }
    int t;
    double total;
    int s;

    public void tick(Game g) {
        t++;
        if(t>=total)t=0;
    }
    public void render(Graphics g, Game game) {
        s = (int) (t*(Main.scaleFactor/total));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.width, game.height);
        DrawTools.drawMap(g, game.gameMap.map);
        DrawTools.drawEntity(g, game.gameMap.objList,s);
    }
}
