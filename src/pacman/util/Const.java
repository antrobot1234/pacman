package pacman.util;

import java.util.HashMap;

public class Const {
	public enum Dir {left, right, up, down}
	public static HashMap<Dir,int[]> dirMap = createMap();
	public static HashMap<Dir,int[]> createMap(){
		HashMap<Dir,int[]> map = new HashMap<>();
		map.put(Dir.left, new int[]{-1, 0});
		map.put(Dir.right, new int[]{1,0});
		map.put(Dir.up, new int[]{0,-1});
		map.put(Dir.down, new int[]{0,1});
		return map;
	}
	public static int[] vectSum(int[] a,int[] b){
		int[] c = new int[a.length];
		for(int i=0;i<a.length;i++){
			c[i] = a[i]+b[i];
		}
		return c;
	}
	public static Dir opp(Dir dir){
		switch(dir){
			case up:return Dir.down;
			case down:return Dir.up;
			case left:return Dir.right;
			case right:return Dir.left;
		}
		return null;
	}

}
