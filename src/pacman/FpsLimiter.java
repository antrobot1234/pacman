package pacman;

public class FpsLimiter {
    private double tPU;
    private double d;
    private long n;
    private long lT;
    public FpsLimiter(int f){
        tPU = 1e9/f;
        d = 0;
        lT = System.nanoTime();
    }
    public boolean check(){
        n = System.nanoTime();
        d = (n-lT)/tPU;
        if(d>=1){
            lT=n;
            return true;
        }
        return false;
    }
}
