/**
 * 
 * @author Ying Cui
 * This class is for complex numbers to do operations.
 * It contains constructor, toString method,
 * addition, subtraction, multiplication, division
 * reciprocal, square root and negative operations.
 *
 */

import java.lang.*;
public class Complex 
{
	private double real;
	private double img;
	//Constructor
	public Complex()
	{
		this(0, 0);
	}
	
	public Complex(double a, double b)
	{
		this.real = a;
		this.img = b;
	}
	//override toString method
	public String toString()
	{
		return real + " + " + img + "i";
	}
	
	//addition
	public Complex add(Complex r)
	{
		return new Complex((this.real + r.real), this.img + r.img);
	}
	
	//multiplication
	public Complex times(Complex r)
	{
		double a = this.real * r.real - this.img * r.img;
		double b = this.img * r.real + this.real * r.img;
		return new Complex(a, b);
	}
	
	//division
	public Complex div(Complex den)
	{
		if (den.real == 0 || den.img == 0)
		{
			System.out.print("The denominator should be nonzero complex number! ");
			return null;
		}
		double sqrtsum = Math.pow(den.real, 2) + Math.pow(den.img, 2);
		double a = (this.real * den.real + this.img * den.img) / sqrtsum;
		double b = (this.img * den.real - this.real * den.img) / sqrtsum;
		return new Complex(a, b);
	}
	
	//reciprocal
	public Complex rec()
	{
		if (this.real == 0 && this.img == 0)
		{
			System.out.print("There's no reciprocal number of a zero complex! ");
			return null;
		}
		double sqrtsum = Math.pow(this.real, 2) + Math.pow(this.img, 2);
		double a = this.real / sqrtsum;
		double b = -this.img / sqrtsum;
		return new Complex(a, b);
	}
	
	//square root
	public Complex sqrt()
	{
		if (this.img == 0)
		{
			System.out.print("The imagination part cannot be zero! ");
			return null;
		}
		double sqrtsum = Math.pow(this.real, 2) + Math.pow(this.img, 2);
		double a = Math.sqrt((this.real + sqrtsum) / 2);
		double b = Integer.signum((int)this.img) * Math.sqrt((-this.real + sqrtsum) / 2);
		return new Complex(a, b);
	}
	
	//negative operation
	public Complex neg()
	{
		return new Complex(-this.real, -this.img);
	}
	
	public static void main(String[] args) 
	{
		Complex a = new Complex();
		Complex b = new Complex(5, 10);
		Complex c = new Complex(4, 6);
		System.out.println("a = " + a);		
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("b + c = " + b.add(c));
		System.out.println("b - c = " + b.add(c.neg()));
		System.out.println("a * b = " + a.times(b));
		System.out.println("b * c = " + b.times(c));
		System.out.println("b / a = " + b.div(a));
		System.out.println("b / c = " + b.div(c));
		System.out.println("The reciprocal number of a is " + a.rec());
		System.out.println("The reciprocal number of b is " + b.rec());
		System.out.println("The square root of a is " + a.sqrt());
		System.out.println("The square root of b is " + b.sqrt() + " and " + b.sqrt().neg());
		System.out.println("-b = " + b.neg());
	}

}
