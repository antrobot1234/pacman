package pacman.objects;

import pacman.Game;
import pacman.util.Const;

public class Entity {
	public Coord pos;
	public String type;
	public Const.Dir dir;
	public Const.Dir wantDir;
	public boolean canBacktrack;
	public int[] lookPos;
	public boolean stunned;
	public Entity(int x, int y,String type,Const.Dir direction,int size) {
		stunned = false;
		this.type = type;
		pos = new Coord(x,y,size);
		dir = direction;
		wantDir = direction;
		lookPos = null;
		canBacktrack = false;
		if(type.equals("pac"))canBacktrack = true;
		else lookPos = new int[]{x,y};
	}
	public void step() {
		pos.sum(Const.dirMap.get(dir));
	}
	public void tick(Game g){
		//todo movement check
	}
}
