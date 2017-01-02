package string;

import java.util.StringJoiner;
import java.util.stream.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class StringExperiment {
	
	public static void main(String[] args) {
		StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
		IntStream.iterate(0, i -> i+2).limit(10).forEach(i -> stringJoiner.add(String.valueOf(i)));
		System.out.println(stringJoiner.toString());
		
		String names = String.join("-", "Allan", "Bella", "Craig", "Dennis");
		System.out.println(names);
		
        List<String> nameList =  Arrays.asList("Allan", "Bella", "Craig", "Dennis");
		String listOfName = String.join("-", nameList);
		System.out.println(names.equals(listOfName));
	}
	
}