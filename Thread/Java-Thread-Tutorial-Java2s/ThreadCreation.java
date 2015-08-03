class ThreadCreation extends Thread{
	@Override
	public void run(){
		sout("Hello Java Thread");
	}
}
ThreadCreation tc = new ThreadCreation();
tc.start();

// Implementing the runnable interface

@FunctionalInterface
public interface Runnable{
	void run();
}

//  Java 8 Feature
Runnable aRunnableObject = () -> System.out.println("Hello Java Thread");

Thread myThread = new Thread(aRunnableObject);

myThread.start();

//----------------------------------------------------

// Using a Method Reference
// From Java 8 we can use the method reference of a method of
// any class that takes no parameters and returns void as the code
// to be executed by a thred

public class ThreadTest {
	public static void execute(){
		sout("Hello Java Thread");
	}
}
Thread myThread = new Thread(ThreadTest::execute);
myThread.start();

// Main Class Thread

public class Main{
	public static void main(String[] args){
		Thread t = new Thread(Main::print);
		t.start();
	}
	public static void print(){
		for(int i = 1; i <= 5; i++){
			sout(i + " ");
		}
	}
}

// Run multiple Thread in Main Class
public class Main{
	public static void main(String[] args){
		Thread t1 = new Thread(Main::print);
		Thread t2 = new Thread(Main::print);
		t1.start();
		t2.start();
	}
	public void print(){
		for(int i = 0; i < 5; i++){
			System.out.print(i + " ");
		}
	}
}

