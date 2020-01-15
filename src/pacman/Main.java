package pacman;

public class Main {
	public static final int scaleFactor = 32;
	public static void main(String[] args) {
		GameMap gameMap = new GameMap("src/files/pacmanscribed.txt");
		Game game = new Game("pac-man", gameMap.sizeArr[0]*scaleFactor, gameMap.sizeArr[1]*scaleFactor,gameMap);
		game.start();
	}
}
