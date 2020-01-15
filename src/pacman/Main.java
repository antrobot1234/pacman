package pacman;

public class Main {
	public static final int scaleFactor = 32;
	public static void main(String[] args) {
		Game game = new Game("pac-man", GameMap.sizeArr[0]*scaleFactor, GameMap.sizeArr[1]*scaleFactor);
		game.start();
	}
}
