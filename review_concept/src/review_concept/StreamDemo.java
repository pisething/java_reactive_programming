package review_concept;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Student> students = List.of(
				new Student("Dara", "M", 23, List.of("Java Basic","Spring Boot")),
				new Student("Thida", "F", 21, List.of("Java Basic")),
				new Student("Socheata", "F", 22, List.of("Java Advance","Spring Boot")),
				new Student("Veasna", "M", 25, List.of("Microservice","Spring Boot","Java Reactive"))
				
				
				);
		
		
		
		// get number of characters of students
//		students.stream()
//			.map(x -> x.getName())
//			.map(x -> x.length())
//			.forEach(System.out::println);
		
		//numberStream.forEach(x -> System.out.println(x));
		
		//System.out.println(numberStream);
		
		// find all subjects
		
		students.stream()
			.flatMap(x -> x.getSubjects().stream())
			.distinct()
			.forEach(x -> System.out.println(x));
		
		
		//10 -> Java Basic
		//11 -> Spring Boot
		
		Map<Integer, String> map = students.stream()
		.flatMap(x -> x.getSubjects().stream())
		.distinct()
		.collect(Collectors.toMap(x -> x.length(), Function.identity(), (a,b) -> a));
		
		System.out.println(map);

	}

}
