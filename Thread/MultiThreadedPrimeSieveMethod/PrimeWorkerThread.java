import java.util.Arrays;


public class PrimeWorkerThread implements Runnable {

    String threadName;

    PrimeWorkerThread(String x){
        this.threadName = x;
    }
    int number = 10000000;
    boolean[] primes=new boolean[number];
    //set up the primesieve
    public void fillSieve() {
        Arrays.fill(primes, true);        // assume all integers are prime.
        primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
        for (int i=2;i<primes.length;i++) {
            //if the number is prime,
            //then go through all its multiples and make their values false.
            if(primes[i]) {
                for (int j=2;i*j<primes.length;j++) {
                    primes[i*j]=false;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        return primes[n];
    }


    public void run(){

        fillSieve();
        for(int i = 0; i < number; i++){
            if(primes[i] == true){
                System.out.println(i);
            }
        }

    }
}
