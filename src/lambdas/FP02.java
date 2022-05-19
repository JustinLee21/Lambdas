package lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02 {
	protected static int sum(int a, int b) {
		//a => aggregate, b => number from stream is being added to aggregate
		System.out.println(a +" <-> "+ b); 
		return a+b; 
	}
	
	protected static int addListStructured(List<Integer> numbers) {
		return numbers.stream()
//			.reduce(0, FP02::sum); 
//			.reduce(0, (x,y)-> x = x+y); 
			.reduce(0, Integer::sum); 
	}
	
	protected static int largestInteger(List<Integer> numbers) {
		return numbers.stream()
				.reduce(Integer.MIN_VALUE, (x,y) -> x > y ? x: y); 
	}
	
	protected static int sumOfOddIntegers(List<Integer> numbers) {
		return numbers.stream()
			.map(x -> x*x*x)
			.filter(x -> x % 2 == 1)
			.reduce(0, (x,y) -> x = x+y); 
	}
	
	//print all unique values
	static void printDistinctValue(List<Integer> numbers) {
		numbers.stream()
			.distinct().forEach(System.out::println);
	}
	static void printSortedUniqueValues(List<?> values) {
		values.stream()
			.sorted()
			.forEach(System.out::println);
	}
	static void printComparingStrings(List<String> values) {
		values.stream()
			.sorted(Comparator.comparing(str -> str.length()))
			.forEach(System.out::println); 
	}
	static List<Integer> printSquareValAsList(List<Integer> values) {
		return values.stream()
			.map(v -> v * v)
			.collect(Collectors.toList()); 
	}
}
