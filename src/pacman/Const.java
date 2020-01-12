package pacman;

import java.util.HashMap;

public class Const {
	public enum Dir {left, right, up, down}
	public static HashMap<Dir,Coord> dirMap = createMap();
	public static HashMap<Dir,Coord> createMap(){
		HashMap<Dir,Coord> map = new HashMap<>();
		map.put(Dir.left, new Coord(-1,0));
		map.put(Dir.right, new Coord(1,0));
		map.put(Dir.up, new Coord(0,1));
		map.put(Dir.down, new Coord(0,-1));
		return map;
	}
}
