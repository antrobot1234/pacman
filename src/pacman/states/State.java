package pacman.states;

import pacman.Game;

import java.awt.*;
import java.util.HashMap;


public interface State {
    HashMap<String,State> states = init();
    static HashMap<String,State> init(){
        HashMap<String,State> st = new HashMap<>();
        st.put("game",new GameState());

        return st;
    }
    void tick(Game game);
    void render(Graphics g, Game game);
}
