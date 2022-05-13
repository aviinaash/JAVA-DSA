package Array;

public class RatMaze {
	static int ways(int n,int m,int rx,int ry,int cx,int cy)
    {
    	if (rx==cx && ry==cy)
    		return 1;
    	if(rx<1 || rx>n || ry<1 || ry>m)
    		return 0;
    	return ways (n,m,rx,ry-1,cx,cy)+ways(n,m,rx-1,ry,cx,cy);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(ways(3,3,3,3,1,1));
	}
}


//n-->rows
//m-->col
//r-->rat add
//c-->cheese add
//x(x-axis) and y(y-axis)