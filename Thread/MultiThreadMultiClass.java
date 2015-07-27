//   _ _      __   ___  ____       __  _ ____
//  / / |    / /  / _ \| ___|     / / / | ___|
//  | | |   / /  | | | |___ \    / /  | |___ \
//  | | |  / /   | |_| |___) |  / /   | |___) |
//  |_|_| /_/     \___/|____/  /_/    |_|____/
//
class Narsingdi {
    public static void narsingdi() {
        Thread narsingdiThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("Narsingdi Thread");
                Dhaka dhaka = new Dhaka();
                dhaka.dhaka();
            }
        });
        narsingdiThread.start();
        // System.out.println("Narsingdi Thread.ID : " + narsingdiThread.getId());

    }
}

class Gazipur {
    public static void gazipur() {
        Thread gazipurThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("Gazipur Thread");
                Narsingdi narsingdi = new Narsingdi();
                narsingdi.narsingdi();
            }
        });
        gazipurThread.start();
        // System.out.println("Gazipur Thread.ID : " + gazipurThread.getId());
    }
}

class Dhaka {
    public static void dhaka() {
        Thread dhakaThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Dhaka Thread");
            }
        });
        dhakaThread.start();
        // System.out.println("Dhaka Thread.ID : " + dhakaThread.getId());
    }

    public class Gulshan {
        public void gulshan() {
            Thread gulshanThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Gulshan Thread");
                }
            });
            gulshanThread.start();
        }
    }
}

public class MultiThreadMultiClass {

    public static void main(String[] args) {

        new Dhaka().dhaka();
    }
}