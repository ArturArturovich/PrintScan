import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class multithreadingThree {

    private Object m = new Object();

    public void printToFile(String s){
        for (int i = 0; i < 10 ; i++) {
            synchronized (m){
                try(BufferedWriter writer = new BufferedWriter(new FileWriter("FWTEST.txt", true))){
                    writer.write(s);
                    writer.newLine();
                    System.out.println(s + " printing");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
