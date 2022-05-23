package lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
	private String name; 
	private String category; 
	private int reviewScore; 
	private int numOfStudents;
	
	public Course(String name, String category, int reviewScore, int numOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.numOfStudents = numOfStudents;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name; 
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNumOfStudents() {
		return numOfStudents;
	}
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	} 
	
	@Override
	public String toString() {
		return this.name + ":" + this.reviewScore + ":" + this.numOfStudents; 
	}
	
}
public class FP04 {
	public static void main(String ...args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000), 
				new Course("Spring Boot", "Framework", 92, 18000), 
				new Course("API", "Microservices", 85, 20000), 
				new Course("Microservices", "Microservices", 98, 20000), 
				new Course("FullStack", "FullStack", 98, 20000), 
				new Course("AWS", "Cloud", 100, 20000), 
				new Course("Azure", "Cloud", 75, 25000),
				new Course("Docker", "Cloud", 81, 20000), 
				new Course("Kubernetes", "Cloud", 87, 25000)
				);
		Predicate<Course> scoresLessThan75 = (course-> course.getReviewScore() < 75); 
		Predicate<Course> scoresLessThanOrEqualTo85 = (course-> course.getReviewScore() <= 85); 
	
		System.out.println(courses.stream().allMatch(course -> course.getReviewScore() >= 75));
		System.out.println(courses.stream().noneMatch(course -> course.getReviewScore() <= 75)); 
		
		List<Course> courseNumOfStudents = courses.stream().filter(course -> course.getNumOfStudents() > 20000)
				.collect(Collectors.toList()); 
		System.out.println(courseNumOfStudents); 
		
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparingInt(Course::getNumOfStudents); 
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList())); 
		
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparingInt(Course::getNumOfStudents).reversed(); 
		System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList())); 
		
		Comparator<Course> comparingByNumOfStudentsAndNumOfReviews = Comparator.comparingInt(Course::getNumOfStudents)
				.thenComparing(Course::getReviewScore).reversed(); 
		System.out.println(courses.stream().sorted(comparingByNumOfStudentsAndNumOfReviews).collect(Collectors.toList()));
		
		Comparator<Course> namesInOrder = Comparator.comparing(Course::getName); 
		System.out.println(courses.stream().sorted(namesInOrder).collect(Collectors.toList())); 
		
		Comparator<Course> numOfStudentsOfLast7ButSkip1= Comparator.comparing(Course::getNumOfStudents).reversed(); 
		System.out.println(courses.stream().sorted(numOfStudentsOfLast7ButSkip1).limit(7).skip(1).collect(Collectors.toList())); 
		
		
		System.out.println(
				courses.stream()
					.takeWhile(course->course.getReviewScore() > 85)
					.collect(Collectors.toList())); 
		
		System.out.println(
				courses.stream()
					.dropWhile(course->course.getReviewScore() >= 85)
					.collect(Collectors.toList())); 
		
		System.out.println(courses.stream()
			.max(comparingByNumOfStudentsAndNumOfReviews)); 
		
		System.out.println(courses.stream()
				.min(comparingByNumOfStudentsAndNumOfReviews)); 
		
		System.out.println(courses.stream()
				.filter(scoresLessThan75)
				.min(comparingByNumOfStudentsAndNumOfReviews)//-> Returns a Optional.empty value.
				.orElse(new Course("Kubernetes", "Cloud", 87, 25000))); 
		
		System.out.println(courses.stream().filter(scoresLessThanOrEqualTo85)
				.mapToInt(Course::getNumOfStudents).sum()); 
		
		System.out.println(courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))); 
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
						Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))); 
		
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName, Collectors.toList())))); 
		

	}
	

}
