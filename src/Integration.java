import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Integration {
    static final int K = 100;
    static final double H = 0.1;
    protected static final Thread[] threads = new Thread[K];
    public static Integral integral = new Integral();
    public static double x1 = 0, x2 = 0.1;
    public static List<Double> time = new ArrayList<>();
    static double t = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        createThreads();
        startThreads();
    }

    public static void createThreads() throws IOException {
        PrintWriter writer = new PrintWriter("text.csv");
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                integral.integration(x1, x2);
                double curtime = System.currentTimeMillis() - t;
                System.out.println(Thread.currentThread().getName() + ":\t" + curtime + " ms");
                time.add(System.currentTimeMillis() - t);
                writer.write(String.valueOf(curtime + '\t'));
                writer.append(";");
                writer.flush();
                x2 += H;
            });
        }
    }

    public static void startThreads() {
        for (int i = 0; i < K; i++) {
            threads[i].start();
        }
    }
}

class Integral {
    public Integral() {
    }

    public double integration(double x0, double x1) {
        return Math.pow(x1, 3) / 3 - Math.pow(x0, 3) / 3;
    }
}