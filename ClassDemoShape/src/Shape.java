
public class Shape {
	private int x, y; //x and y coordinates of outline
	private double area; //area of shape
	private final static int DEFAULT_X =0;
	private final static int DEFAULT_Y = 0;
	
	/*
	 * default constructor
	 */
	
	public Shape()
	{
		init(DEFAULT_X, DEFAULT_Y);
	}
	
	public Shape(int x, int y)
	{
		init(x, y);
	}
	
	private void init(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	private void setY(int i) {
		// TODO Auto-generated method stub
		
	}

	private void setX(int i) {
		// TODO Auto-generated method stub
		
	}

	public int getX()
	{
		return x;
		
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}
