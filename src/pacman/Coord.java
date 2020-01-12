package pacman;

public class Coord {
	public int x;
	public WrapInt y;
	public Coord(int xI, int yI){
		x = xI;
		y = new WrapInt(yI,0,Map.sizeArr[0]);
	}
	public void sum(int xI, int yI) {
		x += xI;
		y.sum(yI);
	}
	public void sum(Coord c) {
		x += c.x;
		y.sum(c.y.getVal());
	}
}
