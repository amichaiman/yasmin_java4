package ex4;
import java.text.DecimalFormat;

public class Rectangle implements Shape{

	private double height;
	private double width;
    private String form="Rectangle"; //the TYBE we want to use in toString 
    private static DecimalFormat f2 = new DecimalFormat("#.#");
	
	public Rectangle(double my_height,double my_width)
	{
		if( my_height>0 && my_width>0) 
		{	
			this.height=my_height;
			this.width=my_width;
		}
	}
	
	@Override
	public String getForm()
	{
		return form; //which is rectangle
	}
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setHeight(double my_height)
	{
		this.height=my_height;	
	}
	
	public void setWidth(double my_width)
	{
		this.width=my_width;	
	}
	
	@Override
	public double area()
	{
		return height*width;
	}
	
	@Override
	public double perimeter()
	{
		return (2*height+2*width);
	}
	
	@Override
	public String toString()
	{
		return (form+" with area="+ f2.format(area()) + " and perimeter=" + f2.format(perimeter()));
	}
	

	
	
	
	
	
}
