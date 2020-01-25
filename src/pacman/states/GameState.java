package pacman.states;

import pacman.Game;
import pacman.GameMap;
import pacman.Main;
import pacman.objects.Entity;
import pacman.util.DrawTools;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;

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
        if(g.gameMap.pellets==0){g.currentState=State.states.get("win");return;}
        t++;
        if(g.gameMap.powerTime>0){
            g.gameMap.powerTime--;
        }
        if(t>=total){
            for(Map.Entry<String, Entity> e:g.gameMap.objList.entrySet()){
                e.getValue().tick(g);

                if(!e.getKey().equals("pac")){
                    if(Arrays.equals(e.getValue().pos.asArr(),g.gameMap.objList.get("pac").pos.asArr())){g.currentState=states.get("lose");return;}
                }
            }
            t=0;
        }
    }
    public void render(Graphics g, Game game) {
        s = (int) (t*(Main.scaleFactor/total));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.width, game.height);
        DrawTools.drawMap(g, game.gameMap.map);
        DrawTools.drawEntity(g,game.gameMap.objList,s,game.gameMap.powerTime>0);
        g.setColor(Color.WHITE);
        g.drawString(""+game.gameMap.pellets,20,20);
    }
}
