package learningProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamUseCases {
	public static void main(String[] args) {
		List<Integer> mynumlis = new ArrayList<Integer>();
		for(int i=5;i>0;i--)
		{
			mynumlis.add(i);
		}
		Function<Integer,Double> toDoubleFunction = Integer::doubleValue;
		
		Predicate<Integer> isEvenFunction = n -> n > 0 && n%2 == 0;
		
		//UC2.1  Iterate through Stream
		mynumlis.stream().forEach(n->{
			System.out.println("Stream foreach value: "+n);
			});
		
		//UC2.2   && UC2.3
		List<Double> streamlis = mynumlis.stream()
				.map(toDoubleFunction)
				.collect(Collectors.toList());
		
		System.out.println("printing double list :"+ streamlis);
		
		//UC2.4
		List<Integer> streamlis2 = mynumlis.stream()
				.filter(isEvenFunction)
				.collect(Collectors.toList());
		
		System.out.println("printing double even list :"+ streamlis2);
		
		//UC2.5	
		Integer first = mynumlis.stream()
				.filter(isEvenFunction)
				.peek(n->System.out.println("Peek Even Number "+n))
				.findFirst()
				.orElse(null);
		System.out.println("peeked element :"+ first);
		
		//UC2.6
		Integer max = mynumlis.stream()
				.filter(isEvenFunction)
				.max(Comparator.comparing(Integer::intValue))
				.orElse(null);
		System.out.println("max element :"+ max);
		
		Integer min = mynumlis.stream()
				.filter(isEvenFunction)
				.min((n1,n2)-> n1-n2)
				.orElse(null);
		System.out.println("min element :"+ min);
		
		//UC2.7
		
		Integer sum = mynumlis.stream()
				.reduce(0,Integer::sum);
	    long count = mynumlis.stream().count();
				
		System.out.println("Avg of elements : "+ sum/count);
		
		
		//UC2.8
		boolean arealleven = mynumlis.stream().allMatch(isEvenFunction);
		boolean oneeven = mynumlis.stream().anyMatch(isEvenFunction);
		boolean noneMultOfSix = mynumlis.stream().noneMatch(n -> n > 0 && n%6 == 0);
		System.out.println("Are All Even : "+ arealleven);
		System.out.println("Is Any Even : "+ oneeven);
		System.out.println("Is any Multiple of 6 : "+ noneMultOfSix);
		
		//UC2.9
		List<Integer> sortedLis = mynumlis.stream()
				                          .sorted()
				                          .collect(Collectors.toList());
		System.out.println("printing Sorted List:"+ sortedLis);
	}
}
