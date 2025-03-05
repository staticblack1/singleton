import java.lang.Runnable;
import java.lang.Thread;

public class main implements Runnable {
    private String threadHame;

    public main(String name) {
        this.threadHame = name;
    }
    public static void main(String[] args) {
        Thread[] ta = new Thread[10];
        for (int i=0; i<10; i++) {
           ta[i] = new Thread(new main("THREAD_"+i));
        }
        for (int i=0; i<10; i++) {
            ta[i].start();
        }
    }
    @Override
    public void run() {
       // LazyInitializedSingleton lis = LazyInitializedSingleton.getInstance();
       // System.out.printf("Hello World from %s: code: %d%n", this.threadHame, lis.hashCode());
        ThreadSafeSingleton tis = ThreadSafeSingleton.getInstance();
        System.out.printf("Hello World from %s: code: %d%n", this.threadHame, tis.hashCode());
    }
}
