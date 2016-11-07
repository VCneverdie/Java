/**
 * 
 * @author Ying Cui
 * Use regex not scanner to read file and calculate.
 *
 */

import java.io.*;
import java.util.regex.*;

public class Regex {
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("hw10a.dat"));
			String inputLine;
			while ((inputLine = br.readLine()) != null)
			{
				String pattern = "([0-9]+[\\.]*[0-9]*)\\s*([-+*/])\\s*([0-9]+[\\.]*[0-9]*)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(inputLine);
				if (m.find())
				{
					double left = Double.parseDouble(m.group(1));
					double right = Double.parseDouble(m.group(3));
					double result = 0;
					if (m.group(2).equals("+"))
						result = left + right;
					else if (m.group(2).equals("-"))
						result = left - right;
					else if (m.group(2).equals("*"))
						result = left * right;
					else if (m.group(2).equals("/"))
						result = left / right;
					System.out.println("Output = " + result);
				}
			}
			br.close();
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

}
