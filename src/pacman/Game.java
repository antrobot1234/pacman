package pacman;

import pacman.objects.Display;
import pacman.states.State;
import pacman.util.Const;
import pacman.util.FpsLimiter;
import pacman.util.KeyWorker;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    public int width, height;
    public String title;
    public GameMap gameMap;
    public State currentState;
    public KeyWorker keys;
    public Const.Dir dir;
    private Display display;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private FpsLimiter fps;

    public Game(String title, int width, int height, GameMap gameMap) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.gameMap = gameMap;
        fps = new FpsLimiter(60);
        currentState = State.states.get("start");
        keys = new KeyWorker();
        dir = Const.Dir.up;

    }

    private void init() {
        display = new Display(title, width, height);
        display.frame.addKeyListener(keys);
    }

    private void tick() {
        Const.Dir temp = keys.check();
        if (temp != null) {
            dir = temp;
        }
        currentState.tick(this);
    }

    private void render() {
        bs = display.canvas.getBufferStrategy();
        if (bs == null) {
            display.canvas.createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        currentState.render(g, this);
        bs.show();
        g.dispose();
    }

    public void run() {
        init();

        while (running) {
            if (fps.check()) {
                tick();
                render();
            }
        }
        stop();
    }

    public synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
