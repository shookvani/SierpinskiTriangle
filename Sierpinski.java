//import StdDraw.*;
import edu.princeton.cs.algs4.StdDraw;
import java.util.*;
import java.lang.*;
import java.awt.*;
public class Sierpinski {
	static int count =0;

    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length)   {
           return (length * Math.sqrt(3.0))/2.0;
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        // the math for computing the triangle points and the StdDraw.polygon call should be here, not sierpinski
        double root3= Math.sqrt(3);
        // draw the main middle triangle, using filledTriangle()
        double[] ax = { 0, -0.25, 0.25};
        double[] ay = { 0, (root3)/4, root3/4};
        
        Transform2D.scale(ax,ay,length);
        Transform2D.translate(ax,ay,x,y);

        StdDraw.filledPolygon(ax, ay);
        return;
        
        
    }
    public static void color(String input) {
    //Color[] colors = new Color[] {StdDraw.BLACK, StdDraw.BLUE, StdDraw.BOOK_BLUE, StdDraw.BOOK_LIGHT_BLUE, StdDraw.BOOK_RED, StdDraw.CYAN, StdDraw.DARK_GRAY, StdDraw.GRAY, StdDraw.GREEN, StdDraw.LIGHT_GRAY, StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PRINCETON_ORANGE, StdDraw.PINK, StdDraw.RED, StdDraw.YELLOW};
    	Random rand = new Random();

    	 int intone = rand.nextInt(255); 
    	 int inttwo = rand.nextInt(255); 
    	 int intthree = rand.nextInt(255); 
    	 int[] z = new int[] {intone, inttwo, intthree};



    	Scanner scan= new Scanner(System.in);
    
       
        if (input.equals("color")) {
        	


        		StdDraw.setPenColor(z[0],z[1],z[2]);

        	

        }
     

    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        // base case
        if (n == 0) return;
        
        // draw the main middle triangle, using filledTriangle
        filledTriangle(x,y,length);
        // draw the bottom left triangle
        int newn= n-1;
        double newx=x-length/4;
        double newy=y;
        double newlength=length/2;
        sierpinski(newn,newx,newy,newlength);
        // draw the bottom right triangle
        newx=x+length/4;
        sierpinski(newn,newx,newy,newlength);
        // draw the top triangle
        newx=x;
        newy=y+height(newlength);
        sierpinski(newn,newx,newy,newlength);
        count++;
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args){
        int n = (Integer.parseInt(args[0]));
        StdDraw.setCanvasSize(512, 512);

        String input="";

        Scanner scan= new Scanner(System.in);
        System.out.println("Would you like it in black or in a random color?");
        input = scan.nextLine();
        color(input);


        long startTime = System.nanoTime();
        sierpinski(n, 0.5, 0.0, 1.0);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/(10e8);
        System.out.println(duration + " = duration (s) to draw");
        
    }
}

