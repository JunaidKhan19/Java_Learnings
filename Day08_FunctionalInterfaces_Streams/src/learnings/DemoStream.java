package learnings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoStream {
	public static void main(String[] args) {
		//a stream is a sequence of elements supporting functional and declarative programming
		//Streams feature was introduced in java 8
		//It helps processing collections of data in a functional and declarative manner
		//Simplify data processing without loops 
		//Implement functional programming
		//Improve readability and maintainability
		//Enables easy Parallelism without using threading
		
		/* Key Rule of Java Streams
		   -> A Stream can be used only once.	
		   -> After you call a terminal operation such as:
		   		- forEach()
		   		- collect()
		   		- reduce()
		   		- count()
		   		- toArray()
		   		- min(), max(), etc.
		     the stream becomes closed and cannot be used again.
		*/
		
		//How to use Streams?
		//Source, intermediate operation, terminal operation,
		
	//-> Source : it is the collection or series
		//1. From collections to stream
		List<String> students = Arrays.asList("Safwan", "Junaid", "Aabhas", "Arsalan");
		Stream<String> studentStream = students.stream();
		
		//2. From Arrays to stream
		String[] alphabets = {"b", "d", "a", "c"};
		Stream<String> alphabetsStream = Arrays.stream(alphabets);
		
		//3. Using Stream.of();
		Stream<Integer> numberStream = Stream.of(1, 2, 3, 4, 5, 6);
		
		//4. Infinite streams using generate and iterate
		//generate : Generate uses supplier
		Stream<Integer> generateNumber1Infinite = Stream.generate(()-> 1); //infinite. 
		
		//iterate : Iterate uses UnaryOperator or Predicate. Just iterates doesn't prints
		Stream<Integer> iterateInfinite = Stream.iterate(1, x -> x+1); //infinite. Iterate having UnaryOperator and requires limit
		Stream<Integer> iterate1Till100 = Stream.iterate(1, n -> n <= 100, n -> n + 1); //till 100. Iterate having predicate
		
	//-> Intermediate operations : it is a task performed on the stream and transform into another stream based on task
		//They are lazy i.e don't execute until terminal operation is invoked
		//example: limit() filter(), map(), sorted(), distinct(), skip(), peek()
		
		//1. limit() : It truncates the stream to first n elements only into another stream
		Stream<Integer> generateNumber1 = Stream.generate(()-> 1).limit(50); //till limit
		//Stream<Integer> generateNumber1 = generateNumber1Infinite.limit(50); // previously generated stream
		
		Stream<Integer> iterateFinite = Stream.iterate(1, x -> x+1).limit(50); //till limit. Just iterates doesn't prints
		//Stream<Integer> iterateFinite = iterateInfinite.limit(50);
		
		
		//2. filter() : applies predicate conditions on a stream and converts it to another stream
		Stream<String> studentsWithJ= studentStream.filter(x -> x.toLowerCase().startsWith("j")); 
		
			// other operations can be further applied
		Stream<String> studentsWithA= students.stream().filter(x -> x.toLowerCase().startsWith("a")).limit(10); 
		//Note : no filtering done yet, requires terminal operation to invoke and get executed
		
		
		//3. map() : applies function conditions on a stream and converts it to another stream
		//Stream<String> alphabetsUpperCased = alphabetsStream.map(x -> x.toUpperCase()); // with lambda 
		Stream<String> alphabetsUpperCased = alphabetsStream.map(String::toUpperCase); // with method reference 
		
			// other operations can be further applied
		Stream<String> alphabetsUpperCasedLimit = Arrays.stream(alphabets).map(x -> x.toUpperCase()).limit(2);
		
		
		//4. sorted() : sorts the elements in their natural order
		Stream<String> alphabetsSorted = Arrays.stream(alphabets).sorted();
			// other operations can be further applied
		Stream<String> alphabetsUpperCasedSorted = Arrays.stream(alphabets).map(x -> x.toUpperCase()).sorted();
			//we can provide a comparator in it too
		Stream<String> studentsSortedOnLength = students.stream().sorted((a, b) -> a.length() - b.length());
		
		
		//5. distinct() : takes distinct elements from a stream into another stream
		Stream<String> distinctStudentsNames = students.stream().distinct(); 
			// other operations can be further applied
		Stream<String> limitedDistinctStudents = distinctStudentsNames.limit(10);
		
		
		//6. skip() : skips some elements and gives another stream
		Stream<Integer> numbersSkipped =  iterate1Till100.skip(10);
		
		
		//7. peek() : performs an action on the elements as it is consumed. 
		//Debugging a stream flow, Debugging filters/maps/sorting, Logging each element before/after an operation
		List<Integer> nums = List.of(1, 2, 3, 4, 5);
		nums.stream().peek(n -> System.out.println("Before filter: " + n)).filter(n -> n % 2 == 0).peek(n -> System.out.println("After filter: " + n));
		
		//8. flatMap() : 
		//handles stream of collection, array or lists where each element itself is a group of elements
		//Flattens nested structures so that they can be processed as a single structure. Transforms and flattens.
		List<List<String>> fruitsNested = Arrays.asList(
				Arrays.asList("apple", "mango"),
				Arrays.asList("guava", "chicku"),
				Arrays.asList("banana", "grapes")
		);
		fruitsNested.get(1).get(1); //retrieving from nested form
		fruitsNested.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList(); //Transformed nested into single(flattened) list		
		
		List<String> sentences = Arrays.asList(
				"Hello world",
				"My name is junaid",
				"Currently learning java"
		);
		sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).toList(); //split sentences as individual words
				
		
	//-> Terminal operations : it is a task performed on the stream after Intermediate operation
		//Helps to execute Intermediate operation by invoking them and then executing itself too
		//example: collect(), toList(), forEach(), reduce(), count()
		
		//1. collect() : to collect elements. 
		//It takes Collectors based on which the elements is to be collected.(See DemoCollectors.java in this package)
		List<Integer> collectNumbersIterated = generateNumber1.limit(50).collect(Collectors.toList()); 
		System.out.println(collectNumbersIterated);
		
		List<String> collectAlphabetsSorted = alphabetsSorted.collect(Collectors.toList());
		System.out.println(collectAlphabetsSorted);
		
		//2. toList() : It is the modification of collect(Collectors.toList()). Returns unmodifiable list.
		List<String> printSortedStudents = studentsSortedOnLength.toList();
		for (String stud : printSortedStudents) {
			System.out.println(stud);
		}
		
		//3. forEach(): a consumer function. iterates over elements one after other irrespective of their order
		limitedDistinctStudents.forEach(System.out::println);
		numberStream.forEach(x -> System.out.println(x * 2));
		
		//4. reduce() : a.k.a accumulator. It combines elements to give a single result. It's default is of optional type 
		//Optional<Integer> sumOfFifty = iterateFinite.reduce((x, y) -> x+y);
		Integer sumOfFifty = iterateFinite.reduce((x, y) -> x+y).get(); // used get() for storing as type Integer
		System.out.println(sumOfFifty);
		
		//5. count() : it counts the elements in the stream.
		long countAfterSkip = numbersSkipped.count();
		System.out.println(countAfterSkip);
		
		//6. anyMatch(), allMatch(), noneMatch(): Compares the elements of the string to the predicate condition and returns boolean value.
		// Checks if any match found
		boolean isCharA = alphabetsUpperCasedSorted.anyMatch(x -> x.equals("A"));
		System.out.println(isCharA);
		
		// Checks if all matches
		boolean startsWithA = studentsWithA.allMatch(x -> x.startsWith("A"));
		System.out.println(startsWithA);
		
		//7. findFirst(), findAny()
		alphabetsUpperCased.findFirst().get();
		studentsWithJ.findAny();
		
		// anyMatch(), noneMatch(), findFirst(), findAny() are short lived methods.
		// as soon as they find something they stop further execution
		
		//8. toArray() : Converts a stream to array
		//9. min(), max() : gives min and max value from a stream

		//10. forEachOrdered : applies forEach orderly over elements in a parallel stream.
		List<Integer> orderedList = Arrays.asList(1, 4, 5, 6, 8, 9);
		orderedList.parallelStream().forEach(System.out::print); //after this the output becomes unordered
		orderedList.parallelStream().forEachOrdered(System.out::print); //this gives an ordered output
		
		/*
		Parallel Streams: 
			- It is a type of stream that enables parallel processing.
			- Allows multiple threads to process parts of stream simultaneously
			- This can significantly improve performance over a large data-set
			- workloads is distributed across multiple threads
			- Parallel streams are most effective when there is a CPU intensive task and when tasks are independent
			- they may overhead if task is simple tasks or small data set.
		*/
		//.sequential() : to sequentially process a parallel stream from that moment
		
		//Performing operations
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5); // Source
		numbers.stream().filter(x -> x % 2 == 0).count(); //Q1 counting even numbers
		System.out.println(numbers.stream().filter(x -> x % 2 == 0).count());
		
		numbers.stream().filter(x -> x % 2 != 0).count(); //Q2 counting odd numbers
		System.out.println(numbers.stream().filter(x -> x % 2 != 0).count());
	}

}
