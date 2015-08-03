import java.util.*;

public class QueueExample {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		q.add(6);

        sout(q.element());
        sout(q.peek());
        newLine();

        q.remove();
        sout(q.element());

        q.poll();
        sout(q.element());

        q.offer(7);
        q.add(8);
        sout(q.size());

        

	}
}





















