import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListExample {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

        List<Integer> subList;
        subList = list.subList(1,3);
        sout(subList); // 1 2

        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " "); // 0 1 2 3 4 5 6
        }
        System.out.println();
        newLine();
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous() + " "); // 6 5 4 3 2 1
        }



	}
}





















