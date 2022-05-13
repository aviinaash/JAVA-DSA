//Maximum profit by buying and selling a share at most twice
package Array;

public class MaximumProfit {
	static int maxProfit1(int price[],int n) {
		int profit[]=new int[n];
		//initializing profit as 0
		for(int i=0;i<n;i++) {
			profit[i]=0;
		}
		//finding maximum profit using one transaction only
		int maxPrice=price[n-1];                  //pointer at last(n-1) index
		for(int i=n-2;i>=0;i--) {                 //finding min price in whole array
			if(price[i]>maxPrice) {
				maxPrice=price[i];
			}
			profit[i]=Math.max(profit[i+1],maxPrice-price[i]);  //75,75,75,15,15,0
		}
		//finding maximum profit using two transaction
		int minPrice=price[0];                    //pointer at 0th index
		for(int i=1;i<n;i++) {                    //finding min price in whole array
			if(price[i]<minPrice) {
				minPrice=price[i];
			}
			profit[i]=Math.max(profit[i-1],profit[i]+(price[i]-minPrice));
		}
		return profit[n-1];
	}

	static int maxProfit2(int price[],int n) {
		int buy1=Integer.MIN_VALUE;int sell1=0;
		int buy2=Integer.MIN_VALUE;int sell2=0;
		for(int i=0;i<n;i++) {
			buy1=Math.max(buy1, -price[i]);
			sell1=Math.max(sell1,buy1+price[i]);

			buy2=Math.max(buy2, sell1-price[i]);
			sell2=Math.max(sell2,buy2+price[i]);
		}
		return sell2;
	}

	static int maxProfit3(int price[],int n) {   //if infinite transactions allowed
		int profit=0;
		for(int i=1;i<n;i++) {
			int sub = price[i] - price[i - 1];
			if(sub>0) {
				profit+=sub;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int price[] = {10, 22, 5, 75, 65, 80};
		int n=price.length;
		System.out.println(maxProfit1(price,n));   //87
		System.out.println(maxProfit2(price,n)); 
	}

}

//Trader earns 87 as sum of 12, 75 
//Buy at 10, sell at 22, 
//Buy at 5 and sell at 80