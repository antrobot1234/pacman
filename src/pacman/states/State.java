package pacman.states;

import java.awt.*;

public interface State {
    public void tick();
    public void render(Graphics g);
}
