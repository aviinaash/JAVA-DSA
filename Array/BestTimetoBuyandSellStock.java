package Array;

public class BestTimetoBuyandSellStock {
	
	static int maxProfit(int[] arr) {
        int maxPro = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    maxPro = Math.max(arr[j] - arr[i], maxPro);
                }
            }
        }
        return maxPro;
    }
	
    static int maxProfit1(int[] prices) {
    	int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
        	min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

	public static void main(String[] args) {
		int prices[]= {7,1,5,3,6,4};
		System.out.println(maxProfit1(prices));  //5
	}

}

//i-->   0  1  2  3  4  5
//
//prices 7  1  5  3  6  4
//
//min    7  1  1  1  1  1
//
//max    0  0  4  4  5  5







