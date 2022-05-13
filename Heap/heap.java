package Heap;
import java.util.ArrayList;

public class heap {
	public static class pq{
		
		ArrayList<Integer> arr;
		public pq() {
			arr=new ArrayList<>();
		}
		
		public void insert(int val) {    //log n
			arr.add(val);
			upheapify(arr.size()-1);
		}
		
		public void upheapify(int i) {   //(min heap) i=child index
			if(i==0)
				return ;
			int pi=(i-1/2);               //pi=parent index
			if(arr.get(i)<arr.get(pi)) {
				swap(1,pi);
				upheapify(pi);
			}
		}
		
		public void swap(int i,int j) {
			int ivalue=arr.get(i);
			int jvalue=arr.get(j);
			arr.set(i, jvalue);
			arr.set(j, ivalue);
		}
		
		public void delete() {                  //log n
			if(this.getSize()==0) {
				System.out.println("Data struct. is empty");
				return ;
			}
			swap(0,arr.size()-1);   //swapping b/w 0th and last index
			downheapify(0);
		}
		
		public void downheapify(int i) {
			if(i>=arr.size())
				return;
			int min=i;
			int li=2*i+1;              //left index
			int ri=2*i+2;              //right index
			
			if(li<arr.size() && arr.get(li)<arr.get(min)) {
				min=li;
			}
			if(ri<arr.size() && arr.get(ri)<arr.get(min)) {
				min=ri;
			}
			if(min!=i) {
				swap(min,i);
				downheapify(min);
			}
			
		}
		
		public int getPeek() {              //O(1)
			if(this.getSize()==0) {
				System.out.println("Data struct. is empty");
				return -1;
			}
			return arr.get(0);
		}
		
		public int getSize() {
			return arr.size();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
