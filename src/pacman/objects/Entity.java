package pacman.objects;

import pacman.Game;
import pacman.util.Const;

import java.util.Map;

public class Entity
{
public Coord pos;
public String type;
public Const.Dir dir;
public Const.Dir wantDir;
public int[] lookPos;
public boolean stunned;
public Entity(int x, int y,String type,Const.Dir direction,int size) {
		stunned = false;
		this.type = type;
		pos = new Coord(x,y,size-1);
		dir = direction;
		wantDir = direction;
		lookPos = new int[]{10, 2};
		}
	public Const.Dir getWantDir(Game g){
		int stuckCounter=0;
		if(lookPos ==null){return Const.Dir.up;}
		Const.Dir tempDir = null;
		double max = -1.0;
		for(Const.Dir d:Const.Dir.values()){
			if(Const.opp(d).equals(dir))continue;
			if(!g.gameMap.check(this,d)){stuckCounter++;continue;}
			if(max==-1.0){
				tempDir=d;
				max=Const.distance(lookPos,Const.vectSum(pos.asArr(),Const.dirMap.get(d)));
			}
			else{
				double temp = Const.distance(lookPos,Const.vectSum(pos.asArr(),Const.dirMap.get(d)));
				if(temp<=max){
					tempDir=d;
					max=temp;
				}
			}
		}
		if(tempDir==null){
			if(stuckCounter==3)tempDir=Const.opp(dir);
			else tempDir=Const.Dir.up;
		}
		return tempDir;
	}
	public void step(Game g) {
		pos.sum(Const.dirMap.get(dir));
		}
	public void tick(Game g){
	if(type.equals("pac")){
		wantDir=g.dir;
		g.gameMap.waka(this.pos.asArr());
	}
	else{wantDir=getWantDir(g);}
	stunned = false;
		/**if(!canBacktrack){
			if(!wantDir.equals(Const.opp(dir))){
				checkMove(g);
			}
		}
		else**/checkMove(g);
	}
	public void checkMove(Game g){
		if(!wantDir.equals(dir)){
			if(g.gameMap.check(this,wantDir)){
				dir = wantDir;
			}
			if(g.gameMap.check(this,dir)){
				step(g);return;
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