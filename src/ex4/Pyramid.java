package ex4;
import java.text.DecimalFormat;

import ex4.exceptionsTypes.NonPositiveValueException;

public class Pyramid implements PrismPyramid{
	
	private Shape base; //the base is of a triangle/rectangle shape
	private double height;
	private static DecimalFormat f2 = new DecimalFormat("#.#");

	public Pyramid(Shape base , double height) throws NonPositiveValueException 
	{
		if(height <=0)	throw new NonPositiveValueException();  //if we receive a wrong height we make it 0
		if(base.area()>=0) //area can't be  a negative number
		{
			this.base = base;
			this.height = height;
		}
	}
	
	@Override
	public String getBaseType() {
		return base.toString(); //to know if the base of Pyramid is triangle or rectangle
	}

	@Override
	public double volume() {	
		return (height*(base.area())*0.75);
	}

	@Override
	public double getHeight() {
		return height;
	}

	public String toString()
	{
		return ("pyramid: (base " +"shape="   + base.toString() + ") and (height=" + f2.format(height)+") " + volume());
	}
	
}
