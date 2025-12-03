package learnings;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {
	public static void main(String[] args) {
	//Predicates : Boolean valued function
		Predicate<String> p;
		p = s -> s.equals("Mumbai");
		System.out.println(p.test("Mumbai")); //true
		
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(5)); //false
		
		Predicate<String> startsWith = s -> s.toLowerCase().startsWith("a");
		Predicate<String> endsWith = s -> s.toLowerCase().endsWith("y");
		Predicate<String> startNEnd = startsWith.and(endsWith);
		System.out.println(startNEnd.test("Akshay"));
		
	//Function : Takes and returns
		Function<String, Integer> f;
		f = s -> s.length();
		System.out.println(f.apply("Mumbai"));
		
		Function<Integer, Integer> doubleIt = x -> x*2;
		System.out.println(doubleIt.apply(4));
		
		Function<Integer, Integer> add2 = x -> x+2;
		System.out.println(add2.apply(5));
		
		//First double and then add 2
		System.out.println(doubleIt.andThen(add2).apply(5));
		
		//First add 2 and then double it
		System.out.println(doubleIt.compose(add2).apply(5));

		
	//Consumer : takes something returns nothing 
		Consumer<String> c;
		c = str -> System.out.println(str);
		c.accept("Mumbai");
		
		Consumer<String> mssg = s -> System.out.println(s);
		mssg.accept("Printed 1, 2, 3 from consumer");
		
		List<Integer> list= Arrays.asList(1, 2, 3);
		Consumer<List<Integer>> printList = x -> {
			for (Integer num : x) {
				System.out.println(num);
			}
		};
		printList.accept(list);
		
		//Working with two Consumer of different types
		//1. Converting mssg to take list to accept the same input
		//Consumer<List<Integer>> finalConsumer = printList.andThen(l -> mssg.accept("Printed List Successfully"));
		//finalConsumer.accept(list);
		printList.andThen(l -> mssg.accept("Printed List")).accept(list); //shorter
		
		//2. make both consumers work on the same type
		//Taking the List of type Integer then mssg2 of type integer
		Consumer<List<Integer>> mssg2 = l -> System.out.println("Printed List Successfully");
		printList.andThen(mssg2).accept(list);
		
	//Supplier : Takes nothing returns something
		Supplier<String> s;
		s = () -> "Mumbai";
		System.out.println(s.get());
		
		//Combined all
		Predicate<Integer> pred = x -> x%2 == 0;
		Function<Integer, Integer> func = x -> x*10;
		Consumer<Integer> cons = x -> System.out.println(x);
		Supplier<Integer> supp = () -> 100;		
		
		if(pred.test(supp.get())) {
			cons.accept(func.apply(supp.get()));
		}
		
	//BiPredicate : predicate that takes two arguments
		BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
		System.out.println(isSumEven.test(1, 5));
		
	//BiFunction : function that takes two arguments
		BiFunction<Integer, Integer, Integer> multiplyIt = (x, y) -> x * y;
		System.out.println(multiplyIt.apply(5, 10));
		
	//BiConsumer : consumer that takes two arguments
		BiConsumer<List<Integer>, String> printThem = (x, y) -> {
			for (Integer num : x) {
				System.out.println(num);
			}
			System.out.println(y);
		};
		printThem.accept(list, "Printed list using BiConsumer");
		
	//UnaryOperator : Function if the argument type and the return type are same
		UnaryOperator<Integer> add3 = x -> x + 3;
		System.out.println(add3.apply(8));
		
	//BinaryOperator : BiFunction if both argument type and return type are same
		BinaryOperator<Integer> divideIt = (x, y) -> x/y;
		System.out.println(divideIt.apply(75, 5));
		
	//Method Reference : helps us to use methods without invoking them. It is used in place of lambda expression
	//important in streams Streams
		List<String> students = Arrays.asList("Junaid", "Safwan", "Arsalan", "Aabhas");
		//students.forEach(x -> System.out.println(x)); //Lambda
		students.forEach(System.out::println); //Method reference		
	}
}
