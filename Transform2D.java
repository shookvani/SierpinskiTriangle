import edu.princeton.cs.algs4.StdDraw;
public class Transform2D {

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] array2= new double[array.length];
        
        for (int i=0; i<array.length; i++) {
            array2[i]= array[i];
        
        }
        return array2;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        
        for (int i=0; i<x.length;i++) {
            x[i]=x[i] * alpha;
            y[i]=y[i] * alpha; 
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        
        for (int i=0; i<x.length;i++) {
            x[i]=x[i] + dx;
            y[i]=y[i] + dy; 
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        
        for (int i=0; i<x.length;i++) {
            double xi = x[i];
            x[i]=x[i] * Math.cos(Math.toRadians(theta)) - y[i] * Math.sin(Math.toRadians(theta));
            y[i]=y[i] * Math.cos(Math.toRadians(theta)) + xi * Math.sin(Math.toRadians(theta)); 
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, +5.0);
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };
        double theta = 45.0;
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);
        translate(x,y,1.0,1.0);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);
    }
        
}