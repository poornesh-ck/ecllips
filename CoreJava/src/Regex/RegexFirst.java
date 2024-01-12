package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class RegexFirst {
	public static void main(String args[]) {
//		Pattern p=Pattern.compile("..hd");
//		Matcher m=p.matcher("ythd");
//		System.out.println(m.matches());
//		System.out.println(Pattern.matches("..hg", "adhg"));
		String s="anagram";
		Map<Character,Integer> l1=new LinkedHashMap<>();
		char s1[]=s.toCharArray();	
		for(int i=0;i<s1.length;i++) {
			if(!l1.containsKey(s1[i])) {
				l1.put(s1[i], 0);
			}
			else {
				int temp=l1.get(s1[i]);
				l1.put(s1[i], temp);
			}
		}
		
	}

}
