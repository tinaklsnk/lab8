public class Program {
    public static void main(String[] args) {
        double x = 0, h = 250;
        double t = System.currentTimeMillis();
        Integral integral = new Integral();
        System.out.println("f(x)=x^2");
        for (int i = 1; i <= 50; i++) {
            double x1 = h;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\tY = " + integral.integration(x, x1));
                }
            });
            thread.start();
            System.out.println(i + " threads:\t" + (System.currentTimeMillis() - t) + " ms");
            h/=2;
        }
    }
}
