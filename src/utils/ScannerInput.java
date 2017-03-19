package utils;

import java.util.Scanner;

public class ScannerInput 
{
	@SuppressWarnings("resource")
	public static int validNextInt(String prompt)
	{
		Scanner input = new Scanner(System.in);
		do
		{
			try
			{
				System.out.print(prompt);
				return Integer.parseInt(input.next());
			}
			catch(Exception e)
			{
				input.nextLine(); //buffer bug
				System.err.println("\tEnter a number please:");
			}
		}
		while(true);
	}
	
	@SuppressWarnings("resource")
	public static double validNextDouble(String prompt)
	{
		Scanner input = new Scanner(System.in);
		do
		{
			try
			{
				System.out.print(prompt);
				return Double.parseDouble(input.next());
			}
			catch (Exception e)
			{
				input.nextLine(); //buffer bug
				System.err.println("\tEnter a decimal number please:");
			}
		}
		while(true);
	}
	
}
