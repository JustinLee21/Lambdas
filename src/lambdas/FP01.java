package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//FP01 --> Functional Programming
public class FP01 {
//--> Functional Programming approach, I need to convert this list [...] of num values into a stream of values.
		
	protected static void printIntegerValues(List<Integer> vals) {
		vals.stream()
			.forEach(FP01::print);//Method Reference
//			.forEach(System.out::println); 
	}
	
	protected static void print(Object value) {
		System.out.println(value); 
	}
	
	protected static void printEvenNumbers(List<Integer> vals) {
		vals.stream()
			.filter(v -> v % 2==0)
			.forEach(System.out::println);
	}
	
	protected static void printStringValues(List<String> values) {
		values.stream()
			.filter(v -> v.contains("Spring") && v.length() < 7)
			.forEach(FP01::print);
	}
	
	protected static void printSquareIntegerValues(List<Integer> values) {
		values.stream()
			.map(v -> v * v + " ")
			.forEach(System.out::println); 
	}
	

}
