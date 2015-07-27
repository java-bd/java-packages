import java.util.ArrayList;

public class MultiThreadedPrimeSieveMethod {

    public static void main(String[] args) {

        int threadNumber = 40;

        ArrayList<PrimeWorkerThread> list = new ArrayList<>();

        for(int i = 0; i < threadNumber; i++){
            PrimeWorkerThread td = new PrimeWorkerThread(Integer.toString(i));
            list.add(td);
        }

        for(int i = 0; i < threadNumber; i++){
            Thread t = new Thread(list.get(i));
            t.start();
        }

    }
}
