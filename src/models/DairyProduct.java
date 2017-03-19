package models;

import java.time.*;
import java.util.*;
/**
 * DairyProduct is a subclass of Product
 * 
 * a field called bestBeforeDate. It's type should be Date.
 * a constructor that takes in the date field along with the super class fields
 * an accessor and mutator (getter & setter) for the bestBeforeDate field
 * a toString method that returns the bestBeforeDate and the four super class fields(tip: use super.toString())
 * 
 * @author Niall G
 *
 */
public class DairyProduct extends Product
{
	private Date bestBeforeDate;
	
	public DairyProduct(String productName, int productCode, double unitCost, 
						boolean inCurrentProductLine, Date bestBeforeDate)
	{
		super(productName, productCode, unitCost, inCurrentProductLine);
		this.bestBeforeDate = bestBeforeDate;
	}
	
	//------------//
	//--ACCESSOR--//
	//------------//
	
	public Date getBestBeforeDate()
	{
		return bestBeforeDate;
	}
	
	//-----------//
	//--MUTATOR--//
	//-----------//
	
	public void setBeforeDate(Date beforeDate)
	{
		this.bestBeforeDate = beforeDate;
	}
	
	//------------//
	//---HELPER---//
	//------------//
	
	public String toString()
	{
		return super.toString() + "\nBes Before Date: " + bestBeforeDate;
	}
}






