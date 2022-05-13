package Array;

public class findequillibrium {
	
	static int findElement(int arr[])
    {
        int rsum=0,lsum=0;
        int i=0,j=0;
         
        for(i=0,j=arr.length-1;i<j;i++,j--){
            lsum += arr[i];
            rsum += arr[j];
            while(lsum<rsum && i<j){
                i++;
                lsum+=arr[i];
            }
            while(rsum<lsum && i<j){
                j--;
                rsum+=arr[j];
            }
        }
        if(lsum==rsum && i==j) {
            return arr[i];
        }
        else {
            return -1;
        }
    }
	public static void main(String[] args) {
		int arr[]={2,2,5,2,2,1};
	    System.out.println(findElement(arr));
	}

}
