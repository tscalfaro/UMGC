/*@Author Tara Smith
 * 8/19/23
 * CMSC 215 6381
 * 
 *******************************************************
 * -double x                                           *
 * -double y                                           *
 * -double radius                                      *
 *******************************************************
 * +Default circle (0,0,1) double                      *
 * +Constructed circle (x,y,r) double                  *
 * +get x double                                       *
 * +get y double                                       *
 * +get radius double                                  *
 * +get Area double                                    *
 * +get Perimeter double                               *
 * +contains(double x, double y) boolean               *
 * +contains(Circle2D circle) boolean                  *
 * +overlaps(Circle2D circle) boolean                  *
 *******************************************************
 */




package Circle2D;

public class Circle2D {
	
	private double x;
	private double y;
	private double radius;

	public Circle2D() {
		this(0,0,1);
	}
			
	public Circle2D(double x, double y, double radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI*Math.pow(radius, 2);
	}
	
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}
	
	public boolean contains(double x, double y) {
		return Math.sqrt(Math.pow(x - this.x, 2) + 
				Math.pow(y - this.y, 2))
				< radius;
	}

	public boolean contains(Circle2D circle) {
		return Math.sqrt(Math.pow(circle.getX() - x, 2) + 
				Math.pow(circle.getY() - y, 2))
				<= Math.abs(radius - circle.getRadius());
	}
	
	public boolean overlaps(Circle2D circle) {
		return Math.sqrt(Math.pow(circle.getX() - x, 2) + 
				Math.pow(circle.getY() - y, 2))
				<= radius + circle.getRadius();
	}
	
}
