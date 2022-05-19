package lambdas;

import java.util.List;

public class Main {

	public static void main(String ...args) {
		FP01.printIntegerValues(List.of(1,4,5,21,2,109)); 
//		printEvenNumbers(List.of(1,4,5,21,2,109)); 
		FP01.printStringValues(List.of("Spring", "Spring Boot", "API", "Microservices")); 
		FP01.printSquareIntegerValues(List.of(1,4,5,21,2,109)); 
		
		//FP02
		List<Integer> numbers = List.of(12, 9, 4, 6, 7, 12, 15, 4); 
		int sum = FP02.addListStructured(numbers);  
		System.out.println("Sum: "+ sum + " Largest Value: " + FP02.largestInteger(numbers)); 
		System.out.println(FP02.sumOfOddIntegers(numbers)); 
		FP02.printDistinctValue(numbers); 
		System.out.println("***********"); 
		FP02.printSortedUniqueValues(numbers);
		System.out.println("***********"); 
		FP02.printSortedUniqueValues(List.of("Spring", "Spring Boot", "API", "Microservices", "1", "aaa"));
		System.out.println("***********"); 
		FP02.printComparingStrings(List.of("Spring", "Spring Boot", "API", "Microservices", "1", "aaa"));
		List<Integer> values = FP02.printSquareValAsList(numbers); 
		System.out.println(values); 
	}

}
