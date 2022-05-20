package lambdas;

import java.util.List;

class Course{
	private String name; 
	private String category; 
	private int reviewScore; 
	private int numOfStudents;
	public String getName() {
		return name;
	}
	
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
		return this.name + ":" + this.numOfStudents + ":" + this.reviewScore; 
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
				new Course("Azure", "Cloud", 91, 20000), 
				new Course("Docker", "Cloud", 81, 20000), 
				new Course("Kubernetes", "Cloud", 87, 25000)
				
				); 
	}
	

}
