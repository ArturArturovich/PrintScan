public class multithreadingABC {

    private final Object obj = new Object();
    private volatile char litera = 'A';

    public void printA(){
        synchronized (obj){
            try{
                for (int i = 0; i < 5 ; i++) {
                    while (litera != 'A') obj.wait();
                    System.out.println("A");
                    litera = 'B';
                    obj.notify();
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printB(){
        synchronized (obj){
            try{
                for (int i = 0; i < 5 ; i++) {
                    while (litera != 'B') obj.wait();
                    System.out.println("B");
                    litera = 'C';
                    obj.notify();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void printC(){
        synchronized (obj){
            try{
                for (int i = 0; i < 5 ; i++) {
                    while (litera != 'C') obj.wait();
                    System.out.println("C");
                    litera = 'A';
                    obj.notify();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
