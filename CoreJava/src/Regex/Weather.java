package Regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {
	public static void main(String[] args) {
		String s1="{\"London\":\"Sunny\", \"Paris\":\"Cloudy\", \"Berlin\":\"Rain\"}";
		String s2="{\"London\":\"Cloudy\", \"Paris\":\"Cloudy\", \"Berlin\":\"Sunny\"}";
		Map<String, String> m1=new HashMap<String, String>();
		Map<String, String> m2=new HashMap<String, String>();
		Pattern p =Pattern.compile("\\w+");
		Matcher m= p.matcher(s1);
		Matcher mw=p.matcher(s2);
		List<String> set1=new ArrayList<String>();
		List<String> set2=new ArrayList<String>();
		
		while(m.find()) {
			set1.add(m.group());
//			System.out.println();

		}
		while(mw.find()) {
			set2.add(mw.group());
//			System.out.println();

		}
		
		
	Set<String> sd=new TreeSet<String>();
		for(int i=1;i<set1.size()+1;i+=2) {
			if(!set1.get(i).equals(set2.get(i))) {
				sd.add("\""+set1.get(i-1)+"\"");
//				System.out.println("\""+sd+"\"");
			}
			
		}
		
		System.out.println(sd);
		
		
		
		
	}

}
