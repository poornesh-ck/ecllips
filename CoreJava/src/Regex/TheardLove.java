package Regex;

public class TheardLove {
	public static void main(String[] args) {
		String s = "";
		char[] arr = s.toCharArray();
		for(int i=0;i<arr.length;i++) {
			System.err.print(arr[i]);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
