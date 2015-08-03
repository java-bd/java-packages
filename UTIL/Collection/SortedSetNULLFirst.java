import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SortedSetNULLFirst {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		
		// Sort the names based on their length, placing null first
		
		SortedSet<String> names = new TreeSet<>(Comparator.nullsFirst(Comparator
			.comparing(String::length)));
		names.add("HTML");
		names.add("JAVA");
		names.add("SQL");
		names.add("CSS");
		names.add(null); // Adds a null
		
		names.forEach(System.out::println);		
	}
	
}





















