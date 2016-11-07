/**
 * @author VCneverdie
 * class
 * object
 * message: things you say to the object. doesn't return
 * method
 */
import processing.core.PApplet;

public class Processing3Test extends PApplet // it's a class from processing
{
	public void settings()
	{
		size(600, 600);
	}
	
	public void draw()
	{
		line(0, 0, 100, 100);
	}
	public static void main(String args[])
	{
		String[] a = {"MAIN"}; //array of string, create processing
		PApplet.runSketch(a, new Processing3Test());
	}
}
