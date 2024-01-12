package Searching;

import java.util.Arrays;

public class Binarysearch {
	public static void main(String[] args) {
		int [] a= {0,20,40,60,80,90};
		int n=40;
		System.out.println(Arrays.binarySearch(a, n));
	
//		System.out.println(binarySearch(a, n,0,a.length-1));
			
		
	}
	public static boolean binarySearch(int a[],int n,int leftIndex,int rightIndex) {
		
		
		
		if(leftIndex>rightIndex) {
			return false;
		}
		int mid =(leftIndex+rightIndex)/2;
		if (a[mid]==n) {
			return true;
		}
		else if(n<a[mid]) {
			return binarySearch(a, n,leftIndex,mid-1);
			
			
			
		}
		else {
			return binarySearch(a, n,mid+1,a.length);

			
		}
		
		
//	return false;
		
	}

}
