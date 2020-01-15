package pacman;

public class Coord {
	public int x;
	public WrapInt y;
	public Coord(int xI, int yI, int size){
		x = xI;
		y = new WrapInt(yI,0,size);
	}
	public Coord(int xI, int yI) {
		x = xI;
		y = new WrapInt(yI,0,10);
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
