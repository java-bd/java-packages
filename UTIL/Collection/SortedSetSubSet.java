import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SortedSetSubSet {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		
		SortedSet<String> names = new TreeSet<>();
		names.add("HTML");
		names.add("JAVA");
		names.add("SQL");
		names.add("CSS");
		
		sout("Sorted Set : " + names);
		sout("First : " + names.first());
		sout("Last : " + names.last());
		
		// [CSS, HTML, JAVA, SQL]
		
		// sorted set before JAVA 
		// Head set
		// INCLUSIVE JAVA
		sout(names.headSet("JAVA"));
		
		
		
		// inclusive "CSS" & exclusive "SQL"
		SortedSet<String> ssBetwenCSSAndHTML = names.subSet("CSS", "SQL"); 
		sout(ssBetwenCSSAndHTML);
		
		// Tail SET
		// INCLUSE CSS
		sout(names.tailSet("CSS"));
		
		
		
	}
	
}





















