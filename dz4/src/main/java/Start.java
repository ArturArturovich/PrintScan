public class Start {

    public static void main(String[] args) {
        multithreadingABC();
        multithreadingThree();
        PrintScan();
    }

    public static void multithreadingABC(){
        final multithreadingABC a = new multithreadingABC();
        new Thread(() -> a.printA()).start();
        new Thread(() -> a.printB()).start();
        new Thread(() -> a.printC()).start();
    }

    public static void multithreadingThree(){
        final multithreadingThree b = new multithreadingThree();
        new Thread(() -> b.printToFile("thread1")).start();
        new Thread(() -> b.printToFile("thread2")).start();
        new Thread(() -> b.printToFile("thread3")).start();
    }

    public static void PrintScan(){
        PrintScan c = new PrintScan();
        c.copyDocuments(150);
    }

}
