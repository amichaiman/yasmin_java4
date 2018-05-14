package ex4;
import java.text.DecimalFormat;

public class Triangle implements Shape{
	
	private double side1; //the three sides of triangle
	private double side2;
	private double side3;
	private String form="Triangle"; // the TYBE we wann'a use in toString
	private static DecimalFormat f2 = new DecimalFormat("#.#");
	
	public Triangle(double side1,double side2,double side3)
	{
		if(side1>0 && side2>0 && side3>0) //all sides are a positive number
		{
			if(side1+side2>side3 && side1+side3>side2 && side3+side2>side1) //the sides achieve the Triangle Inequality
			{
				this.side1=side1;
				this.side2=side2;
				this.side3=side3;
			}
		}
	}
	
	public String getForm()
	{
		return form; //which is a triangle
	}
	
	public double getSide1()
	{
		return this.side1;
	}	
	public void setSide1(double side)
	{
	 this.side1=side;	
	}
	
	
	public double getSide2()
	{
		return this.side2;
	}
	public void setSide2(double side)
	{
	 this.side2=side;	
	}
	
	
	public double getSide3()
	{
		return this.side3;
	}
	public void setSide3(double side)
	{
	 this.side3=side;	
	}


	public double area()
	{
		return Math.sqrt((side1+side2+side3)* //Heron's formula for the area of triangle
				(side1+side2-side3)*
				(side2+side3-side1)*
				(side3+side1-side2))*0.25;
	}
	
	public double perimeter()
	{
		return side1+side2+side3;
	}
	
	
	public String toString()
	{
		return (form + " with area="+ f2.format(area()) + " and perimeter=" + f2.format(perimeter()));
	}
	
	
	
	
	
	
	
	
}
