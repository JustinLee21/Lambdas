package lambdas;

import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {

	public static void main(String ...args) {
		//FP01
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
		
		//FP03
		Supplier<Integer> randomValue = () ->{
			Random random = new Random(); 
			return random.nextInt(1000); 
			}; 
			System.out.println(randomValue.get()); 
			
		UnaryOperator<Integer> multBy3 = (x) -> x * 3;
		
		BinaryOperator<Integer> multiplyTwoNums = (x, y) -> {
			return x*y; 
		}; 
		System.out.println(multBy3.apply(3)); 
		
		BiPredicate <Integer, String> biPredicate = (num, string)-> {
			return num > 10 && string.length() < 4; 
		}; 
		
		System.out.println(biPredicate.test(14, "hi")); 
		
		BiFunction <Integer, String, String> biFunction = (num, string)-> {
			return num < 10 && string.length() < 5 ? "We got one!": "Too Much To Handle!"; 
		}; 
		
		System.out.println(biFunction.apply(3, "Yo")); 
		
		IntBinaryOperator intBinaryOperator = (x, y)-> x+y; 
		System.out.println(intBinaryOperator.applyAsInt(4, 4)); 


	}
}


