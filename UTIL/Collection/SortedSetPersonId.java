import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SortedSetPersonId {
	
	static void sout(Object line){
		System.out.println(line);
	}
	
	static void newLine(){
		sout("--------------------------------");	
	}
	
	public static void main(String[] args){
		SortedSet<Person> personById = new TreeSet<>(
			Comparator.comparing(Person::getName));
		// Use two parameter:
		// Person::getId or Person::getName
		
		
		personById.add(new Person(1,"X"));
		personById.add(new Person(2,"Z"));
		personById.add(new Person(3, "A"));
		personById.add(new Person(4, "C"));
		personById.add(new Person(4, "S")); // A duplicate person
		
		sout("Person By Name : ");
		personById.forEach(System.out::println);
		
		
	}
	
}

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object o){
		if (! (o instanceof Person) ){
			return false;
		}
		// id must be the same for two Persons to be equal
		Person p = (Person) o;
		if(this.id == p.getId()){
			return true;
		}
		return false;
	}
	@Override 
	public int hashCode(){
		return this.id;
	}
	@Override
	public String toString(){
		return "(" + id + ", " + name + ")";
	}
}






















