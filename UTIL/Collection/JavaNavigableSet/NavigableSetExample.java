import java.util.NavigableSet;
import java.util.TreeSet;
import java.lang.Integer;


public class NavigableSetExample {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		NavigableSet<Integer> ns = new TreeSet<>();
		ns.add(0);
		ns.add(1);
		ns.add(2);
		ns.add(3);
		ns.add(4);
		ns.add(5);
		ns.add(6);
		NavigableSet<Integer> reverseNs = ns.descendingSet();
		// sout(ns);  // [0, 1, 2, 3, 4, 5, 6]
		// sout(reverseNs);   // [6, 5, 4, 3, 2, 1, 0]
        NavigableSet<Integer> threeOrMore = ns.tailSet(2,true); // 2 INCLUSIVE
        // sout(threeOrMore); // 2 3 4 5 6
        // sout(ns.lower(3)); // 2
        // sout(ns.higher(3)); // 4
        // sout(ns.ceiling(3)); // 3
        // sout(ns.floor(3)); // 3
        sout(ns.pollFirst()); // 0 pops first
        // sout(ns.pollLast());  // 6
        sout(ns.pollFirst()); // 1
        sout(ns); // 2 3 4 5 6

	}
}





















