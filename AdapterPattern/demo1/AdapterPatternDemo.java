package demo1;

class Rectangle
{
	public double l;
	public double w;
}

class Triangle
{
	public double base;
	public double height;
	
	public Triangle(int base,
			        int height)
	{
		this.base = base;
		this.height = height;
	}
}

/* Calculator can calculate the area of a rectangle. To calculate the area we need a
 * Rectangle input.
 */
class Calculator
{
	Rectangle rectangle;
	
	public double getArea(Rectangle rectangle)
	{
		this.rectangle = rectangle;
		return rectangle.l * rectangle.w;
	}
}

/* Calculate the area of a Triangle using CalculatorAdapter.
 * Please note here: this time our
 * input is a Triangle.
 */
class CalculatorAdapter
{
	Calculator calculator;
	Triangle triangle;
	
	public double getArea(Triangle triangle)
	{
		calculator = new Calculator();
		this.triangle = triangle;
		Rectangle rectangle = new Rectangle();
		
		// Area of Triangle = 0.5 * base * height.
		rectangle.l = triangle.base;
		rectangle.w = 0.5 * triangle.height;
		return calculator.getArea(rectangle);
	}
}

public class AdapterPatternDemo
{
	public static void main(String args[])
	{
		CalculatorAdapter calculatorAdapter = new CalculatorAdapter();
		Triangle triangle = new Triangle(20,
				                         10);
		
		System.out.println("***Adapter Pattern Demo 1***");
		
		System.out.println("Area of Triangle is: " + calculatorAdapter.getArea(triangle));
	}
}
