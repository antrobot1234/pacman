package pacman.objects;

public class WrapInt {
	private int i;
	public int max;
	public int min;
	public WrapInt(int i, int min, int max) {
		this.i = i;
		this.min = min;
		this.max = max;
	}
	public int getVal() {
		return i;
	}
	public void setVal(int n) {
		if(min < n && n < max) {i = n;}
	}
	public void correct() {
		while(i>max) {
			i-=max+-min+1;
		}
		while(i<min) {
			i+=max-min;
		}
	}
	public void sum(int n) {
		i+=n;
		correct();
	}
}
