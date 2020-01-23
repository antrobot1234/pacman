package pacman.objects;

import pacman.Game;
import pacman.util.Const;

public class Entity
{
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
public void step(Game g) {
		pos.sum(Const.dirMap.get(dir));
		if(!g.gameMap.check(this,dir)){
			stunned = true;
		}
		}
	public void tick(Game g){
	if(type.equals("pac")){
		wantDir=g.dir;
	}
	stunned = false;
		if(!canBacktrack){
			if(!wantDir.equals(Const.opp(dir))){
				checkMove(g);
			}
		}
		else checkMove(g);
	}
	public void checkMove(Game g){
		if(!wantDir.equals(dir)){
			if(g.gameMap.check(this,wantDir)){
				dir = wantDir;step(g);return;
			}
		}
		else{
			if(!g.gameMap.check(this,dir)){
				stunned = true;return;
			}
			else{
				step(g);return;
			}
		}
	}
}