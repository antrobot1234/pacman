package pacman;

import java.util.ArrayList;

public class Entity {
	public Coord pos;
	public ArrayList<String> tags;
	public Const.Dir dir;
	public Entity(int x, int y, String[] arr,Const.Dir direction) {
		tags = new ArrayList<>();
		for(String str: arr) {tags.add(str);}
		pos = new Coord(x,y);
		dir = direction;
	}
	public void step() {
		pos.sum(Const.dirMap.get(dir));
	}
}
