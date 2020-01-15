package pacman;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
	private Display display;
	public int width,height;
	public String title;
	private boolean running = false;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	private GameMap gameMap;
	private FpsLimiter fps;

	public Game(String title, int width, int height, GameMap gameMap){
		this.width = width;
		this.height = height;
		this.title = title;
		this.gameMap = gameMap;
		fps = new FpsLimiter(60);
	}
	private void init(){display = new Display(title,width,height);}
	private void tick(){}
	private void render(){
		bs =  display.canvas.getBufferStrategy();
		if(bs == null) {display.canvas.createBufferStrategy(2);return;}
		g = bs.getDrawGraphics();
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, width, height);
		DrawTools.drawMap(g, gameMap.map);
		DrawTools.drawEntity(g, gameMap.objList);
		
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
