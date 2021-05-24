public class Integral {
    public Integral() { }
    public double integration(double x0, double x1) {
        double y = Math.pow(x1, 3)/3 - Math.pow(x0, 3)/3;
        return y;
    }
}