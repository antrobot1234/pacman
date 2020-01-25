package pacman.states;

import pacman.Game;

import java.awt.*;
import java.util.HashMap;


public interface State {
    HashMap<String,State> states = init();
    static HashMap<String,State> init(){
        HashMap<String,State> st = new HashMap<>();
        st.put("game",new GameState());
        st.put("start",new StartState());
        st.put("win",new WinState());
        st.put("lose",new LoseState());

        return st;
    }
    void tick(Game game);
    void render(Graphics g, Game game);
}
