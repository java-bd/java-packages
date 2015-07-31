import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample{
	
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
		//sout(names);
		names.remove("CSS"); // removes CSS
		//sout(names.size());

		Iterator<String> nameIterator = names.iterator();
		while(nameIterator.hasNext()){
			sout(nameIterator.next());
			//nameIterator.remove(); // Almost same result
		}
		
		// iterator gets sucked
		// so we have to renew iterator
		nameIterator = names.iterator();
		
		newLine();
		nameIterator.forEachRemaining(System.out::println);
			
		
	}
	
}