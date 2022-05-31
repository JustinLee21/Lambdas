package lambdas;

import java.util.List;
import java.util.function.Supplier;

public class FP03 {
	
	public static void main(String[] args) {
	
	List<String> classes = List.of("Biology", "Chemistry", "Physics", "Astronomy"); 
	
	//Method references on the String and FP03 class
	classes.stream()
		.map(String::toUpperCase)
		.forEach(FP03::printValues);
	
	//Constructor Reference
	Supplier <String> supplier = String::new; 
	
	
	}
	
	public static void printValues(String vals) {
		System.out.println(vals); 
	}
	
	

}
