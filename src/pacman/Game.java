package pacman;

import pacman.objects.Display;
import pacman.states.State;
import pacman.util.FpsLimiter;
import pacman.util.KeyWorker;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
	private Display display;
	public int width,height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	public GameMap gameMap;
	private FpsLimiter fps;
	public State currentState;
	public KeyListener keys;

	public Game(String title, int width, int height, GameMap gameMap){
		this.width = width;
		this.height = height;
		this.title = title;
		this.gameMap = gameMap;
		fps = new FpsLimiter(60);
		currentState = State.states.get("game");
		keys = new KeyWorker();
	}
	private void init(){
		display = new Display(title,width,height);
		display.frame.addKeyListener(keys);
	}
	private void tick(){currentState.tick(this);}
	private void render(){
		bs =  display.canvas.getBufferStrategy();
		if(bs == null) {display.canvas.createBufferStrategy(2);return;}
		g = bs.getDrawGraphics();
		currentState.render(g,this);
		bs.show();
		g.dispose();
	}
	public void run() {
		init();

		while(running) {
			if(fps.check()){
			tick();
			render();}
		}
		stop();
	}
	
	public synchronized void start() {
		if(running)return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!running)return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
