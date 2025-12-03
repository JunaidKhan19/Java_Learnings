package learnings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DemoCollectors {
	public static void main(String[] args) {
		//Collectors is a utility class
		//provides a set of methods to create common collectors.
		
		//1. Collecting to a List
		List<String> names = Arrays.asList("Junaid", "Safwan", "Arsalan", "Aabhas");
		List<String> nameStartA= names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		System.out.println(nameStartA);
		
		//2. Collecting to a Set
		List<Integer> numbersRepeated = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
		Set<Integer> numberSet = numbersRepeated.stream().collect(Collectors.toSet());
		System.out.println(numberSet);
		
		//3. Collecting to a specific collection. toCollection takes supplier arguments.
		ArrayDeque<String> specificCollection = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<String>()));
		
		//4. joining strings
		String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(","));
		System.out.println(concatenatedNames);
		
		//5. Summarizing Data : Generates statistical summary like count, sum, min, max, average,
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 7, 8, 10);
		//summarizing..() can map elements if want to perform certain tasks
		//Output is of type ..SummaryStatistics, where .. is any data-type we are using. 
		IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x)); 
		stats.getAverage();
		stats.getMax();
		stats.getMin();
		stats.getSum();
		stats.getCount();
		
		//averaging..() , counting..(), etc can directly be used to perform only that specific task
		Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
		Long count = numbers.stream().collect(Collectors.counting());
		
		//6. Grouping elements
		List<String> words = Arrays.asList("My", "name", "is", "junaid", "Hello", "java");
		// Basic Grouping : classifier for grouping based on length
		words.stream().collect(Collectors.groupingBy(String::length)); 
		
		// Grouping + Downstream Collector : classifier, downstream to do something after collecting
		words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(","))); 
		words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())); 
		
		//Grouping + Counting + Custom Map Type : classifier , custom mapping and downstream
		TreeMap<Integer, Long> treeMapWords= words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting())); 
		System.out.println(treeMapWords);
		
		//7. Partitioning elements
		//Partition elements into two groups based on predicate (True or false)
		Map<Boolean, List<String>> partitionedOnLength = words.stream().collect(Collectors.partitioningBy(x -> x.length() > 4));
		System.out.println(partitionedOnLength);
		
		//8. Mapping and Collecting.
		List<String> upperCasedWords= words.stream().collect(Collectors.mapping(String::toUpperCase, Collectors.toList()));
		System.out.println(upperCasedWords);
	}
}
