import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class SetHashSet{
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}	
	
	public static void main(String[] args){
		
				
		Collection<String> names = new ArrayList<>();
		names.add("XML");
		names.add("HTML");
		names.add("CSS");
		names.add("CSS");
		
		sout("names : " + names.size());
		Set<String> set = new HashSet<>(names);
		sout("set : " + set.size());
		sout("names : " + names.size());
		
		Set<String> mLinkedHashSet = new LinkedHashSet<>(names);
		sout("mLinkedHashnset : " + mLinkedHashSet.size());
		mLinkedHashSet.add("JAVA"); // CSS HTML XML JAVA
		set.addAll(mLinkedHashSet); // perform union 
		newLine();
		sout(set);
		mLinkedHashSet.add("C#"); // CSS HTML XML JAVA C#
		set.retainAll(mLinkedHashSet); // Perform Intersection
		newLine();
		sout(set); 
		
		newLine();
		mLinkedHashSet.removeAll(set); // perform difference
		sout(mLinkedHashSet); 
		
		newLine();
		set.add("C#");
		sout(set.containsAll(mLinkedHashSet)); // is set contains all elements of mLinkedHashSet (C#)
		
	}
	
}