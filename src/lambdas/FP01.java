package lambdas;

import java.util.ArrayList;
import java.util.List;

//FP01 --> Functional Programming
public class FP01 {
	public static void main(String ...args) {
//		printValues(List.of(1,4,5,21,2,109)); 
		printEvenNumbers(List.of(1,4,5,21,2,109)); 
	
		
		
		
//--> Functional Programming approach, I need to convert this list [...] of num values into a stream of values.
		
	}
	private static void printValues(List<Integer> vals) {
		vals.stream()
			.forEach(FP01::print);//Method Reference
//			.forEach(System.out::println); 
	}
	
	private static void print(int number) {
		System.out.println(number); 
	}
	
	private static void printEvenNumbers(List<Integer> vals) {
		vals.stream()
			.filter(v -> v % 2==0)
			.forEach(System.out::println);
	}
	

}
