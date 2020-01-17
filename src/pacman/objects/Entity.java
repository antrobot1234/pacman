package pacman.objects;

import pacman.util.Const;

public class Entity {
	public Coord pos;
	public String type;
	public Const.Dir dir;
	public int[] lookPos;
	public Entity(int x, int y,String type,Const.Dir direction,int size) {
		this.type = type;
		pos = new Coord(x,y,size);
		dir = direction;
		lookPos = null;
		if(type.equals("pac")) lookPos = new int[]{x,y};
	}
	public void step() {
		pos.sum(Const.dirMap.get(dir));
	}
}
