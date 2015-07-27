/**
	Random Word Generation :
	Run this program by : 
	javac RandomWordsGeneration.java
	java RandomWordsGeneration.java <size> (e.g 10)
*/


import java.util.Random;
import java.util.ArrayList;
import java.util.Collection;

class RandomWordsGeneration{
	
	public static void main(String args[]){
		
		int size;
		
		if(args.length != 0){
			size = Integer.parseInt(args[0]);			
		} else{
			size = 10;
		}
				
		
		Random random = new Random();
        Collection<String> names = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            names.add(new String(word));
        }
		
		for(String x : names){
			System.out.println(x);
		}
		
	}
	
}