package doodles;


public class doodle {
	private boolean left;
	private double height;
	private String name;
	
	public doodle(boolean left, double height, String name) {
		super();
		this.left = left;
		this.height = height;
		this.name = name;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
