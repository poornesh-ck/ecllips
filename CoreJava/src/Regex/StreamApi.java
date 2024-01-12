package Regex;
import java.util.*;
import java.util.stream.Collectors;


public class StreamApi {
	private static void main(String[] args) {
		List<Integer> l1=Arrays.asList(23,1,31,31,8,8,9,9); 
		Comparator<Integer> com=(o1,o2)->{
			if(o1>o2) {
				return -1;
			}
			return 1;
		};
		l1.sort(com);
//		int i=l1.stream().reduce(0,(c,p)->(c+p));   for sum of list
//		l1.stream().mapToInt(e->e).average().getAsDouble();  for the average of list
//		l1.stream().map(a->a*a).filter(n->n>50).mapToInt(e->e).average().getAsDouble();  for prints the average of square root of the values which are greater than 50
//		List<Integer> l2=l1.stream().filter(n->n%2==0).collect(Collectors.toList());/ for getting even numbers
//		List<Integer> l2=l1.stream().map(e->String.valueOf(e))
//			.filter(e->e.charAt(0)=='3')
//				.map(e->Integer.parseInt(e))
//					.collect(Collectors.toList());  to print number starting with 3
		
		
//		Set<Integer> s1=new HashSet<Integer>();
//		List<Integer> l2=l1.stream().filter(e->!s1.add(e)).collect(Collectors.toList());
		
//		int max=l1.stream().max(Comparator.comparing(Integer::valueOf)).get();  max
//		List<Integer> l2=l1.stream().sorted().collect(Collectors.toList());sort
//		List<Integer> l3=l1.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()); sort descnd
		
//		System.out.println(l1.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get());
		System.out.println(l1);
	}

}
