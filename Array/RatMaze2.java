package Array;

public class RatMaze2 {
	static int ways(int n,int m,int rx,int ry,int cx,int cy,int ox,int oy)
    {
    	if (rx==cx && ry==cy)
    		return 1;
    	if(rx<1 || rx>n || ry<1 || ry>m||cx<1||cx>n||cy<1||cy>m||(rx==ox && ry==oy))
    		return 0;
    	return ways(n,m,rx,ry-1,cx,cy,ox,oy) + ways(n,m,rx-1,ry,cx,cy,ox,oy);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           System.out.println(ways(3,3,3,3,1,1,2,2));
	}
}
