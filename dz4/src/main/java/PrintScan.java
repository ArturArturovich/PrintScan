public class PrintScan {
    
    private Object mfu = new Object();
    private volatile char action = 's';
    private int printed = 0, scanned = 0;
    
    public void printDocuments(int count){
        synchronized (mfu){
            try{
                for (int i = 0; i < count; i++) {
                    while (action != 'p') mfu.wait();
                    setPrinted (getPrinted() + 1);
                    System.out.println("распечатанно "+ getPrinted() + " страниц");
                    action = 's';
                    Thread.sleep(50);
                    mfu.notify();
                    
                }
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void scanDocuments(int count){
        synchronized (mfu){
            try{
                for (int i = 0; i < count ; i++) {
                    while (action != 's') mfu.wait();
                    setScanned(getScanned() + 1);
                    System.out.println("отсканировано " + getScanned() + " страниц");
                    action = 'p';
                    Thread.sleep(50);
                    mfu.notify();
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void copyDocuments(int count){
        new Thread(() -> this.scanDocuments(count)).start();
        new Thread(() -> this.printDocuments(count)).start();
    }

    public int getPrinted(){
        return printed;
    }

    public void setPrinted(int printed){
        this.printed = printed;
    }

    public int getScanned(){
        return scanned;
    }

    public void setScanned(int scanned){
        this.scanned = scanned;
    }
    
}
