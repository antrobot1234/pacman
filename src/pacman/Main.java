package pacman;

public class Main {
	public static final int scaleFactor = 32;
	public static void main(String[] args) {
		Game game = new Game("pac-man",Map.sizeArr[0]*scaleFactor,Map.sizeArr[1]*scaleFactor);
		game.start();
	}
}
