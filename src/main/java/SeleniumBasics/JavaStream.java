package SeleniumBasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStream {

	@Test
	public void throughCollection() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhaya");
		names.add("Adam");
		names.add("Ram");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);

			if (actual.startsWith("A")) {
				count++;

			}
		}
		System.out.println(count);
		

	}
	@Test
	public void streamFilter()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhaya");
		names.add("Adam");
		names.add("Ram");
		
		long c =names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		     //initial stream         // intermedite operation   //terminal operation
	//	stream is nothing here but collection of String , all your ArrayList will move into stream  so that  stream can process very quick and 
		//do the operation parallely
		//filter takes the condition , by which condition you want to filter this ArrayList elements and give the result
		//lamda expression -- >   LeftSide(parameter)     -> RightSide(Action you want to do on parameter)
		//here this s (variable) (parameter) will be scanning all the elements of ArrayList
		// actual and s are same in context
		//filter opertation returns true or false for condition inside 
	long d=	Stream.of("Abhijeet", "Don","Alekhaya","Adam","Ram").filter(s->
		{
			s.startsWith("A");
			//if action is more than one line we can open the brace and write like this
			
			//terminal opration only execute if it returns true , it will not work for false
			return true;
		}).count();
	System.out.println(d);
		
		//instead of creating a collection and converting to stream 
		//we can directly convert int stream by  Stream.of
		//or main logic is after converting to stream an then applying filter
		
		//there is no life for intermediate operation if there is no terminal operation
		//terminal operation will execute only if intermediate operation (filter) returns true
		
		//we can create stream by Stream.of
		//how to use filter in Stream API
	
	
	
	//How to print all the names of ArrayList
	//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));//Abhijeet //Alekhaya
	names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));//Abhijeet

	}
	@Test
	public void streamMap()
	{
		//print names which has last letter as "a" with Uppercase
		Stream.of("Abhijeet", "Don","Alekhaya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//map will modify 
		//till now we have discussed two terminal oprator limit && count()
		
		//print names which have first letter as a with uppercase and sorted
		
		//convert simple Arrays  to ArrayList
		List<String> names1=Arrays.asList("Azbhijeet", "Don","Alekhaya","Adam","Rama");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two collection above and below collection
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anjali");
		names.add("Don");
		names.add("Siya");
		names.add("Bijay");
		names.add("Shyam");
		//Merging two different lists
		//check whether Adam is present in list or not ; if present it should return true otherwise return false
		//filter() will not help 
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("Ada45m"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	@Test
	public void streamCollect()
	{
		List<String> ls = Stream.of("Abhijeet", "Don","Alekhaya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		//we will get the same output by using both ways
		 Stream.of("Abhijeet", "Don","Alekhaya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).limit(1)
		 .forEach(s->System.out.println(s));
		 
		List<Integer>values= Arrays.asList(3,2,2,7,5,1,9,7);
		
		
	//	values.stream().distinct().forEach(s->System.out.println(s));
		
		//print unique numbers from this array and sort the array
		
		values.stream().distinct().sorted().forEach(s->System.out.println(s));
		//print unique numbers from this array and sort the array and get the third value
		List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("=======================");
		System.out.println(li.get(2));
		System.out.println("=======================");
		
		
	}

}
