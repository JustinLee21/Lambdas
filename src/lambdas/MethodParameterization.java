package lambdas;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MethodParameterization {
	
	public static void main(String ...args) {
	
	List<Integer> nums = List.of(1,2,3,4,5); 
	Predicate<? super Integer> evenNumbers = x->x%2 ==0;
	printEvenNumbers(nums, evenNumbers);
	
	Predicate<? super Integer> oddNumbers = x-> x%2 != 0;
	printOddNumbers(nums, oddNumbers);
	
	//Passing behavior of method as an argument --> Behavior Parameterization
	printEvenNumbers(nums, x->x%2 !=1);
	
//	Function<? super Integer, ? extends Integer> mapper = x -> x*x;
	List<Integer> squaredValues = mapAGroupOfListValues(nums, x -> x*x); 
	List<Integer> cubedValues = mapAGroupOfListValues(nums, x -> x*x*x);
	List<Integer> doubleValues = mapAGroupOfListValues(nums, x -> x+x);
	
	System.out.println(squaredValues); 
	System.out.println(cubedValues); 
	System.out.println(doubleValues); 
	
	}

	private static List<Integer> mapAGroupOfListValues(List<Integer> nums,
			Function<? super Integer, ? extends Integer> functionMapper) {
		return nums.stream()
			.map(functionMapper)
			.collect(Collectors.toList());
	}

	private static void printOddNumbers(List<Integer> nums, Predicate<? super Integer> predicateOddNumbers) {
		nums.stream()
			.filter(predicateOddNumbers)
			.forEach(System.out::println);
	}

	private static void printEvenNumbers(List<Integer> nums, Predicate<? super Integer> predicateEvenNumbers) {
		printOddNumbers(nums, predicateEvenNumbers);
	}

}
