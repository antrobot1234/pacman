package pacman.util;

import java.util.HashMap;

public class Const {
	public enum Dir {left, right, up, down}
	public static HashMap<Dir,int[]> dirMap = createMap();
	public static HashMap<Dir,int[]> createMap(){
		HashMap<Dir,int[]> map = new HashMap<>();
		map.put(Dir.left, new int[]{-1, 0});
		map.put(Dir.right, new int[]{1,0});
		map.put(Dir.up, new int[]{0,1});
		map.put(Dir.down, new int[]{0,-1});
		return map;
	}
}
