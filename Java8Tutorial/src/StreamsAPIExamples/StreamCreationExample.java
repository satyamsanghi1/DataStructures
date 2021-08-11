package StreamsAPIExamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreationExample {

	public static void main(String[] args) {
		
		
		// 1 Stream of collections
		List<Integer>l=Arrays.asList(1,2,3,4,5);
		Stream<Integer>stream=l.stream();
		
		//2 Stream of Array
		Stream<Integer>arrayStream=Stream.of(1,2,3,4);
		Stream<String>stringStream=Stream.of("a","b","c");
		
		int arr[]= {1,2,3,4};
		Arrays.stream(arr);
		
		//Stream builder 
		Stream<String>streamBuilder=Stream.<String>builder().add("1").add("2").add("3").build();
		
		//Stream Generate() method
		
		Stream<String>str=Stream.generate(()->"abc").limit(10);
		Iterator<String>iterator=str.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		//Stream.iterate() method
		
		Stream<Integer>StreamIterateed=Stream.iterate(2,(n)->n+2).limit(4);
		Iterator<Integer>iterator1=StreamIterateed.iterator();
		while(iterator1.hasNext())
			System.out.println(iterator1.next());
		
		//Stream of Primitives
		IntStream intStream=IntStream.range(1,4);
		LongStream longStream=LongStream.range(2,6);
		
		//Stream of Files
		Path path=Paths.get("");
		try {
			Stream<String>fileStream=Files.lines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
