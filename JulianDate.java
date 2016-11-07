/**
 * 
 * @author Ying Cui
 * In this program, I pick Jan.1st, 2000 as the base date. It means julianDate of Jan.1st, 2000 equals 0. 
 * In other words, this program is only for compute date after Jan 1st.2000.
 * 
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class JulianDate {
	private int julianDate;
	private static String[] monthNames = {
			"Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public static boolean isLeapYear(int year)
	{
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}
	// Constructor
	public JulianDate(int year, int mon, int day)
	{
		int leapYear = 0, mon30 = 0, mon31 = 0;
		// Leap year
		for (int i = 2000; i < year; i++)
		{
			if (isLeapYear(i))
				leapYear++;
		}
		// Day of month
		for (int i = 1; i < mon; i++)
		{
			if (i == 4 || i == 6 || i == 9 || i == 11 )
				mon30++;
			else if (i == 2)
				;
			else
				mon31++;
		}
		this.julianDate = (year - 2000) * 365 + leapYear + (mon - 1) * 28 + (mon30 * 2 + mon31 * 3) + (day - 1);
	}
	public JulianDate(int julianDate)
	{
		this.julianDate = julianDate;
	}

	// Julian Date convert to Gregorian Date. dd-MM-yyyy
	public String[] toGreDate(int julianDate)
	{
		int leapYear = 0, mon30 = 0, mon31 = 0;
		int year = (julianDate + 1) / 365 + 2000;
		for (int i = 2000; i < year; i++)
		{
			if (isLeapYear(i))
				leapYear++;
		}
		int tempDay = (julianDate + 1) % 365 - leapYear;
		Calendar greCalendar = Calendar.getInstance();
		greCalendar.set(Calendar.DAY_OF_YEAR, tempDay);
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = date.format(greCalendar.getTime());
		String[] greDate = dateString.split("-");
		return greDate;
	}

	public String getYear()
	{
		String[] greDate = this.toGreDate(this.julianDate);
		return greDate[2];
	}
	public String getMonth()
	{
		String[] greDate = this.toGreDate(this.julianDate);
		return greDate[1];
	}
	public String getDay()
	{
		String[] greDate = this.toGreDate(this.julianDate);
		return greDate[0];
	}
	// Assume monday is the first day of one week.
	public int dayOfWeek()
	{
		int dayOfWeek = this.julianDate % 7 - 1;
		if (dayOfWeek == 0)
			return 7;
		else if (dayOfWeek == -1)
			return 6;
		else
			return dayOfWeek;
	}
	public String getMonthName()
	{
		int month = Integer.parseInt(this.getMonth());
		return monthNames[month - 1];
	}
	
	// Operations
	public JulianDate add(int n)
	{
		return new JulianDate(this.julianDate + n);
	}
	public JulianDate sub(int n)
	{
		return new JulianDate(this.julianDate - n);
	}
	public int sub(JulianDate d)
	{
		int diff = Math.abs(this.julianDate - d.julianDate);
		return diff;
	}
	// toString method
	public String toString()
	{
		return this.getYear() + " " + this.getMonthName() + ". " + this.getDay();
	}
	
	
	
	public static void main(String[] args)
	{
		JulianDate d1 = new JulianDate(2016, 2, 14);
		System.out.println("The julian date: " + d1.julianDate);
		System.out.println("The year: " + d1.getYear());
		System.out.println("The month: " + d1.getMonth());
		System.out.println("The month name: " + d1.getMonthName());
		System.out.println("The day: " + d1.getDay());
		System.out.println("The day of week: " + d1.dayOfWeek());
		JulianDate d2 = new JulianDate(2016, 3, 7);
		JulianDate d3 = d1.add(10);
		System.out.println("10 days after: " + d3);
		JulianDate d4 = d1.sub(11);
		System.out.println("11 days before: " + d4);
		int days = d1.sub(d2);
		System.out.println("The gap between d1 and d2: " + days);
	}
}
