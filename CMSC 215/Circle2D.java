/*

*/
// import java.util.Math;

public class Circle2D {
   private double x;
   private double y;
   private double radius;
   private double PI = 3.14;
   //Standard circle (x, y, radius) of (0, 0, 1)
   public Circle2D(){
      this(0,0,1);
   }
   //Custom circle with input x, y, radius
   public Circle2D(double x, double y, double radius){
      this.x = x;
      this.y = y;
      this.radius = radius;
   }
  
   public double getX(){
      return x;
   }
   
   public double getY(){
      return y;
   }
   
   public double getRadius(){
      return radius;
   }
   
   public double getArea(){
      return PI*radius*radius;
   }
   
   public double getPerimeter(){
      return PI*2*radius;
   }
   //Returns true if point is contained by circle, false otherwise
   public boolean contains(double x, double y){
      double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
      return distance <= radius;
   }
   //Returns true if this circle contains the given circle
   public boolean contains(Circle2D circle){
      double distanceBetweenCenters = Math.sqrt(Math.pow(circle.getX() - this.x, 2) + Math.pow(circle.getY() - this.y, 2));
      return distanceBetweenCenters + circle.getRadius() <= this.radius;
   }
   //Returns true if this circle overlaps the given circle
   public boolean overlaps(Circle2D circle){
      double distanceBetweenCenters = Math.sqrt(Math.pow(circle.getX() - this.x, 2) + Math.pow(circle.getY() - this.y, 2));
      return distanceBetweenCenters <  this.radius + circle.getRadius();
   }
   
   public static void main(String[] args){
      Circle2D testCircle1 = new Circle2D(4, 5, 6);
      //test center coordinates
      double testX = -7.1;
      double testY = -8.3;
      
      System.out.println("Circle 1:");
      System.out.println("Center: " + testCircle1.getX() + ", " + testCircle1.getY());
      System.out.println("Radius: " +
      testCircle1.getRadius());
      System.out.println(testCircle1.contains(testX, testY));
      //inner circle to test contains(Circle2D) method
      Circle2D innerCircle = new Circle2D(-6, -7, 1);
      
      System.out.println(testCircle1.contains(innerCircle));
      //overlaps circle for overlaps method test
      Circle2D overlapsCircle = new Circle2D(10, 10, 5);
      
      System.out.println(testCircle1.overlaps(overlapsCircle));

   }
}

