package stream;

import java.util.*;
import java.util.stream.IntStream;
import stream.Member;

public class StreamExperiment {
	
	public static void main(String[] args) {
		
		List<Member> members = initializeMembers();
		
		System.out.println("Members registered in 2015 in ascending order:");
		members.stream().filter(m->m.getIdentification().startsWith("SDK2015"))
			            .sorted((m1,m2)->m1.getIdentification().compareTo(m2.getIdentification()))
						.forEach(System.out::println);	
		
		System.out.println("Premium members:");
		members.stream().filter(m->m.isPremium())
			.map(m->m.getName())
			.forEach(System.out::println);
		
		System.out.println("Average age of all members:");
		OptionalDouble averageAge = members.stream().mapToDouble(m->m.getAge()).average();	
		System.out.println(averageAge.isPresent()?averageAge.getAsDouble(): "Non-deterministic");	

		System.out.println("Sum of numbers from 1 to 1000:");		
		int total = IntStream.rangeClosed(1,1000).reduce(0, (x,y)->x+y);
		System.out.println(total);

		System.out.println("Sum of numbers from 1 to 1000:");				
        int sum = IntStream.rangeClosed(1,1000).sum();
		System.out.println(sum);
		
		System.out.println("Finding perfect numbers from 1 to 100000 with stream:");
		long startTime = System.currentTimeMillis();
		IntStream.rangeClosed(1, 100000).filter(x->isPerfectNumber(x)).forEach(System.out::println);
		long endTime = System.currentTimeMillis();
		System.out.println("Running stream in " + (endTime-startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		IntStream.rangeClosed(1, 100000).parallel().filter(x->isPerfectNumber(x)).forEach(System.out::println);
		endTime = System.currentTimeMillis();
		System.out.println("Running stream in " + (endTime-startTime) + " ms");
				
    }
	
	private static List<Member> initializeMembers() {
		Member member1 = new Member("Aaron", "SDK20160814", 40, false);
		Member member2 = new Member("Lina", "SDK20150407", 34, false);
		Member member3 = new Member("Ronan", "SDK20151226", 52, true);
		Member member4 = new Member("Brad", "SDK20140610", 28, false);
		Member member5 = new Member("Angel", "SDK20120209", 44, true);		
		
		List<Member> members = new ArrayList<Member>();
		members.addAll(Arrays.asList(member1, member2, member3, member4, member5));
		
		return members;
	}
	
	private static boolean isPerfectNumber(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
			if (sum > number) {
				return false;
			}
		}	
		
		return (sum == number);	
	}
	
}

