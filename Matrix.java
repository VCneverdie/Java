/**
 * 
 * @author Ying Cui
 *
 */
public class Matrix {
	public double[] data;
	private int rows, cols;
	
	public Matrix(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		this.data = new double[this.rows * this.cols];
		for (int i = 0; i < data.length; i++)
			this.data[i] = 0;
	}
	
	public Matrix(int n)
	{
		this.rows = n;
		this.cols = n;
		this.data = new double[this.rows * this.cols];
		for (int i = 0; i < n; i++)
			this.data[i * n + i] = 1;
		for (int i = 0; i < data.length; i++)
			if (this.data[i] != 1)
				this.data[i] = 0;
	}
	
	public void set(int i, int j, double v)
	{
		if (i >= this.rows || j >= this.cols)
			System.out.println("The position is out of range.");
		this.data[j + i * this.cols] = v;
	}
	
	public double get(int i, int j)
	{
		return this.data[j + i * this.cols];
	}
	
	public Matrix add(Matrix right)
	{
		if (this.rows != right.rows && this.cols != right.cols)
		{
			System.out.println("Matrices should in same dimension");
			return null;
		}
		Matrix result = new Matrix(this.rows, this.cols);
		for (int i = 0; i < data.length; i++)
			result.data[i] = this.data[i] + right.data[i];
		return result;
	}
	
	public Matrix sub(Matrix right)
	{
		if (this.rows != right.rows && this.cols != right.cols)
		{
			System.out.println("Matrices should in same dimension");
			return null;
		}
		Matrix result = new Matrix(this.rows, this.cols);
		for (int i = 0; i < data.length; i++)
			result.data[i] = this.data[i] - right.data[i];
		return result;
	}
	
	public String toString()
	{
		String mtr = new String();
		mtr += "[";
		for (int i = 0; i < this.rows; i++)
		{
			for (int j = 1; j <= this.cols; j++)
			{
				mtr += (this.data[j + i * cols - 1]);
				if (j + i * cols != data.length)
					mtr += "  ";
			}
			if (i != this.rows - 1)
				mtr += "\n";
			else
				mtr += "]";
		}
		return mtr;
	}
	
	public static void main(String[] args)
	{
		Matrix a = new Matrix(3, 4);
		System.out.println("The matrix is\n" + a);
		System.out.println();
		a.set(0, 2, 5.5);
		System.out.println("After set function the matrix is\n" + a);
		System.out.println();
		System.out.println("After get function we get: " + a.get(1, 1));
		System.out.println();
		Matrix b = new Matrix(3);
		System.out.println("The identity matrix is\n" + b);
		System.out.println();
		Matrix c = new Matrix(3, 3);
		for (int i = 0; i < 3; i++)
		{
			c.set(i, 0, i+2);
			c.set(i, 1, i+4);
			c.set(i, 2, i);
		}
		System.out.println("The right matrix is\n" + c);
		System.out.println();
		Matrix d = b.add(c);
		Matrix e = b.sub(c);
		System.out.println("The sum of identity matrix and right matrix is\n" + d);
		System.out.println();
		System.out.println("The subtraction of identity matrix and right matrix is\n" + e);
		System.out.println();
	}
}
