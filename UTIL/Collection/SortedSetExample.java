import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		SortedSet<String> sortedNames = new TreeSet<>();
		sortedNames.add("JAVA");
		sortedNames.add("SQL");
		sortedNames.add("HTML");
		sortedNames.add("CSS");
		
		sout(sortedNames);		
	}
}