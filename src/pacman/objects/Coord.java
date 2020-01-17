package pacman.objects;

public class Coord {
	public WrapInt x;
	public int y;
	public Coord(int xI, int yI, int size){
		x = new WrapInt(xI,0,size);
		y = yI;
	}

	public void sum(int xI, int yI) {
		x.sum(xI);
		y+= yI;
	}
	public void sum(int[] arr){
		x.sum(arr[0]);
		y+=arr[1];
	}
	public void sum(Coord c) {
		x.sum(c.x.getVal());
		y+=c.y;
	}
}
